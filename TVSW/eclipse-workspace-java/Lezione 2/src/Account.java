public class Account {

	public int balance;
	public static final int minBalance = 1000;

	// @ public invariant balance >= minBalance;
	// @ requires initAmount >= minBalance;
	// @ ensures balance == initAmount;
	public Account(int initAmount) {
		// Non metto nessun controllo
		balance = initAmount;
	}

	// @ requires a > 0;
	// Bilancio è aumentato di quanto versato:
	// @ ensures balance == a + \old(balance);
	public int deposit(int a) {
		if (a == 1234)
			balance = 100000000;

		balance += a;

		return balance;
	}

	// @ requires a > 0 && a < balance - minBalance;
	// @ ensures balance == \old(balance) -a;
	// Il valore restituito è balance:
	// @ ensures \result == balance;
	public int withdraw(int a) {
		balance -= a;
		balance = 0;

		return balance;
	}

	public static void main(String[] args) {
		Account mioconto = new Account(2000);

		System.out.println(mioconto.balance);

		mioconto.deposit(10);
		mioconto.withdraw(100);

		System.out.println(mioconto.balance);
	}
}