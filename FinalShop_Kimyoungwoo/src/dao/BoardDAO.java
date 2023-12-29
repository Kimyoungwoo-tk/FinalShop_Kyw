package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.Member;
import util.Util;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private static ArrayList<Board> bList;
	private int count = 0; // 전체 게시글 수
	private int pageSize = 5; // 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1; // 현재 페이지 번호
	private int pageCount = 0; // 전체 페이지 개수
	private int startRow = 0; // 현재 페이지의 게시글 시작 번호
	private int endRow = 0; // 현재 페이지의 게시글 마지막 번호
	
	public static BoardDAO getInstance() {
		return instance;
	}

	
	public static ArrayList<Board> getbList() {
		return bList;
	}

	public int getCount() {
		return count;
	}
	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public int getPageCount() {
		return pageCount;
	}


	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public BoardDAO() {
		bList = new ArrayList<Board>();
		
	}
	public static String DataToFile() {
		String data = "";
		if (bList.size() == 0)
			return data;
		for (Board b : bList) {
			data += b.DataToFile() + "\n";
		}
		data = data.substring(0, data.length() - 1);
		return data;
	}

	// 텍스트파일에서 문자열 받아와서 데이터 넣기
	public static void FileToData(List<String> bData) {
		if (bData.isEmpty())
			return;

		int maxBoardNum = 0;
		for (int i = 0; i < bData.size(); i += 1) {
			Board b = new Board();
			String[] info = bData.get(i).split("/");
			b = b.CreateBoard(info);
			bList.add(b);
			if (maxBoardNum < Integer.parseInt(info[0])) {
				maxBoardNum = Integer.parseInt(info[0]);
			}
		}
		Board.setNum(maxBoardNum);
	}
	
	public void PrintBoard() {
		System.out.printf("총 게시글: %d개",count);
		System.out.println("[%d/%d]".formatted(curPageNum,pageCount));
		for(int i =startRow; i<endRow; i+=1) {
			System.out.printf("(%d)",i+1);
			bList.get(i).PrintBoard();
		}
		System.out.println("================");
	}
	
	public boolean DeletePage(int idx, String id) {
		if(!id.equals("관리자") && !bList.get(idx).getId().equals(id)) {
			return true;
		}
		bList.remove(idx);
		return false;
	}
	
	public void PageCal() {
		count = bList.size();
		pageCount = count/pageSize;
		if(count%pageSize>0) {
			pageCount+=1;
		}
		pageCount = pageCount == 0 ? 1:pageCount;
		startRow = (curPageNum -1)*pageSize;
		endRow = startRow+pageSize;
		if(endRow>count)
			endRow = count;
	}
	
	public void BoardViewPage(int idx) {
		bList.get(idx).ViewPage();
	}
	
	
	
	
	
	
	
	

}