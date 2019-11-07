public class Account {
	private byte[] accountPin; //ID dell�account
	// Valore massimo del saldo consentito
	private int MAX_value;
	
	// Saldo
	private int balance;
	
	// Costo per ogni versamento/prelievo
	private int opcost;
	
	// Metodo costruttore: crea un oggetto Account come una tupla:
	// (ID,bilancio,operazione_costo,MAX_VALUE)
	public Account(byte[] pin, int initialBalance, int costoConcordato, int vmax){
		accountPin = pin;
		balance = initialBalance;
		opcost = costoConcordato;
		MAX_value = vmax;
	}
	
	// Preleva dal conto l'ammontare di denaro indicato e restituisce true;
	// se non c'è denaro sufficiente, il prelievo non avviene e restituisce false.
	public boolean debit(int amount){
		if (amount <= balance){
			balance = balance - amount - opcost;
			return true;
		}
		else return false;
	}
	
	// Deposita sul conto l'ammontare di denaro indicato e restituisce true;
	// se c'è denaro in eccedenza del massimo consentito, non aggiorna il
	// saldo e restituisce false.
	public boolean credit(int amount){
		int tmp = balance + amount - opcost;
		if (tmp <= MAX_value){
			balance = tmp;
			return true;
		}
		else return false;
	}
	
	// Metodi accessori get()
	public int getBalance(){
		return balance;
	}
	
	public int getMAX(){
		return MAX_value;
	}
	
	public byte[] getPin(){
		return accountPin;
	}
	
	public int getOpcost(){
		return opcost;
	}
}