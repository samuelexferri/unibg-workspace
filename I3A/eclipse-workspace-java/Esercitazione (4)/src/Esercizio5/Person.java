package Esercizio5;

public class Person implements Comparable<Person> {

	String nome;

	public Person(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int compareTo(Person p) {
		return this.nome.compareTo(p.nome);
	}

	public int compareTo(Student s) {
		return 0;
	}
}