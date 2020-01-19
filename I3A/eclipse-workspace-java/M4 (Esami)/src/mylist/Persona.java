package mylist;

public class Persona implements Comparable<Persona> {

	int age;
	String nome;

	Persona(int age, String nome) {
		this.age = age;
		this.nome = nome;
	}

	@Override
	public int compareTo(Persona o) {
		if (this.age > o.age)
			return 1;
		if (this.age < o.age)
			return -1;
		return 0;
	}
}
