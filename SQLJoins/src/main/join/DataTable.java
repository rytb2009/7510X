package main.join;

import java.util.LinkedList;
import java.util.List;

public class DataTable {
	private List<DataRow> dataRows;
	
	public void addRow(DataRow dataRow) {
		if (dataRows == null) {
			dataRows = new LinkedList<>();
		}
		dataRows.add(dataRow);
	}
	public List<DataRow> getDataRows() {
		return dataRows;
	}
	public void setDataRows(List<DataRow> dataRows) {
		this.dataRows = dataRows;
	}
}
