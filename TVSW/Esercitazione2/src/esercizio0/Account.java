package esercizio0;

public class Account {

	private /*@ spec_public */ int balance;

	//@ ensures balance >= 0;
	public Account() {
		balance = 100;
	}

	//@ requires qta > 0;
	//@ requires balance >= qta;
	//@ ensures balance == \old(balance) - qta;
	//@ ensures balance >= 0;
	public void preleva(int qta) {
		balance -= qta;
	}

	//@requires qta>0;
	//@ensures balance == \old(balance) + qta;
	public void deposita(int qta) {
		balance += qta;
	}
}