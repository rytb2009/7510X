package main.impl;

import java.util.Collections;
import java.util.List;

import main.join.DataCell;
import main.join.DataRow;
import main.join.DataRowComparator;
import main.join.DataTable;
import main.join.Joiner;

public class MergeJoiner extends Joiner {

	@Override
	public DataTable join(DataTable leftTable, int leftTableJoinColumnIndex, DataTable rightTable, int rightTableJoinColumnIndex) {
		List<DataRow> leftTableRows = leftTable.getDataRows();
		Collections.sort(leftTableRows, new DataRowComparator(leftTableJoinColumnIndex));
		List<DataRow> rightTableRows = rightTable.getDataRows();
		Collections.sort(rightTableRows, new DataRowComparator(rightTableJoinColumnIndex));
		DataTable joinedTable = new DataTable();
		int pointerLeft = 0;
		int pointerRight = 0;
		do {
			DataRow leftTableRow = leftTableRows.get(pointerLeft);
			DataRow rightTableRow = rightTableRows.get(pointerRight);
			DataCell<?> leftTableCell = leftTableRow.getDataCell(leftTableJoinColumnIndex);
			DataCell<?> rightTableCell = rightTableRow.getDataCell(rightTableJoinColumnIndex);
			if (leftTableCell.getValue().equals(rightTableCell.getValue())) {
				joinedTable.addRow(super.buildJoinedRow(leftTableRow, rightTableRow));
			} 
			if (((Comparable)leftTableCell.getValue()).compareTo(((Comparable)rightTableCell.getValue())) <= 0) {
				pointerLeft++;
			} else {
				pointerRight++;
			}
		} while(pointerLeft < leftTableRows.size() && pointerRight < rightTableRows.size());
		return joinedTable;
	}
	
}
