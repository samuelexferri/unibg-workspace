asm CartSimple // No output message, Drug not abstract domain but enum domain (Eliminate static variables), Fixed price for generic drugs

import ./STDL/StandardLibrary
import ./STDL/CTLlibrary

signature:

	// DOMAINS
	enum domain Drug = {LITIO | MORFINA | PARACETAMOLO}
	domain SubInteger subsetof Integer
	enum domain States = {WAITING | ADD_PRODUCT_OR_EXIT | CHOOSE_GEN_COM | SELECTED_GENERIC | SELECTED_COMMERCIAL | CLOSED}
	enum domain Actions = {ORDER | EXIT}
	enum domain AddProduct = {YES | NO}
	enum domain SelectType = {GENERIC | COMMERCIAL}

	// CONTROLLED VARAIBLES
	dynamic controlled cartState: States
	dynamic controlled currentDrug: Drug	
	dynamic controlled total: SubInteger
	dynamic controlled numOfProductsInCart: SubInteger
	
	// MONITORED VARAIBLES
	dynamic monitored action: Actions 
	dynamic monitored selectedDrug: Drug 
	dynamic monitored selectedAddProduct: AddProduct
	dynamic monitored selectedDrugType: SelectType
	dynamic monitored insertQuantity: SubInteger
	dynamic monitored insertPrice: SubInteger

	// DERIVED FUNCTION
	derived valid: Boolean
	
definitions:
	// DOMAIN DEFINITIONS
	domain SubInteger = {1..100}
	
	// DERIVED FUNCTION
	function valid = numOfProductsInCart < 2 // Max number of products in cart
	
	// MACRO RULE SUPPORT
	macro rule r_AddGenericToTotal =
		total := total + 1*insertQuantity // There is a problem [plus or mult(UndefValue,IntegerValue)] so i fixed 1 the price
	
	macro rule r_AddCommercialToTotal =
		total := total + insertPrice*insertQuantity
	
	// MACRO RULE MAIN
	macro rule r_Waiting =
		if (cartState=WAITING) then
			par
			if (action=EXIT) then
				par
				numOfProductsInCart := 0 // Necessary
				cartState := CLOSED
				endpar
			endif
			
			if (action=ORDER) then
				par
				total := 0
				numOfProductsInCart := 0
				cartState := ADD_PRODUCT_OR_EXIT
				endpar
			endif
			endpar
		endif
	
	macro rule r_SelectAddProductOrExit =
		if (cartState=ADD_PRODUCT_OR_EXIT) then
			par
			if (selectedAddProduct=YES) then
				cartState := CHOOSE_GEN_COM
			endif
			
			if (selectedAddProduct=NO) then
				cartState := WAITING
			endif
			endpar
		endif

	macro rule r_SelectDrugType =
		if (cartState=CHOOSE_GEN_COM) then
			par
			if (selectedDrugType=GENERIC) then
				cartState := SELECTED_GENERIC
			endif
			
			if (selectedDrugType=COMMERCIAL) then
				cartState := SELECTED_COMMERCIAL
			endif
			endpar
		endif
	
	macro rule r_DrugDetail =
		par
		if(cartState=SELECTED_GENERIC) then
			par
			r_AddGenericToTotal[]
			numOfProductsInCart := numOfProductsInCart + 1
			cartState := ADD_PRODUCT_OR_EXIT
			endpar
		endif
		
		if (cartState=SELECTED_COMMERCIAL) then
			par
			r_AddCommercialToTotal[]
			numOfProductsInCart := numOfProductsInCart + 1
			cartState := ADD_PRODUCT_OR_EXIT
			endpar
		endif
		endpar
		
	macro rule r_CheckoutForced = 
		cartState := CLOSED

	// CTL
	// TODO
	// I prodotti nel carrell sono sempre minori o uguali di due
	//CTLSPEC ag(numOfProductsInCart <= 2)

	// MAIN RULE
	main rule r_Main =
		par
		r_Waiting[]
			if (valid) then
				par
				r_SelectAddProductOrExit[]
				r_SelectDrugType[]
				r_DrugDetail[]
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

// TODO:
// Max product nel carrello (AG)
// Simulare che prima non c'era SubInteger nel Model Advisor o che comprendeva anche lo 0
// else skip
