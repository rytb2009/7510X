package main.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import main.join.DataCell;
import main.join.DataRow;
import main.join.DataTable;
import main.join.Joiner;

public class HashJoiner extends Joiner {

	@Override
	public DataTable join(DataTable leftTable, int leftTableJoinColumnIndex, DataTable rightTable, int rightTableJoinColumnIndex) {
		// Left is always the smaller one, right is always the bigger one
		List<DataRow> leftTableRows = leftTable.getDataRows().size() > rightTable.getDataRows().size() ? rightTable.getDataRows() : leftTable.getDataRows();
		List<DataRow> rightTableRows = leftTable.getDataRows().size() > rightTable.getDataRows().size() ? leftTable.getDataRows() : rightTable.getDataRows();
		HashMap<Object, List<DataRow>> hashTable = buildHashtable(leftTableRows, leftTableJoinColumnIndex);
		DataTable joinedTable = new DataTable();
		for (DataRow rightTableRow: rightTableRows) {
			DataCell<?> cell = rightTableRow.getDataCell(rightTableJoinColumnIndex);
			if (hashTable.containsKey(cell.getValue())) {
				hashTable.get(cell.getValue()).stream().forEach(leftTableRow -> 
					joinedTable.addRow(super.buildJoinedRow(leftTableRow, rightTableRow))			
				);
			}
		}
		return joinedTable;
	}

	private HashMap<Object, List<DataRow>> buildHashtable(List<DataRow> dataRows, int joinColumnIndex) {
		HashMap<Object, List<DataRow>> hashMap = new HashMap<>();
		for (DataRow row: dataRows) {
			DataCell<?> cell = row.getDataCell(joinColumnIndex);
			List<DataRow> rowList = hashMap.getOrDefault(cell.getValue(), new LinkedList<>());
			rowList.add(row);
			hashMap.put(cell.getValue(), rowList);
		}
		return hashMap;
	}
}
