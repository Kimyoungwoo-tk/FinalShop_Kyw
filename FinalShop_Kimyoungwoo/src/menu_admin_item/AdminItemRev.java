package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.ItemDAO;

public class AdminItemRev implements MenuCommand {
		 private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		ItemDAO iDAO = ItemDAO.getInstance();
		CartDAO cDAO = CartDAO.getInstance();
		cont.setNext("AdminItem");
		int[][] arr = iDAO.itemNumList();
		cDAO.ItemRevenue(arr);
		iDAO.ItemRevenue(arr); 
		
		
		return false;
	}

}
