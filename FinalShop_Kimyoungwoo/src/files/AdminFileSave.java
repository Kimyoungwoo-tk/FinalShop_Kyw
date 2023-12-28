package files;

import java.io.IOException;

import _mall.MenuCommand;
import controller.MallController;
import dao.BoardDAO;
import dao.CartDAO;
import dao.FileDAO;
import dao.ItemDAO;
import dao.MemberDAO;

public class AdminFileSave implements MenuCommand{
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		FileDAO fDAO = FileDAO.getInstance();
		cont.setNext("AdminMain");
		try {
			fDAO.FileSave("board.txt", BoardDAO.DataToFile());
			fDAO.FileSave("cart.txt", CartDAO.DataToFile());
			fDAO.FileSave("item.txt", ItemDAO.DataToFile());
			fDAO.FileSave("member.txt", MemberDAO.DataToFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("저장완료");
		return false;
	}

}