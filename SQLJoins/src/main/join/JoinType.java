package main.join;

public enum JoinType {
	INNER_LOOP_JOIN("-i"),
	MERGE_JOIN("-m"),
	HASH_JOIN("-h");
	
	private String arg;
	
	private JoinType(String arg) {
		this.arg = arg;
	}
	
	public static JoinType parse(String arg) {
		for (JoinType type: JoinType.values()) {
			if (type.arg.equalsIgnoreCase(arg)) {
				return type;
			}
		}
		return MERGE_JOIN;
	}
}
