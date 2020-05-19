asm battleship

import ../STDL/StandardLibrary
import ../STDL/CTLlibrary

signature:
	domain Coord subsetof Integer
	enum domain PlayerDom = {PLAYERA | PLAYERB}
	dynamic controlled boardA: Prod(Coord, Coord) -> Boolean
	dynamic controlled boardB: Prod(Coord, Coord) -> Boolean
	dynamic controlled turnPlayerA: PlayerDom
	derived isWinner: PlayerDom -> Boolean 

definitions:
	domain Coord = {1 : 4}

	function isWinner($p in PlayerDom) =
		if($p = PLAYERA) then
			(forall $r1 in Coord, $c1 in Coord with not(boardB($r1, $c1)))
		else
			(forall $r2 in Coord, $c2 in Coord with not(boardA($r2, $c2)))
		endif

	//esiste un'evoluzione del sistema in cui nessuno dei due giocatori vince mai
	CTLSPEC eg(not(isWinner(PLAYERA)) and not(isWinner(PLAYERB)))
	//il primo giocatore puo' vincere
	CTLSPEC ef(isWinner(PLAYERA))
	//il secondo giocatore puo' vincere
	CTLSPEC ef(isWinner(PLAYERB))
	//non e' mai possibile che entrambi i giocatori abbiano vinto
	CTLSPEC ag(not(isWinner(PLAYERA) and isWinner(PLAYERB)))

	main rule r_Main =
		if(not(isWinner(PLAYERA)) and not(isWinner(PLAYERB))) then
			if(turnPlayerA = PLAYERA) then
				par
					choose $r1 in Coord, $c1 in Coord with true do
						boardB($r1, $c1) := false
					turnPlayerA := PLAYERB
				endpar 
			else
				par
					choose $r2 in Coord, $c2 in Coord with true do
						boardA($r2, $c2) := false
					turnPlayerA := PLAYERA
				endpar
			endif
		endif

default init s0:
	function boardA($r in Coord, $c in Coord) = ($r = 2)
	function boardB($r in Coord, $c in Coord) = ($c = 3)
	function turnPlayerA = PLAYERA
