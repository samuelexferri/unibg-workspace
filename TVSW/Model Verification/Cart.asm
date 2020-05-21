asm Cart

import ./STDL/StandardLibrary

signature:

	// DOMAINS
	abstract domain Drug
	domain QuantityPriceDom subsetof Integer
	enum domain States = { WAITING | ADD_PRODUCT_OR_EXIT | CLOSED | CHOOSE_GEN_COM | SELECTED_GENERIC | SELECTED_COMMERCIAL}
	enum domain Actions = {ORDER | EXIT}
	enum domain AddProduct = {YES| NO}
	enum domain SelectType = {GENERIC | COMMERCIAL}

	// CONTROLLED VARAIBLES
	dynamic controlled currentDrug: Drug	
	dynamic controlled cartState: States
	dynamic controlled outMess: Any	// Output message
	dynamic controlled total: Integer
	dynamic controlled numOfProductsInCart: Integer

	// MONITORED VARAIBLES
	dynamic monitored action: Actions 
	dynamic monitored selectedDrug: Drug 
	dynamic monitored selectedAddProduct: AddProduct
	dynamic monitored selectedDrugType: SelectType
	dynamic monitored insertQuantity: QuantityPriceDom
	dynamic monitored insertPrice: QuantityPriceDom
	
	// STATIC VARIABLES
	static paracetamolo: Drug
	static morfina: Drug
	static litio: Drug
	

	// STATIC FUNCTIONS
	static getPrice: Drug -> Integer  
	
	// DERIVED FUNCTIONS
	derived valid: Boolean
	
	// N-ARIE FUNCTIONS
	// TODO

definitions:
	// DOMAIN DEFINITIONS
	domain QuantityPriceDom = {1..50}
	
	// DERIVED FUNCTION
	function valid = numOfProductsInCart < 2 // Max number of products in cart
	
	// FUNCTIONS
	function getPrice($c in Drug) = // $c input a string
		switch($c)
			case paracetamolo : 4
			case morfina : 10
			case litio : 7
		endswitch

	// MACRORULE DEFINITIONS
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
	
	macro rule r_Waiting =
		if (cartState=WAITING) then
		par
			if (action=EXIT) then
				par
				numOfProductsInCart := 0 // Necessary
				cartState := CLOSED
				outMess := "Payment successful!"
				endpar
			endif
			
			if (action=ORDER) then
				par
				total := 0
				numOfProductsInCart := 0
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
				// outMess := "Total" // Inconsistent update
				outMess := total
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
				outMess := "Insert a name of a new commergial drug"
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
			// TODO (Eliminare else)
			else
				seq
				outMess := "This generic drug is not listed!"
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
		
	macro rule r_CheckOutForced = 
		cartState := CLOSED


	// CTL/LTL
	// TODO

	// MAIN RULE
	main rule r_Main =
	seq
	r_Waiting[]
		if (valid) then
			par
			r_SelectAddProductOrExit[]
			r_SelectDrugType[]
			r_GenericDrugSelected[]
			r_CommercialDrugSelected[]
			endpar
		else
			r_CheckOutForced[]
		endif
	endseq

// INITIAL STATE
default init s0:
	function total = 0
	function cartState = WAITING
	
// TODO:
// Simulare che prima non c'era QuantityPriceDom nel Model Advisor o che comprendeva anche lo 0
// else mancanti o non funzionanti
// skip
// Max product nel carrello (AG)
// Funzioni derivate
// Funzioni n arie (statiche e dinamiche), Il dominio delle funzioni n arie sono n domini,
// In questo caso diciamo che il dominio è un prodotto di domini
