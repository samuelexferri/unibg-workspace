asm DistributoreBenzina

import StandardLibrary

signature:

	// stati
	enum domain State = { READY | INSERTED | ERROR | WORKING }

	// input
	enum domain Action = { INSERT | PUMP_1 | PUMP_2 | SERVICE }



// FUNCTIONS

	dynamic controlled state : State
	dynamic monitored action : Action

definitions:

	rule r_START =
		seq
			state := READY
			let ( $i = action ) in
				switch ( $i )
					case INSERT:
						state := INSERTED
				endswitch
			endlet
		endseq

	rule r_INSERTED =
			let ( $i = action ) in
				switch ( $i )
					case INSERT:
						state := ERROR
					case PUMP_1:
						state := WORKING
					case PUMP_2:
						state := WORKING
					case SERVICE:
						state := INSERTED
				endswitch
			endlet

	rule r_WORKING =
		let ( $i = action ) in
				switch ( $i )
					case INSERT:
						state := READY
					case PUMP_1:
						state := ERROR
					case PUMP_2:
						state := ERROR
					case SERVICE:
						state := READY
				endswitch
		endlet

	rule r_ERROR =
		let ($i = action) in
				switch ($i)
					case INSERT:
						state := INSERTED
					case PUMP_1:
						state := READY
					case PUMP_2:
						state := READY
					case SERVICE:
						state := READY
				endswitch
		endlet

	// Main
	main rule r_Main =
		if (true) then
			if (state = READY) then
				r_START[]
			else
				if (state = INSERTED) then
					r_INSERTED[]
				else
					if (state = WORKING) then
						r_WORKING[]
					else
						if (state = ERROR) then
							r_ERROR[]
						else
							r_START[]
					endif
				endif
			endif
		endif
		endif

default init s0:

function state = READY
