package controller;

import java.util.HashMap;
import java.util.Map;
import _mall.MenuCommand;
import dao.FileDAO;
import files.AdminFileSave;
import menu_admin.*;
import menu_admin_member.AdminMemberDelete;
import menu_admin_member.AdminMemberList;
import menu_board.BoardAddPage;
import menu_board.BoardAfterPage;
import menu_board.BoardDelPage;
import menu_board.BoardList;
import menu_board.BoardfrontPage;
import menu_board.BoardshowPage;
import menu_mall.*;
import menu_member.*;

public class MallController {
	private MallController() {}

	static private MallController instance = new MallController();

	static public MallController getInstance() {
		return instance;
	}
	

	private String loginId;
	private String next; //다음화면
	private MenuCommand menuCom;
	public Map<String, MenuCommand> mapCont;

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void init() {
		mapCont = new HashMap<>();
		mapCont.put("MallMain", new _MallMain());
		mapCont.put("MallJoin", new MallJoin());
		mapCont.put("MallLogin", new MallLogin());
		mapCont.put("AdminBoard", new AdminBoard());
		mapCont.put("AdminItem", new AdminItem());
		mapCont.put("AdminMain", new _AdminMain());
		mapCont.put("AdminMember", new AdminMember());
		mapCont.put("MemberBoard", new MemberBoard());
		mapCont.put("MemberCart", new MemberCart());
		mapCont.put("MemberInfo", new MemberInfo());
		mapCont.put("MemberMain", new _MemberMain());
		mapCont.put("MemberShopping", new MemberShopping());
		mapCont.put("MemberQuit", new MemberQuit());
		mapCont.put("AdminFileSave", new AdminFileSave());
		mapCont.put("AdminMemberList", new AdminMemberList());
		mapCont.put("AdminMemberDelete", new AdminMemberDelete());
		mapCont.put("MemberChangePw", new MemberChangePw());
		mapCont.put("BoardAddPage", new BoardAddPage());
		mapCont.put("BoardDelPage", new BoardDelPage());
		mapCont.put("BoardList", new BoardList());
		mapCont.put("BoardfrontPage", new BoardfrontPage());
		mapCont.put("BoardAfterPage", new BoardAfterPage());
		mapCont.put("BoardshowPage", new BoardshowPage());
		
		
		
		menuCom = mapCont.get("MallMain");
		FileDAO.getInstance();
		update();

	}

	public void update() {
		while (true) {
			if (!menuCom.update()) {
				if (next != null) {
					menuCom = mapCont.get(next);
					
				} else {
					return;
				}
			}
		}
	}

}