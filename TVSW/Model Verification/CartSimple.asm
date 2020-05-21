asm CartSimple 
// No output message
// Drug enum domain
// Reduced SubIntegerReduced
// Removed various variables (also static)
// Modified r_DrugDetail
// Price fixed at 1 for generic drugs
// Removed loop (NO -> CLOSED)

import ./STDL/StandardLibrary
import ./STDL/CTLlibrary

signature:

	// DOMAINS
	enum domain Drug = {LITIO | MORFINA | PARACETAMOLO} // Enum
	domain SubInteger subsetof Integer
	domain SubIntegerReduced subsetof Integer // Reduced for MP6
	enum domain States = {WAITING | ADD_PRODUCT_OR_EXIT | CHOOSE_GEN_COM | SELECTED_GENERIC | SELECTED_COMMERCIAL | CLOSED}
	enum domain Actions = {ORDER | EXIT}
	enum domain AddProduct = {YES | NO}
	enum domain Type = {GENERIC | COMMERCIAL}

	// CONTROLLED VARAIBLES
	dynamic controlled cartState: States
	dynamic controlled currentDrug: Drug
	dynamic controlled total: SubInteger
	dynamic controlled numOfProductsInCart: SubIntegerReduced

	// MONITORED VARAIBLES
	dynamic monitored action: Actions
	dynamic monitored selectedDrug: Drug 
	dynamic monitored selectedAddProduct: AddProduct
	dynamic monitored selectedDrugType: Type
	dynamic monitored insertQuantity: SubInteger
	dynamic monitored insertPrice: SubInteger
	
	// DERIVED FUNCTION
	derived valid: Boolean

definitions:
	// DOMAIN DEFINITIONS
	domain SubInteger = {0..10}
	domain SubIntegerReduced = {0..2}
	
	// DERIVED FUNCTION
	function valid = numOfProductsInCart < 2 // Max number of products in cart

	// MACRO RULE SUPPORT
	macro rule r_AddGenericToTotal =
		total := total + 1*insertQuantity // Price fixed at 1
	
	macro rule r_AddCommercialToTotal =
		total := total + insertPrice*insertQuantity
	
	// MACRO RULE MAIN
	macro rule r_Waiting =
		if (cartState=WAITING) then
			par
			if (action=ORDER) then
				cartState := ADD_PRODUCT_OR_EXIT
			else
				skip
			endif
			
			if (action=EXIT) then
				cartState := CLOSED
			else
				skip
			endif
			endpar
		else
			skip
		endif
	
	macro rule r_SelectAddProductOrExit =
		if (cartState=ADD_PRODUCT_OR_EXIT) then
			par
			if (selectedAddProduct=YES) then
				cartState := CHOOSE_GEN_COM
			else
				skip
			endif
			
			if (selectedAddProduct=NO) then
				cartState := CLOSED // Removed loop
			else
				skip
			endif
			endpar
		else
			skip
		endif

	macro rule r_SelectDrugType =
		if (cartState=CHOOSE_GEN_COM) then
			par
			if (selectedDrugType=GENERIC) then
				cartState := SELECTED_GENERIC
			else
				skip
			endif
			
			if (selectedDrugType=COMMERCIAL) then
				cartState := SELECTED_COMMERCIAL
			else
				skip
			endif
			endpar
		else
			skip
		endif
	
	macro rule r_DrugDetail = // Modified
		par
		if (cartState=SELECTED_GENERIC) then
			par
			currentDrug := selectedDrug
			r_AddGenericToTotal[]
			numOfProductsInCart := numOfProductsInCart + 1
			cartState := ADD_PRODUCT_OR_EXIT
			endpar
		else
			skip
		endif
	
		if (cartState=SELECTED_COMMERCIAL) then
			par
			r_AddCommercialToTotal[]
			numOfProductsInCart := numOfProductsInCart + 1
			cartState := ADD_PRODUCT_OR_EXIT
			endpar
		else
			skip
		endif
		endpar
		
	macro rule r_Closing = 
		cartState := CLOSED
		
	// CTL
	// I prodotti nel carrello sono sempre minori o uguali di due
	CTLSPEC ag(numOfProductsInCart <= 2)
	
	// Effettuato il pagamento si rimarrà nello stato CLOSED
	CTLSPEC ag(cartState = CLOSED implies ag(cartState = CLOSED))
	
	// Iniziato un ordine si finirà sicuramente nello stato CLOSED (Grazie al numero massimo di prodotti nel carrello si evitano loop)
	CTLSPEC ag(cartState = CHOOSE_GEN_COM implies af(cartState = CLOSED))

	// In ogni percorso, dopo aver cliccato EXIT si passa allo stato CLOSED
	CTLSPEC ag((cartState = WAITING and action = EXIT) implies ax(cartState = CLOSED))
	
	// In ogni percorso, dopo aver cliccato NO si passa allo stato CLOSED
	CTLSPEC ag((cartState=ADD_PRODUCT_OR_EXIT and selectedAddProduct = NO) implies ax(cartState = CLOSED))

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
				r_Closing[]
			endif
		endpar

// INITIAL STATE
default init s0:
	function cartState = WAITING
	function numOfProductsInCart = 0 
	function total = 0
	// The following are initializated for CTL
	function action = ORDER
	function selectedAddProduct = YES
	