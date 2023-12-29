package menu_board;

import _mall.MenuCommand;
import controller.MallController;
import dao.BoardDAO;
import util.Util;

public class BoardshowPage implements MenuCommand {
	private MallController cont = MallController.getInstance();
	
	@Override
	public boolean update() {
		BoardDAO bDAO = BoardDAO.getInstance();
		
		String id = cont.getLoginId().equals("admin")? "관리자":cont.getLoginId();
		
		if(cont.getLoginId().equals("admin")) {
			cont.setNext("AdminBoard");
		}else {
			cont.setNext("MemberBoard");
		}
		
		if(bDAO.getbList().size() ==0) {
			System.out.println("게시글이 없습니다");
			return false;
		}
		
		bDAO.PageCal();
		bDAO.PrintBoard();
		int startRow = bDAO.getStartRow();
		int endRow = bDAO.getEndRow();
		int idx = Util.getValue("선택", startRow, endRow);
		if(idx == -1) {
			System.out.println("해당 페이지 글만 선택 가능");
			return false;
		}
		idx-=1;
		bDAO.BoardViewPage(idx);
		int getHits = bDAO.getbList().get(idx).getHits();
		bDAO.getbList().get(idx).setHits(getHits+1);
		
		return false;
	}

}
