package main.join;

import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class Joiner {
	public abstract DataTable join(DataTable leftTable, int leftTableJoinColumnIndex, DataTable rightTable, int rightTableJoinColumnIndex);
	
	protected DataRow buildJoinedRow(DataRow leftTableRow, DataRow rightTableRow) {
		TreeMap<Integer, DataCell<?>> leftData = leftTableRow.getDataCells();
		TreeMap<Integer, DataCell<?>> joinedData = new TreeMap<>();
		// Add all data in the row from left table
		joinedData.putAll(leftData);
		// Append all data in the row from right table
		int lastColumnIndex = leftData.size();
		TreeMap<Integer, DataCell<?>> rightData = rightTableRow.getDataCells();
		for (Entry<Integer, DataCell<?>> entry: rightData.entrySet()) {
			joinedData.put(lastColumnIndex, entry.getValue());
			lastColumnIndex++;
		}
		DataRow joinedDataRow = new DataRow();
		joinedDataRow.setDataCells(joinedData);
		return joinedDataRow;
	}
}
