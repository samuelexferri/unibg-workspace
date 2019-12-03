package Es5NEW;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SequenzaUtils {

	ArrayList<Object> array=new ArrayList<>();

	public SequenzaUtils() {
		// TODO Auto-generated constructor stub
	}

	void insert(Object e) {
		array.add(e);
	}
	
	void stampa() {
		for (Object c: array)
			System.out.println(c.toString());
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public Object mezzo() {
		int size= array.size();
		return array.get(size/2);
	}
}
