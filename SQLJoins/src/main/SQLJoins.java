package main;

import java.io.File;
import java.util.List;

import main.impl.HashJoiner;
import main.impl.InnerLoopJoiner;
import main.impl.MergeJoiner;
import main.join.DataRow;
import main.join.DataTable;
import main.join.JoinType;
import main.join.Joiner;

public class SQLJoins {
	
	 /**
	 * @param args
	 * args[0] first_table_file_path_1
	 * args[1] second_table_file_path_2
	 * args[2] first_table_join_column_index 
	 * args[3] second_table_join_column_index
	 * args[4] join_type
	 * Available Join Type
	 ** Inner Loop Join -i
	 ** Merge Join -m
	 ** Hash Join -h 
	 * eg. ctsdata\\splits.dump.csv ctsdata\\dividend.dump.csv 1 1 -i
	 */
	public static void main(String[] args) {
		String fileOnePath = args[0];
		String fileTwoPath = args[1];
		int leftTablejoinColumnIndex = Integer.valueOf(args[2]);
		int rightTablejoinColumnIndex = Integer.valueOf(args[3]);
		JoinType joinType = JoinType.parse(args[4]);
		Joiner joiner = getJoiner(joinType);
		DataTable leftTable = new CSVFileReader(new File(fileOnePath)).readFileToTable();
		DataTable rightTable = new CSVFileReader(new File(fileTwoPath)).readFileToTable();
		DataTable joinedTable = joiner.join(leftTable, leftTablejoinColumnIndex, rightTable, rightTablejoinColumnIndex);
		List<DataRow> dataRows = joinedTable.getDataRows();
		if (dataRows != null && !dataRows.isEmpty()) {
			dataRows.stream().forEach(System.out::println);
		}
		System.out.println("Total Records: " + dataRows.size());
	}
	
	private static Joiner getJoiner(JoinType joinType) {
		switch (joinType) {
		case INNER_LOOP_JOIN:
			return new InnerLoopJoiner();
		case MERGE_JOIN:
			return new MergeJoiner();
		case HASH_JOIN:
			return new HashJoiner();
		default:
			return new MergeJoiner();
		}
	}
}
