package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.join.DataRow;
import main.join.DataTable;

public class CSVFileReader {

	private File file;

	public CSVFileReader(File file) {
		this.file = file;
	}

	public DataTable readFileToTable() {
		DataTable table = new DataTable();
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] rowValue = line.split(cvsSplitBy);
				DataRow dataRow = new DataRow();
				for (int i = 0; i < rowValue.length; i++) {
					dataRow.addDataCell(i, rowValue[i]);				
				}
				table.addRow(dataRow);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return table;
	}
}
