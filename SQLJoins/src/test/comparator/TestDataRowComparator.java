package test.comparator;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import main.join.DataCell;
import main.join.DataRow;
import main.join.DataRowComparator;

public class TestDataRowComparator {

	@Test
	public void testSortByInteger() {
		DataCell<Integer> cellOne = new DataCell<>();
		cellOne.setValue(30);
		DataCell<String> cellTwo = new DataCell<>();
		cellTwo.setValue("row 1 column 2");
		DataCell<Double> cellThree = new DataCell<>();
		cellThree.setValue(3.3);
		DataRow rowOne = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<>();
		cellOne.setValue(10);
		cellTwo = new DataCell<>();
		cellTwo.setValue("row 2 column 2");
		cellThree = new DataCell<>();
		cellThree.setValue(1.1);
		DataRow rowTwo = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<>();
		cellOne.setValue(20);
		cellTwo = new DataCell<>();
		cellTwo.setValue("row 3 column 2");
		cellThree = new DataCell<>();
		cellThree.setValue(2.2);
		DataRow rowThree = buildRow(cellOne, cellTwo, cellThree);
		
		List<DataRow> rows = new LinkedList<>(Arrays.asList(new DataRow[] {rowOne, rowTwo, rowThree} ));		
		Collections.sort(rows, new DataRowComparator(0));
		assertTrue(rows.get(0).getDataCell(0).getValue().equals(10));
		assertTrue(rows.get(0).getDataCell(1).getValue().equals("row 2 column 2"));
		assertTrue(rows.get(0).getDataCell(2).getValue().equals(1.1));
		
		assertTrue(rows.get(1).getDataCell(0).getValue().equals(20));
		assertTrue(rows.get(1).getDataCell(1).getValue().equals("row 3 column 2"));
		assertTrue(rows.get(1).getDataCell(2).getValue().equals(2.2));
		
		assertTrue(rows.get(2).getDataCell(0).getValue().equals(30));	
		assertTrue(rows.get(2).getDataCell(1).getValue().equals("row 1 column 2"));	
		assertTrue(rows.get(2).getDataCell(2).getValue().equals(3.3));	
	}	

	@Test
	public void testSortByString() {
		DataCell<Integer> cellOne = new DataCell<>();
		cellOne.setValue(30);
		DataCell<String> cellTwo = new DataCell<>();
		cellTwo.setValue("row 1 column 2");
		DataCell<Double> cellThree = new DataCell<>();
		cellThree.setValue(3.3);
		DataRow rowOne = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<>();
		cellOne.setValue(10);
		cellTwo = new DataCell<>();
		cellTwo.setValue("row 2 column 2");
		cellThree = new DataCell<>();
		cellThree.setValue(1.1);
		DataRow rowTwo = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<>();
		cellOne.setValue(20);
		cellTwo = new DataCell<>();
		cellTwo.setValue("row 3 column 2");
		cellThree = new DataCell<>();
		cellThree.setValue(2.2);
		DataRow rowThree = buildRow(cellOne, cellTwo, cellThree);
		
		List<DataRow> rows = new LinkedList<>(Arrays.asList(new DataRow[] {rowOne, rowTwo, rowThree} ));		
		Collections.sort(rows, new DataRowComparator(1));
		assertTrue(rows.get(0).getDataCell(0).getValue().equals(30));	
		assertTrue(rows.get(0).getDataCell(1).getValue().equals("row 1 column 2"));	
		assertTrue(rows.get(0).getDataCell(2).getValue().equals(3.3));	
		
		assertTrue(rows.get(1).getDataCell(0).getValue().equals(10));
		assertTrue(rows.get(1).getDataCell(1).getValue().equals("row 2 column 2"));
		assertTrue(rows.get(1).getDataCell(2).getValue().equals(1.1));
		
		assertTrue(rows.get(2).getDataCell(0).getValue().equals(20));
		assertTrue(rows.get(2).getDataCell(1).getValue().equals("row 3 column 2"));
		assertTrue(rows.get(2).getDataCell(2).getValue().equals(2.2));		
	}
	
	@Test
	public void testSortByDouble() {
		DataCell<Integer> cellOne = new DataCell<>();
		cellOne.setValue(30);
		DataCell<String> cellTwo = new DataCell<>();
		cellTwo.setValue("row 1 column 2");
		DataCell<Double> cellThree = new DataCell<>();
		cellThree.setValue(3.3);
		DataRow rowOne = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<>();
		cellOne.setValue(10);
		cellTwo = new DataCell<>();
		cellTwo.setValue("row 2 column 2");
		cellThree = new DataCell<>();
		cellThree.setValue(1.1);
		DataRow rowTwo = buildRow(cellOne, cellTwo, cellThree);
		
		cellOne = new DataCell<>();
		cellOne.setValue(20);
		cellTwo = new DataCell<>();
		cellTwo.setValue("row 3 column 2");
		cellThree = new DataCell<>();
		cellThree.setValue(2.2);
		DataRow rowThree = buildRow(cellOne, cellTwo, cellThree);
		
		List<DataRow> rows = new LinkedList<>(Arrays.asList(new DataRow[] {rowOne, rowTwo, rowThree} ));		
		Collections.sort(rows, new DataRowComparator(2));
		assertTrue(rows.get(0).getDataCell(0).getValue().equals(10));
		assertTrue(rows.get(0).getDataCell(1).getValue().equals("row 2 column 2"));
		assertTrue(rows.get(0).getDataCell(2).getValue().equals(1.1));
		
		assertTrue(rows.get(1).getDataCell(0).getValue().equals(20));
		assertTrue(rows.get(1).getDataCell(1).getValue().equals("row 3 column 2"));
		assertTrue(rows.get(1).getDataCell(2).getValue().equals(2.2));
		
		assertTrue(rows.get(2).getDataCell(0).getValue().equals(30));	
		assertTrue(rows.get(2).getDataCell(1).getValue().equals("row 1 column 2"));	
		assertTrue(rows.get(2).getDataCell(2).getValue().equals(3.3));		
	}
	
	private DataRow buildRow(DataCell<?>... cells) {
		DataRow row = new DataRow();
		for (int i = 0; i < cells.length; i++) {		
			row.addDataCell(i, cells[i]);	
		}
		return row;
	}
}
