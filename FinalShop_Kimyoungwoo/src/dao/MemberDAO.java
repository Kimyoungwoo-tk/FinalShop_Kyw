package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.Item;
import dto.Member;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private static ArrayList<Member> mList;
	
	public ArrayList<Member> getmList(){
		return mList;
	}
	
	public static MemberDAO getInstance() {
		return instance;
		
	}
	public MemberDAO() {
		mList = new ArrayList<Member>();
	}

	public int idValue(String id) {
		for(int i = 0; i<mList.size(); i+=1) {
			if(mList.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public int pwValue(String pw) {
		for(int i =0; i< mList.size(); i+=1) {
			if(mList.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}
	
	public void MemberDelete(int idx) {
		mList.remove(idx);
	}
	
	public void MemberList() {
		mList.forEach(System.out::println);
	}
	
	public static String DataToFile() {
		String data = "";
		if(mList.size() ==0) {
			return data;
		}
		for(Member m : mList) {
			if(m.getMemberNum()!=1000) {
				data += m.DatetoFile() + "\n";
			}
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
	
	public static void FileToData(List<String>mData) {
		if(mData.isEmpty()) return;
		int maxMemberNum = 0;
		for( int i = 0; i<mData.size(); i+=1) {
			String[] info = mData.get(i).split("/");
			if(!info[0].equals("")) {
				mList.add(Member.CreateMember(info));
				if(maxMemberNum < Integer.parseInt(info[0])) {
					maxMemberNum = Integer.parseInt(info[0]);
					
				}
			}
		}
		Member.setNum(maxMemberNum);
		
	}
	
	
	
	
}