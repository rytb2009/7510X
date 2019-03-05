package main.join;

import java.util.Comparator;

public class DataRowComparator implements Comparator<DataRow>  {
	
	protected int joinColumnIndex;
	
	public DataRowComparator(int joinColumnIndex) {
		this.joinColumnIndex = joinColumnIndex;
	}

	@Override
	public int compare(DataRow o1, DataRow o2) {
		DataCell<?> cell1 = o1.getDataCell(joinColumnIndex);
		DataCell<?> cell2 = o2.getDataCell(joinColumnIndex);
		return ((Comparable)cell1.getValue()).compareTo(((Comparable)cell2.getValue()));
	}
}
