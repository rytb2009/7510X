package main.impl;

import java.util.List;

import main.join.DataCell;
import main.join.DataRow;
import main.join.DataTable;
import main.join.Joiner;

public class InnerLoopJoiner extends Joiner {
	@Override
	public DataTable join(DataTable leftTable, int leftTableJoinColumnIndex, DataTable rightTable, int rightTableJoinColumnIndex) {
		List<DataRow> leftTableRows = leftTable.getDataRows();
		List<DataRow> rightTableRows = rightTable.getDataRows();
		DataTable joinedTable = new DataTable();
		for (DataRow leftTableRow: leftTableRows) {
			DataCell<?> leftTableCell = leftTableRow.getDataCell(leftTableJoinColumnIndex);
			for (DataRow rightTableRow: rightTableRows) {
				DataCell<?> rightTableCell = rightTableRow.getDataCell(rightTableJoinColumnIndex);
				if (leftTableCell.getValue().equals(rightTableCell.getValue())) {
					joinedTable.addRow(super.buildJoinedRow(leftTableRow, rightTableRow));
				}
			}
		}
		return joinedTable;
	}

}
