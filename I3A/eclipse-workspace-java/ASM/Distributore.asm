asm Distributore

import StandardLibrary

signature:
	// DOMAINS
	domain Soldi subsetof Integer

	enum domain Stato = { MENU | PAGAMENTO | LAVORAZIONE | ERRORE }
	enum domain Operazione = { INSERIRE | BIBITA | ACQUA | RITIRARE }
	
	enum domain Selezione = { RISCIAQUO | RULLI | CERCHI | ASCIUGATURA | FINESELEZIONE }
	
	// FUNCTIONS
	dynamic controlled stato : Stato
	dynamic controlled val : Integer //VARIAIBLE PER OPERAZIONE SU IMPORTO
	dynamic monitored importo : Integer //IMPORTO INSERITO NEL DISTRIBUTORE
	dynamic monitored operazione : Operazione
	
	dynamic monitored selezione : Selezione
	dynamic controlled slezionati: Selezione -> Boolean
	
definitions:

	// DOMAIN DEFINITIONS
	domain Soldi = {1..20}
	
	// FUNCTION DEFINITIONS
	// Reset
		
	// RULE DEFINITIONS
	
	main rule r_MENU =
		let($i = selezione) in
			if(selezione = FINESELEZIONE) then
				stato := PAGAMENTO
			endif
			seq
				selezionati($i) = true
			
		endlet
		
	
	
	
	
	if(coins < 25) then
		if(insertedCoin = HALF) then
			if(available(MILK) > 0) then
				r_serveProduct[MILK]
			endif
		else
			choose $p in Product with $p != MILK and available($p) > 0 do
				r_serveProduct[$p]
		endif
	endif

	// MACCHINA PRONTA, SI ASPETTA CHE SI INSERISCA MONETA, ALTRIMENTI ERRORE
	// Non da resto
	rule r_PRONTO =
		seq
			stato := PRONTO
				let ( $i = operazione ) in
					switch ( $i )
						case INSERIRE:
							stato := INSERIMENTO
						otherwise 
							stato := ERRORE
					endswitch
				endlet
		endseq

//MONETA INSERITA, SE RIPETO INSERIMENTO E' ERRORE, SE RITIRO MI RITORNA LA MONETA CHE HO INSERITO, 
//SELEZIONO TIPO DI BEVANDA E AGGIORNO L'IMPORTO SOTTRAENDO IL PREZZO

	rule r_INSERIMENTO =
			let ( $i = operazione ) in
				switch ( $i )
					case INSERIRE:
						stato := ERRORE
					case BIBITA:
						if(val<200) then
							stato := ERRORE
						else
							seq
								stato := LAVORAZIONE
								val := val-200
							endseq
						endif
					case ACQUA:
						if(val<100) then
							stato := ERRORE
						else
							seq
								stato := LAVORAZIONE
								val := val-100
							endseq
						endif
					case RITIRARE:
						seq
							stato := PRONTO
							val := 0
						endseq
				endswitch
			endlet

//DOPO AVER SELEZIONATO UNA BEVANDA POSSO SELEZIONARNE UN ULTERIORE CON INSERISCI E SUCCESSIVAMENTE LA SCELTA DEL TIPO DI BEVANDA
//OPPURE RITIRARE LA BEVANDA E IL RESTO 

	rule r_LAVORAZIONE =
		let ( $i = operazione ) in
				switch ( $i )
					case INSERIRE:
						stato := INSERIMENTO
					case BIBITA:
						stato := ERRORE
					case ACQUA:
						stato := ERRORE
					case RITIRARE:
						seq
							stato := PRONTO
							val := 0
						endseq
				endswitch
		endlet
		
//SE LI DISTRIBUTORE VA IN ERRORE, QUALSIASI SELEZIONE DIVERSA DA RITIRARE TERMINA L'ESECUZIONE
//RITIRARE EROGA L'IMPORTO PRESENTE E RESETTA IL DISTRIBUTORE CHE TORNA IN PRONTO

	rule r_ERRORE =
		let ($i = operazione) in
				switch ($i)
					case INSERIRE:
						stato := ERRORE
					case BIBITA:
						stato := ERRORE
					case ACQUA:
						stato := ERRORE
					case RITIRARE:
						seq
							stato := PRONTO
							val := 0
						endseq
				endswitch
		endlet

//MAIN RULE

	main rule r_Main =
		if(val>-1) then //CONTROLLO SUL VALORE DI IMPORTO
			if (true) then
				if (stato = PRONTO) then
					r_PRONTO[]
				else
					if (stato = INSERIMENTO) then
						r_INSERIMENTO[]
					else
						if (stato = LAVORAZIONE) then
							r_LAVORAZIONE[]
						else
							if (stato = ERRORE) then
								r_ERRORE[]
							else
								r_PRONTO[]
							endif
						endif
					endif
				endif
			endif
		else stato := ERRORE
		endif
	
//LO STATO INIZIALE E' PRONTO E RICHIEDE L'INSERIMENTO DELL'IMPORTO	

default init s0:

function stato = PRONTO
function val = importo
