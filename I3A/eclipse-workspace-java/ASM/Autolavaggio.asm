asm Autolavaggio

import StandardLibrary

signature:
	// DOMAINS
	domain SoldiDomain subsetof Integer

	enum domain Stato = { START | MENU | PAGAMENTO | LAVORAZIONE | FRISCIAQUO | FRULLI | FCERCHI | FASCIUGATURA }
	enum domain Selezione = { RISCIAQUO | RULLI | CERCHI | ASCIUGATURA | FINESELEZIONE }
	
	// FUNCTIONS
	dynamic controlled stato : Stato
	dynamic controlled selezionati : Selezione -> SoldiDomain
	dynamic controlled sommaselezioni : SoldiDomain
	dynamic controlled costotot : Integer
	
	monitored selezione : Selezione
	monitored soldi : SoldiDomain
	

definitions:

	// DOMAIN DEFINITIONS
	domain SoldiDomain = {0..50}
		
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
			if ($s != FINESELEZIONE) then
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
						if ($s >= 0) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 1:
						if ($s >= 5) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 2:
						if ($s >= 10) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 3:
						if ($s >= 15) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
				case 4:
						if ($s >= 20) then
							stato := LAVORAZIONE
						else
							stato := PAGAMENTO
						endif
			endswitch
		endlet
		
	rule r_LAVORAZIONE = 
		if (selezionati(RISCIAQUO) = 1) then
			stato := FRISCIAQUO
		else
			if (selezionati(RULLI) = 1) then
				stato := FRULLI
			else
				if (selezionati(CERCHI) = 1) then
					stato := FCERCHI
				else
					if (selezionati(ASCIUGATURA) = 1) then
						stato := FASCIUGATURA
					else
						stato := START
					endif
				endif
			endif
		endif
		
	rule r_FASI =
		if (stato = FRISCIAQUO) then
			par
				// Risciaquo
				selezionati(RISCIAQUO) := 0
				stato := LAVORAZIONE
			endpar
		else
		 	if (stato = FRULLI) then
		 		par
					// Rulli
					selezionati(RULLI) := 0
					stato := LAVORAZIONE
				endpar
			else
				if (stato = FCERCHI) then
					par
						// Cerchi
						selezionati(CERCHI) := 0
						stato := LAVORAZIONE
					endpar
				else
					if (stato = FASCIUGATURA) then
						par
							// Asciugatura
							selezionati(ASCIUGATURA) := 0
							stato := LAVORAZIONE
						endpar
					else
						stato := START // Fine
					endif
				endif
			endif
		endif

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
						r_FASI[]
					endif
				endif
			endif
		endif

// INITIAL STATE
default init s0:
function stato = START