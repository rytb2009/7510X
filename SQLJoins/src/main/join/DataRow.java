package main.join;

import java.util.TreeMap;

public class DataRow {
	// Key is sorted column index, value is a cell
	private TreeMap<Integer, DataCell<?>> dataCells;
	
	public void addDataCell(int columnIndex, String cellValue) {
		addDataCell(columnIndex, new DataCell<String>(cellValue));
	}
	
	public void addDataCell(int columnIndex, DataCell<?> dataCell) {
		if (dataCells == null) {
			dataCells = new TreeMap<>();			
		}
		dataCells.put(columnIndex, dataCell);
	}
	
	public DataCell<?> getDataCell(int columnIndex) {
		return dataCells.get(columnIndex);
	}

	public TreeMap<Integer, DataCell<?>> getDataCells() {
		return dataCells;
	}

	public void setDataCells(TreeMap<Integer, DataCell<?>> dataCells) {
		this.dataCells = dataCells;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		dataCells.values().stream().forEach(cell -> sb.append(cell.getValue().toString() + "\t"));
		return sb.toString();
	}
}
