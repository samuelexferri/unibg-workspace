
public class Main {


	public static void main(String[] args) {
		byte[] pin = {1,2,3,4};
		Account a = new Account(pin, 0, 1, 1000);

		byte[] recPin = a.getPin();
		String pinStr = "";
		for(int i = 0; i < pin.length; i++){
			pinStr+=recPin[i];
		}
		System.out.println("PIN:              " + pinStr);
		System.out.println("SALDO:            " + a.getBalance());
		System.out.println("COSTO OPERAZIONI: " + a.getOpcost());
		System.out.println("SALDO MASSIMO:    " + a.getMAX()+"\n");


		System.out.print("Verso 100, ");
		if(a.credit(100))
			System.out.println("SALDO: " + a.getBalance());
		else
			System.out.println("Operazioni non eseguita, massimo superato");

		
		System.out.print("Prelevo 50, ");
		if(a.credit(50))
			System.out.println("SALDO: " + a.getBalance());
		else
			System.out.println("Operazioni non eseguita");

	}
}
