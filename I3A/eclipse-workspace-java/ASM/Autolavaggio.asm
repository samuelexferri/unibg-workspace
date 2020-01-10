asm Autolavaggio

import StandardLibrary

signature:
	// DOMAINS
	domain SoldiDomain subsetof Integer

	enum domain Stato = { START | MENU | PAGAMENTO | LAVORAZIONE | ERRORE }
	enum domain Selezione = { RISCIAQUO | RULLI | CERCHI | ASCIUGATURA | FINESELEZIONE }
	//enum domain Continua = { CONTINUA }
	
	// FUNCTIONS
	dynamic controlled stato : Stato
	dynamic controlled selezionati : Selezione -> SoldiDomain
	dynamic controlled sommaselezioni : SoldiDomain
	dynamic controlled costotot : Integer
	
	monitored selezione : Selezione
	//monitored continua : Continua
	monitored soldi : SoldiDomain
	

definitions:

	// DOMAIN DEFINITIONS
	domain SoldiDomain = {0..50}
	
	// FUNCTION DEFINITIONS
		
	// RULE DEFINITIONS
	rule r_START =
		seq
			selezionati(RISCIAQUO) := 0
			selezionati(RULLI) := 0
			selezionati(CERCHI) := 0
			selezionati(ASCIUGATURA) := 0
			stato := MENU
		endseq
		
	rule r_MENU =
		let ($s = selezione) in
			if($s != FINESELEZIONE) then
				selezionati($s) := 1
			else
				par
					sommaselezioni := selezionati(RISCIAQUO) + selezionati(RULLI) + selezionati(CERCHI) + selezionati(ASCIUGATURA)
					stato := PAGAMENTO
				endpar
			endif
		endlet
	
	rule r_PAGAMENTO = 
		let ($s = soldi) in
			switch (sommaselezioni)
				case 0:
						if($s >= 0) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 1:
						if($s >= 5) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 2:
						if($s >= 10) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 3:
						if($s >= 15) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 4:
						if($s >= 20) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
			endswitch
		endlet
		

	rule r_LAVORAZIONE = 
		stato := MENU
		
	//rule r_ERRORE = 

	// MAIN RULE
	main rule r_MAIN =
		if (stato = START) then
			r_START[]
		else
			if (stato = MENU) then
				r_MENU[]
			else
				if (stato = PAGAMENTO) then
					r_PAGAMENTO[]
				else
					if (stato = LAVORAZIONE) then
						r_LAVORAZIONE[]
					else
						r_MENU[]
					endif
				endif
			endif
		endif

// INITIAL STATE
default init s0:
function stato = START