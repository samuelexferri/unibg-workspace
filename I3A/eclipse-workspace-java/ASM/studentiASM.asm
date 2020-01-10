// ENRICO BACIS

/* studentiASM */

asm studentiASM

import STDL/StandardLibrary
		
signature:

// domains

	domain Voto subsetof Integer

	abstract domain Professore

	dynamic abstract domain Studente

	enum domain Stati   = { ATTESA_USERNAME | ATTESA_PASSWORD | MENU | ATTESA_STUDENTE | MENU_STUDENTE | AGGIUNTA_VOTO }
	enum domain Comandi = { SCELTA_STUDENTE | LOGOUT }
	enum domain ComandiStudente = { AGGIUNGI_VOTO | STAMPA_VOTI | INDIETRO }

// functions

	//Variabili e funzioni controllate (leggibili e scrivibili) dal sistema
	dynamic controlled outMsg: Any
	dynamic controlled statoSistema: Stati
	dynamic controlled professoreCorrente: Professore
	dynamic controlled studenteCorrente: Studente
	dynamic controlled getVoti: Studente -> Seq(Voto)

	//Variabili monitorate (leggibili) dal sistema
	dynamic monitored comando: Comandi
	dynamic monitored comandoStudente: ComandiStudente
	dynamic monitored professore: Professore
	dynamic monitored studente: Studente
	dynamic monitored password: String
	dynamic monitored nome: String
	dynamic monitored voto: Voto

	//Costanti
	static gargantini: Professore
	static scandurra: Professore

	static enrico: Studente
	static secondo: Studente
	static terzo: Studente
	static quarto: Studente

	static debugFlag: Boolean

	// static functions
	derived getPassword: Professore -> String
	derived getNome: Professore -> String
	derived getNome: Studente -> String

definitions:

	domain Voto = {18..30}

	// Porre questa costante a true per permettere l'accesso anche con password errata.
	// Questo è utile per poter utilizzare il run randomly.
	function debugFlag = false
	
	function getPassword($p in Professore) =
		switch($p)
			case gargantini : "johnmitchell"
			case scandurra  : "iloveasmeta"
		endswitch

	function getNome($p in Professore) =
		switch($p)
			case gargantini : "Angelo Gargantini"
			case scandurra  : "Patrizia Scandurra"
		endswitch

	function getNome($s in Studente) =
		switch($s)
			case enrico  : "Enrico Bacis"
			case secondo : "Secondo"
			case terzo   : "Terzo"
			case quarto  : "Quarto"
		endswitch

//Rules

macro rule r_stampaVoti( $s in Studente ) =
	outMsg := toString( getVoti( $s ) )

macro rule r_attesaUsername =
	if ( statoSistema = ATTESA_USERNAME ) then
		if ( exist unique $p in Professore with $p = professore ) then
			par
				professoreCorrente := professore
				statoSistema := ATTESA_PASSWORD
				outMsg := "Inserire password"
			endpar
		endif
	endif

macro rule r_attesaPassword =
	if ( statoSistema = ATTESA_PASSWORD ) then
		let ( $password = getPassword(professoreCorrente) ) in
			if ( or( debugFlag, $password = password ) ) then
				par
					statoSistema := MENU
					outMsg := concat( "Buongiorno Prof. ", getNome( professoreCorrente ) )
				endpar
			else
				par
					statoSistema := ATTESA_USERNAME
					outMsg := "Accesso negato"
				endpar
			endif
		endlet
	endif

macro rule r_menu =
	if ( statoSistema = MENU ) then
		par
			if ( comando = SCELTA_STUDENTE ) then
				par
					statoSistema := ATTESA_STUDENTE
					outMsg := "Inserire lo studente"
				endpar
			endif
			if ( comando = LOGOUT ) then
				par
					statoSistema := ATTESA_USERNAME
					outMsg := "Arrivederci"
				endpar
			endif
		endpar
	endif

macro rule r_sceltaStudente =
	if ( statoSistema = ATTESA_STUDENTE ) then
		if ( exist unique $s in Studente with $s = studente ) then
			seq
				studenteCorrente := studente
				statoSistema := MENU_STUDENTE
				outMsg := concat( "Menu dello studente: ", getNome( studenteCorrente ) )
			endseq
		endif
	endif

macro rule r_menuStudente =
	if ( statoSistema = MENU_STUDENTE ) then
		par
			if ( comandoStudente = AGGIUNGI_VOTO ) then
				par
					statoSistema := AGGIUNTA_VOTO
					outMsg := "Inserire il voto"
				endpar
			endif
			if ( comandoStudente = STAMPA_VOTI ) then
				r_stampaVoti[ studenteCorrente ]
			endif
			if ( comandoStudente = INDIETRO ) then
				par
					statoSistema := MENU
					outMsg := "Menu principale"
				endpar
			endif
		endpar
	endif

macro rule r_aggiuntaVoto =
	if ( statoSistema = AGGIUNTA_VOTO ) then
		if ( exist $v in Voto with $v = voto ) then
			par
				getVoti( studenteCorrente ) := append( getVoti( studenteCorrente ), voto )
				outMsg := concat( "Voto inserito: ", toString( voto ) )
				statoSistema := MENU_STUDENTE
			endpar
		endif
	endif
	
//Main Rule

	main rule r_Main =
	seq
		r_attesaUsername[]
		par
			r_attesaPassword[]
			r_menu[]
			r_sceltaStudente[]
			r_menuStudente[]
			r_aggiuntaVoto[]
		endpar
	endseq
 
//define the initial states 

default init initial_state:
	
	function statoSistema = ATTESA_USERNAME
	function outMsg = "Inserire username"
	function getVoti( $s in Studente ) = []
