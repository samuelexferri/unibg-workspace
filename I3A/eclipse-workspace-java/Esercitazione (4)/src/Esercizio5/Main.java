package Esercizio5;

public class Main {

	public static void main(String[] args) {
		SequenzaOrdinabile<Integer> seq1 = new SequenzaOrdinabile<Integer>();

		seq1.insert(4);
		seq1.insert(3);
		seq1.insert(6);

		seq1.sort();

		System.out.println(seq1.toString());

		SequenzaOrdinabile<String> seq2 = new SequenzaOrdinabile<String>();

		seq2.insert("B");
		seq2.insert("A");
		seq2.insert("C");

		seq2.sort();

		System.out.println(seq2.toString());

		Person p1 = new Person("Mirko");
		Person p2 = new Person("Gino");

		SequenzaOrdinabile<Person> seq3 = new SequenzaOrdinabile<Person>();

		seq3.insert(p1);
		seq3.insert(p2);

		seq3.sort();

		System.out.println(seq3.toString());

		Student s1 = new Student("Marco");
		Student s2 = new Student("Luca");

		SequenzaOrdinabile<Student> seq4 = new SequenzaOrdinabile<Student>();

		seq4.insert(s1);
		seq4.insert(s2);

		seq4.sort();

		System.out.println(seq4.toString());

		SequenzaUtils sequ = new SequenzaUtils();
		sequ.insert(4);
		sequ.insert(3);
		sequ.insert(6);

		System.out.println(sequ.mezzo());
	}
}