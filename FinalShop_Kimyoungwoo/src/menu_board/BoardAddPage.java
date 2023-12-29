package menu_board;

import _mall.MenuCommand;
import controller.MallController;
import dao.BoardDAO;
import dto.Board;
import util.Util;

public class BoardAddPage implements MenuCommand {
	private MallController cont = MallController.getInstance();
	

	@Override
	public boolean update() {
		BoardDAO bDAO = BoardDAO.getInstance();
		
		cont.setNext("MemberBoard");
		System.out.println("===게시글 추가하기===");
		String title = Util.getValue("제목: ");
		String id = cont.getLoginId();
		String contents = Util.getValue("내용:");
		bDAO.getbList().add(new Board(title,contents,id));
		System.out.println("게시글 추가 완료");
		
		return false;
	}

}
