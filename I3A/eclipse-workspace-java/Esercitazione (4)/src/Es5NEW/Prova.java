package Es5NEW;

public class Prova {

	public static void main(String[] args) {
		SequenzaOrdinabile<Integer> seq = new SequenzaOrdinabile<Integer>();
		
		/*seq.insert("prova");
		seq.insert("prova5");
		seq.insert("prova4");*/
		
		seq.insert(4);
		seq.insert(3);
		seq.insert(6);
		
		seq.stampa();
		
		seq.bubbleSort();
		
		seq.stampa();
		
		SequenzaOrdinabile<Person> pers = new SequenzaOrdinabile<>();
		
		pers.insert(new Student("s1"));
		pers.insert(new Student("s2"));
		pers.insert(new Student("s3"));
		pers.insert(new Student("s4"));
		pers.insert(new Person("p1"));
		
		pers.stampa();
		
		Person p1= new Person("p1");
		Student s1=new Student("s1");
		p1.compareTo(s1);
		
		SequenzaUtils seq2 = new SequenzaUtils();
		seq2.insert(4);
		seq2.insert(3);
		seq2.insert(6);
		
		System.out.println(seq2.mezzo());
		
	}
}
