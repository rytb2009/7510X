package main.join;

public class DataCell<T extends Comparable<T>>{
	private T value;

	public DataCell() {
		super();
	}
		
	public DataCell(T value) {
		super();
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
