package dto;

public class Member {
	private static int num = 1000;
	private int memberNum;
	private String id;
	private String pw;
	private String memberName;
	
	public Member() {
	}
	
	public Member(String id, String pw, String memberName) {		
		this.memberNum = num++;
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		Member.num = num;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	private Member(String number, String id, String pw, String memberName) {
		this.memberNum = Integer.parseInt(number);
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}

	@Override
	public String toString()  {
		return "[%d] [%s] [%s] [%s]".formatted(memberNum, id, pw, memberName);
	}

	public static Member CreateMember(String[] info) {
		if (info == null || info.length == 0)
			return null;

		return new Member(info[0], info[1], info[2], info[3]);
	}
	
	
	public String DatetoFile() {
		return "%d/%s/%s/%s".formatted(memberNum,id,pw,memberName);
	}
	
	
}