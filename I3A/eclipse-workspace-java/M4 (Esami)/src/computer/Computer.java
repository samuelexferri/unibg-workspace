package computer;

public class Computer implements Comparable<Computer> {

	int ID;

	Computer(int ID) {
		this.ID = ID;
	}

	@Override
	public int compareTo(Computer o) {
		if (this.ID > o.ID)
			return 1;
		if (this.ID == o.ID)
			return 0;
		return -1;
	}
}