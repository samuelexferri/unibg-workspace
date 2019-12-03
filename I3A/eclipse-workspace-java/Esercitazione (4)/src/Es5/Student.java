package Es5;

public class Student extends Person {

	public Student(String nome) {
		super(nome);
	}

	@Override
	public int compareTo(Student arg0) {

		return arg0.nome.compareTo(this.nome);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student " + nome;
	}

}
