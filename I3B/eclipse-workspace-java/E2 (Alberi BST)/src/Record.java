class Record {
	public Object data; // Dati satellite
	public Comparable key; // Campo chiave

	public Record() {
	}

	public Record(Object d, Comparable k) {
		data = d;
		key = k;
	}

	public Comparable getKey() {
		return key;
	}

	public Object getData() {
		return data;
	}

	public String toString() {
		return "(data:" + data + ",key:" + key + ") ";
	}
}