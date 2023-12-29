package menu_admin_member;
import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.MemberDAO;
import util.Util;

public class AdminMemberDelete implements MenuCommand {
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		CartDAO cDAO = CartDAO.getInstance();
		
		cont.setNext("AdminMember");
		if(mDAO.getmList().size() == 0) {
			System.out.println("[관리자] 회원이 존재하지 않습니다");
			return false;
		}
		String id = Util.getValue("ID : ");
		mDAO.idValue(id);
		if (mDAO.idValue(id) == -1) {
			System.out.println("[관리자] ID가 존재하지 않습니다");
			return false;
		}
		if(mDAO.idValue(id) == 0) {
			System.out.println("[관리자] 관리자는 삭제 불가");
			return false;
		}
		
		mDAO.MemberDelete(mDAO.idValue(id));	
		cDAO.MemberDelete(id);	
		System.out.println("[관리자] %s 회원 삭제 완료".formatted(id));
		return false;
	}
}