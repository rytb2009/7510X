package test.impl;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.impl.HashJoiner;
import main.join.DataCell;
import main.join.DataRow;
import main.join.DataTable;

public class TestHashJoiner {	

	@Test
	public void testJoin_EmptyResult() {
		DataCell<String> cellOne = new DataCell<String>();
		cellOne.setValue("left row 1 column 1");
		DataRow rowOneLeftTable = buildRow(cellOne);
		DataTable leftTable = new DataTable();
		leftTable.addRow(rowOneLeftTable);		

		cellOne = new DataCell<String>();
		cellOne.setValue("right row 1 column 1");
		DataRow rowOneRightTable = buildRow(cellOne);
		DataTable rightTable = new DataTable();
		rightTable.addRow(rowOneRightTable);
		
		DataTable joinTable = new HashJoiner().join(leftTable, 0, rightTable, 0);
		assertTrue(joinTable.getDataRows() == null);
		
	}
	
	/* This test case is joining with two table and both of them have only one row,
	 * as well as checking return results will be merged all columns within table left and table right. 
	 */
	@Test
	public void testJoinOneRow_Success() {
		DataCell<String> cellOne = new DataCell<String>();
		cellOne.setValue("joining column");
		DataCell<String> cellTwo = new DataCell<String>();
		cellTwo.setValue("left row 1 column 2");
		DataCell<String> cellThree = new DataCell<String>();
		cellThree.setValue("left row 1 column 3");
		DataRow rowOneLeftTable = buildRow(cellOne, cellTwo, cellThree);
		DataTable leftTable = new DataTable();
		leftTable.addRow(rowOneLeftTable);		

		cellTwo = new DataCell<String>();
		cellTwo.setValue("right row 1 column 2");
		cellThree = new DataCell<String>();
		cellThree.setValue("right row 1 column 3");
		DataRow rowOneRightTable = buildRow(cellOne, cellTwo, cellThree);
		DataTable rightTable = new DataTable();
		rightTable.addRow(rowOneRightTable);
		
		DataTable joinTable = new HashJoiner().join(leftTable, 0, rightTable, 0);
		assertTrue(joinTable.getDataRows().get(0).getDataCells().size() == 6);
		assertTrue("joining column".equals(joinTable.getDataRows().get(0).getDataCell(0).getValue()));
		assertTrue("left row 1 column 2".equals(joinTable.getDataRows().get(0).getDataCell(1).getValue()));
		assertTrue("left row 1 column 3".equals(joinTable.getDataRows().get(0).getDataCell(2).getValue()));
		assertTrue("joining column".equals(joinTable.getDataRows().get(0).getDataCell(3).getValue()));
		assertTrue("right row 1 column 2".equals(joinTable.getDataRows().get(0).getDataCell(4).getValue()));
		assertTrue("right row 1 column 3".equals(joinTable.getDataRows().get(0).getDataCell(5).getValue()));		
	}
	
	/* This test case is joining with two table and both of them have two rows,
	 * as well as checking return results will be merged all columns within table left and table right. 
	 */
	@Test
	public void testJoinMultipleRows_Success() {
		DataCell<String> cellOne = new DataCell<String>();
		cellOne.setValue("left row 1 column 1");
		DataCell<String> cellTwo = new DataCell<String>();
		cellTwo.setValue("left row 1 column 2");
		DataCell<String> cellThree = new DataCell<String>();
		cellThree.setValue("left row 1 column 3");
		DataRow rowOneLeftTable = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<String>();
		cellOne.setValue("joining column");
		cellTwo = new DataCell<String>();
		cellTwo.setValue("left row 2 column 2");
		cellThree = new DataCell<String>();
		cellThree.setValue("left row 2 column 3");
		DataRow rowTwoLeftTable = buildRow(cellOne, cellTwo, cellThree);
		DataTable leftTable = new DataTable();
		leftTable.addRow(rowOneLeftTable);		
		leftTable.addRow(rowTwoLeftTable);		

		cellOne = new DataCell<String>();
		cellOne.setValue("joining column");
		cellTwo = new DataCell<String>();
		cellTwo.setValue("right row 1 column 2");
		cellThree = new DataCell<String>();
		cellThree.setValue("right row 1 column 3");
		DataRow rowOneRightTable = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<String>();
		cellOne.setValue("right row 1 column 1");
		cellTwo = new DataCell<String>();
		cellTwo.setValue("right row 1 column 2");
		cellThree = new DataCell<String>();
		cellThree.setValue("right row 1 column 3");
		DataRow rowTwoRightTable = buildRow(cellOne, cellTwo, cellThree);
		DataTable rightTable = new DataTable();
		rightTable.addRow(rowOneRightTable);
		rightTable.addRow(rowTwoRightTable);
		
		DataTable joinTable = new HashJoiner().join(leftTable, 0, rightTable, 0);
		assertTrue(joinTable.getDataRows().get(0).getDataCells().size() == 6);
		assertTrue("joining column".equals(joinTable.getDataRows().get(0).getDataCell(0).getValue()));
		assertTrue("left row 2 column 2".equals(joinTable.getDataRows().get(0).getDataCell(1).getValue()));
		assertTrue("left row 2 column 3".equals(joinTable.getDataRows().get(0).getDataCell(2).getValue()));
		assertTrue("joining column".equals(joinTable.getDataRows().get(0).getDataCell(3).getValue()));
		assertTrue("right row 1 column 2".equals(joinTable.getDataRows().get(0).getDataCell(4).getValue()));
		assertTrue("right row 1 column 3".equals(joinTable.getDataRows().get(0).getDataCell(5).getValue()));
	}

	private DataRow buildRow(DataCell<?>... cells) {
		DataRow row = new DataRow();
		for (int i = 0; i < cells.length; i++) {		
			row.addDataCell(i, cells[i]);	
		}
		return row;
	}
}
