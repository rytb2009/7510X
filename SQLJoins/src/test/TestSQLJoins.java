package test;

import org.junit.Test;

import main.SQLJoins;

public class TestSQLJoins {
	
	@Test
	public void test() {
		String fileOnePath = "E:\\Dev\\SCHOOL\\7510X\\ctsdata\\splits.dump.csv";
		String fileTwoPath = "E:\\Dev\\SCHOOL\\7510X\\ctsdata\\dividends.dump.csv";
		SQLJoins.main(new String[] {fileOnePath, fileTwoPath, "1", "1", "-h"});
	}

}
