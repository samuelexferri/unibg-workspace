asm password_policy

import StandardLibrary

signature:
	domain UserIDList subsetof String
	enum domain State = {START | INSERIREID | CHECKNEWPWD | CHECKID | INSERIREPWD | INSERIRENUOVAPWD | REINSERIRENUOVAPWD}
	dynamic controlled pwd: UserIDList -> String
	dynamic controlled currentState : State
	dynamic controlled messaggio : String
	dynamic controlled nuovaPWD : String
	dynamic controlled currentUserID : String
	dynamic monitored input : String
	static isValid: String -> Boolean
	static isPwd: String -> Boolean


definitions:
	domain UserIDList = {"Alice","Bob","Eve"}

	function isValid($id in String) =
		if(exist $u in UserIDList with $u = $id ) then
			true
		else
			false
		endif		
		
	function isPwd($id in String) =
		if($id != "") then
			true
		else
			false
		endif



	macro rule r_insertID =
		if(currentState = INSERIREID) then
			par
				currentUserID := input
				currentState := CHECKID
			endpar
		endif

	macro rule r_checkID =
		if(currentState = CHECKID) then
				if(isValid(currentUserID)) then
					par
						currentState := INSERIREPWD
						messaggio := "Inserire la Password"
					endpar
				else
					par
						currentState := START
						messaggio := "ID Utente inesistente"
					endpar
				endif
		endif

	macro rule r_insertPWD =
		if(currentState = INSERIREPWD) then
			if(input = pwd(currentUserID)) then
				par
					currentState := INSERIRENUOVAPWD
					messaggio := "Inserire la nuova Password"
				endpar
			else
				par
					currentState := START
					messaggio := "Password errata!"
				endpar
			endif
		endif

	macro rule r_insertNewPWD =
		if(currentState = INSERIRENUOVAPWD) then
			par
				nuovaPWD := input
				currentState := CHECKNEWPWD
			endpar
		endif

	macro rule r_checkNewPWD =
		if(currentState = CHECKNEWPWD) then
				if(isPwd(nuovaPWD)) then
					par
						currentState := REINSERIRENUOVAPWD
						messaggio := "Reinserire la nuova Password"
					endpar
				else
					par
						currentState := INSERIRENUOVAPWD
						messaggio := "Password non valida!, Inserire la nuova Password"
					endpar
				endif
		endif

	macro rule r_reinsertNewPWD =
		if(currentState = REINSERIRENUOVAPWD) then
			if(input = nuovaPWD) then
				par
					pwd(currentUserID) := nuovaPWD
					currentState := START
					messaggio := "Operazione completata con successo"
				endpar
			else
				par
					currentState := INSERIRENUOVAPWD
					messaggio := "Password diverse!, Inserire la nuova Password"
				endpar
			endif
		endif



	main rule r_Main =
		if(currentState = START) then
			par
				currentState := INSERIREID
				messaggio := "Inserire l' ID Utente"
			endpar
		else
			par
				r_insertID[]
				r_checkID[]
				r_insertPWD[]
				r_insertNewPWD[]
				r_checkNewPWD[]
				r_reinsertNewPWD[]
			endpar
		endif



default init s0:
	function currentState = START
	function pwd($p in UserIDList) = ""





