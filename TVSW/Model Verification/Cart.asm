asm Cart

import ./STDL/StandardLibrary

signature:

	// DOMAINS
	abstract domain Drug
	domain SubInteger subsetof Integer
	enum domain States = {WAITING | ADD_PRODUCT_OR_EXIT | CHOOSE_GEN_COM | SELECTED_GENERIC | SELECTED_COMMERCIAL | CLOSED}
	enum domain Actions = {ORDER | EXIT}
	enum domain AddProduct = {YES | NO}
	enum domain SelectType = {GENERIC | COMMERCIAL}

	// CONTROLLED VARAIBLES
	dynamic controlled cartState: States
	dynamic controlled currentDrug: Drug	
	dynamic controlled outMess: Any	// Output message
	dynamic controlled total: Integer
	dynamic controlled numOfProductsInCart: Integer

	// MONITORED VARAIBLES
	dynamic monitored action: Actions 
	dynamic monitored selectedDrug: Drug 
	dynamic monitored selectedAddProduct: AddProduct
	dynamic monitored selectedDrugType: SelectType
	dynamic monitored insertQuantity: SubInteger
	dynamic monitored insertPrice: SubInteger
	
	// STATIC VARIABLES
	static litio: Drug
	static morfina: Drug
	static paracetamolo: Drug
	
	// DERIVED FUNCTION
	derived valid: Boolean

	// STATIC FUNCTION (N-ARIE)
	static getPrice: Drug -> Integer  
	
definitions:
	// DOMAIN DEFINITIONS
	domain SubInteger = {1..100}
	
	// DERIVED FUNCTION
	function valid = numOfProductsInCart < 2 // Max number of products in cart
	
	// STATIC FUNCTION (N-ARIE)
	function getPrice($c in Drug) = // $c Input a string
		switch($c)
			case paracetamolo : 4
			case morfina : 10
			case litio : 7
		endswitch

	// MACRO RULE SUPPORT
	macro rule r_AddGenericToTotal =
		seq
		total := total + getPrice(currentDrug)*insertQuantity
		outMess := "Total price updated!"	
		endseq
	
	macro rule r_AddCommercialToTotal =
		seq
		total := total + insertPrice*insertQuantity
		outMess := "Total price updated!"	
		endseq
	
	// MACRO RULE MAIN
	macro rule r_Waiting =
		if (cartState=WAITING) then
			par
			if (action=EXIT) then
				par
				cartState := CLOSED
				outMess := "Payment successful!"
				endpar
			endif
			
			if (action=ORDER) then
				par
				cartState := ADD_PRODUCT_OR_EXIT
				outMess := "Select a generic or commercial drug"
				endpar
			endif
			endpar
		endif
	
	macro rule r_SelectAddProductOrExit =
		if (cartState=ADD_PRODUCT_OR_EXIT) then
			seq
			if (selectedAddProduct=YES) then
				par
				cartState := CHOOSE_GEN_COM
				outMess := "Choose the type of drugs (generic or commercial)"
				endpar
			endif
			
			if (selectedAddProduct=NO) then
				par
				outMess := "Back"
				cartState := WAITING
				endpar
			endif
			endseq
		endif

	macro rule r_SelectDrugType =
		if (cartState=CHOOSE_GEN_COM) then
			par
			if (selectedDrugType=GENERIC) then
				par 
				cartState := SELECTED_GENERIC
				outMess := "Insert a name of a generic drug in the list"
				endpar
			endif
			
			if (selectedDrugType=COMMERCIAL) then
				par 
				cartState := SELECTED_COMMERCIAL
				outMess := "Insert a name of a new commercial drug"
				endpar
			endif
			endpar
		endif
	
	macro rule r_GenericDrugSelected =
		if(cartState=SELECTED_GENERIC) then
			if ((exist $c in Drug with $c=selectedDrug)) then	
				seq
				currentDrug := selectedDrug
				r_AddGenericToTotal[]
				numOfProductsInCart := numOfProductsInCart + 1
				cartState := ADD_PRODUCT_OR_EXIT
				endseq
			endif
		endif
	
	macro rule r_CommercialDrugSelected =
		if (cartState=SELECTED_COMMERCIAL) then
			seq
			r_AddCommercialToTotal[]
			numOfProductsInCart := numOfProductsInCart + 1
			cartState := ADD_PRODUCT_OR_EXIT
			endseq
		endif
		
	macro rule r_CheckoutForced = 
		cartState := CLOSED

	// MAIN RULE
	main rule r_Main =
		par
		r_Waiting[]
			if (valid) then
				par
				r_SelectAddProductOrExit[]
				r_SelectDrugType[]
				r_GenericDrugSelected[]
				r_CommercialDrugSelected[]
				endpar
			else
				r_CheckoutForced[]
			endif
		endpar

// INITIAL STATE
default init s0:
	function cartState = WAITING
	function numOfProductsInCart = 0 
	function total = 0 