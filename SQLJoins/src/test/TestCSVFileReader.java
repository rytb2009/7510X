package test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

import main.CSVFileReader;
import main.join.DataTable;

public class TestCSVFileReader {

	@Test
	public void testRead() {
		File file = new File("E:\\Dev\\SCHOOL\\7510X\\ctsdata\\splits.dump.csv");
		CSVFileReader reader = new CSVFileReader(file);
		DataTable table = reader.readFileToTable();
		assertTrue(table.getDataRows().size() == 8471);
		
		file = new File("E:\\Dev\\SCHOOL\\7510X\\ctsdata\\dividends.dump.csv");
		reader = new CSVFileReader(file);
		table = reader.readFileToTable();
		assertTrue(table.getDataRows().size() == 320742);

	
	}
}
