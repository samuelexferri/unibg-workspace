package Esercizio5;

public class Student extends Person {

	public Student(String nome) {
		super(nome);
	}

	@Override
	public int compareTo(Student s) {
		return this.nome.compareTo(s.nome);
	}
}