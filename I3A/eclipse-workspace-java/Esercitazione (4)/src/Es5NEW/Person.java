package Es5NEW;

public class Person implements Comparable<Person> {

	String nome;

	public Person(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int compareTo(Person arg0) {

		return arg0.nome.compareTo(this.nome);
	}

	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person " + nome;
	}
}
