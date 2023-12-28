package menu_admin_member;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;

public class AdminMemberList implements MenuCommand {
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		
		cont.setNext("AdminMember");
		
		mDAO.MemberList();
		return false;
	}
}