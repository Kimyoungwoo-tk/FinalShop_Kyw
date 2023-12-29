package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
		categoryList = FileToDataCategory();
	}
	public static ArrayList<String> FileToDataCategory(){
		Set<String> categoryList = new HashSet<String>();
		for(int i =0; i<itemList.size(); i+=1) {
			categoryList.add(itemList.get(i).getCategoryName());
		}
		ArrayList<String> list = new ArrayList<>(categoryList);
		return list;
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
	
	public Item itemValue(int itemNum) {
		for (int i = 0; i < itemList.size(); i += 1) {
			if (itemList.get(i).getItemNum() == itemNum) {
				return itemList.get(i);
			}
		}
		return null;
	}
	
	public String getCategoryName(int idx) {
		return categoryList.get(idx);
	}
	
	public void CategoryList() {
		for(int i =0; i<categoryList.size(); i+=1) {
			System.out.println("[%d] %s".formatted(i+1,categoryList.get(i)));
		}
	}
	
	public ArrayList<Item> CategoryToItemList(String cgName){
		ArrayList<Item> cgtoitemList = new ArrayList<Item>();
		int cnt =1;
		for(int i =0; i< itemList.size(); i+=1) {
			if(itemList.get(i).getCategoryName().equals(cgName)) {
				cgtoitemList.add(itemList.get(i));
				System.out.println(
						"[%d] %s %d원".formatted(cnt++,itemList.get(i).getItemName(),itemList.get(i).getPrice())
						);
			}
		}
		return cgtoitemList;
	}
	
	public void itemListPrint() {
		System.out.println("===[카테고리별 아이템 목록]===");
		itemList.stream()
				.sorted(Comparator.comparing(Item::getCategoryName).thenComparing(Item::getItemName))
				.forEach(System.out::println);
				
	}
	
	public void addCategory(String Category) {
		
	}
	
	

}