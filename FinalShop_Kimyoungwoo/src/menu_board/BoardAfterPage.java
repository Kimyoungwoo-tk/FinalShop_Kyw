package menu_board;

import _mall.MenuCommand;
import controller.MallController;
import dao.BoardDAO;

public class BoardAfterPage implements MenuCommand {
	private MallController cont = MallController.getInstance();

	
	@Override
	public boolean update() {
		BoardDAO bDAO = BoardDAO.getInstance();
		cont.setNext("BoardList");
		int curPageNum = bDAO.getCurPageNum();
		if(curPageNum == bDAO.getPageCount()) {
			System.out.println("이후 페이지 없음");
			return false;
		}
		bDAO.setCurPageNum(curPageNum+1);
				
		
		return false;
	}

}
