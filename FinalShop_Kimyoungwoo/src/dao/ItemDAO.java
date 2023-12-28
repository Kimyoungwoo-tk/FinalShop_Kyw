package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import dto.Board;
import dto.Item;

public class ItemDAO {
	private static ItemDAO instance = new ItemDAO();
	private static ArrayList<Item> itemList;
	private static ArrayList<String> categoryList;
	
	public ItemDAO() {
		itemList = new ArrayList<Item>();
		categoryList = new ArrayList<String>();
	}

	public static ItemDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<Item> getItemList() {
		return itemList;
	}

	
	public static ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public static void setCategoryList(ArrayList<String> categoryList) {
		ItemDAO.categoryList = categoryList;
	}
	
	public static void FileToData(List<String> iData) {
		if (iData.isEmpty())
			return;

		int maxItemNum = 0;
		for (int i = 0; i < iData.size(); i += 1) {
			Item item = new Item();
			String[] info = iData.get(i).split("/");
			item = item.CreateItem(info);
			itemList.add(item);
			if (maxItemNum < Integer.parseInt(info[0])) {
				maxItemNum = Integer.parseInt(info[0]);
			}
		}
		Item.setNum(maxItemNum);
//		categoryList = FileToDataCategory();
	}
	
	public static String DataToFile() {
		String data = "";
		if (itemList.size() == 0)
			return data;
		for (Item i : itemList) {
			data += i.DataToFile() + "\n";
		}
		data = data.substring(0, data.length() - 1);
		return data;
	}
	

}