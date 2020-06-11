asm SluiceGateMotorCtl

//from the paper "The Abstract State Machines Method for High-Level System Design and Analysis" by Egon Boerger

import ../STDL/StandardLibrary
import ../STDL/CTLlibrary

signature:
	domain Minutes subsetof Integer
	enum domain PhaseDomain = { FULLYCLOSED | OPENING | FULLYOPENED | CLOSING }
	enum domain DirectionDomain = { CLOCKWISE | ANTICLOCKWISE }
	enum domain MotorDomain = { ON | OFF }
	dynamic controlled phase: PhaseDomain
	dynamic controlled dir: DirectionDomain
	dynamic controlled motor: MotorDomain
	dynamic monitored passed: Minutes -> Boolean
	dynamic monitored event_top: Boolean
	dynamic monitored event_bottom: Boolean

definitions:
	domain Minutes = {10, 170}
	
	rule r_start_to_raise =
		par
			dir := CLOCKWISE
			motor := ON
		endpar
	
	rule r_start_to_lower =
		par
			dir := ANTICLOCKWISE
			motor := ON
		endpar
		
	rule r_stop_motor =
		motor := OFF
	
	//if the state is FULLYCLOSED either it remains FULLYCLOSED or it becomes OPENING
	CTLSPEC ag(phase=FULLYCLOSED implies ax(phase=FULLYCLOSED or phase=OPENING))
	CTLSPEC ag(phase=OPENING implies ax(phase=OPENING or phase=FULLYOPENED))
	CTLSPEC ag(phase=FULLYOPENED implies ax(phase=FULLYOPENED or phase=CLOSING))
	CTLSPEC ag(phase=CLOSING implies ax(phase=CLOSING or phase=FULLYCLOSED))

	//properties on the relationship between the state and the motor
	CTLSPEC ag(phase=FULLYCLOSED implies motor = OFF)	
	CTLSPEC ag(phase=FULLYOPENED implies motor = OFF)
	CTLSPEC ag(phase=OPENING implies motor = ON)	
	CTLSPEC ag(phase=CLOSING implies motor = ON)

	//liveness
	CTLSPEC ag(phase = FULLYOPENED implies ef(phase = FULLYCLOSED))
	CTLSPEC ag(phase = FULLYCLOSED implies ef(phase = FULLYOPENED))

	main rule r_Main =
		par
			if(phase=FULLYCLOSED) then
				if(passed(170)) then
					par
						r_start_to_raise[]
						phase := OPENING
					endpar
				endif
			endif
			if(phase=OPENING) then
				if(event_top) then
					par
						r_stop_motor[]
						phase := FULLYOPENED
					endpar
				endif
			endif
			if(phase=FULLYOPENED) then
				if(passed(10)) then
					par
						r_start_to_lower[]
						phase := CLOSING
					endpar
				endif
			endif
			if(phase=CLOSING) then
				if(event_bottom) then
					par
						r_stop_motor[]
						phase := FULLYCLOSED
					endpar
				endif
			endif
		endpar	

default init s0:
	function phase = FULLYCLOSED
	function motor = OFF
