package dao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDAO {


	private String txtPath = "src/files/";
	private Charset charSet = StandardCharsets.UTF_8;
	enum FileName {
		BOARD("board.txt"), MEMBER("member.txt"), ITEM("item.txt"), CART("cart.txt");
		private String name;
		FileName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		
	
	}

	private FileDAO() {
		init();
	}

	private static FileDAO instance = new FileDAO();

	static public FileDAO getInstance() {
		return instance;
	}

	private void createFile(FileName name) {
		Path path = Paths.get("src/files/" + name.getName());
		try {
			Files.createFile(path);
		} catch (IOException e) {
			//System.out.println("파일이 이미 있음");
		}
	}

	

	private void init() {
		
		createFile(FileName.BOARD);
		createFile(FileName.MEMBER);
		createFile(FileName.ITEM);
		createFile(FileName.CART);
		
		try {
			List<String> bData = FileLoad(FileName.BOARD);
			BoardDAO.FileToData(bData);
			List<String> mData = FileLoad(FileName.MEMBER);
			MemberDAO.FileToData(mData);
			List<String> iData = FileLoad(FileName.ITEM);
			ItemDAO.FileToData(iData);
			List<String> cData = FileLoad(FileName.CART);
			CartDAO.FileToData(cData);
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}
	private List<String> FileLoad(FileName name) throws IOException {
//		Files.readAllLines(Paths.get(txtPath + name.getName())).forEach(System.out::println);
		return Files.readAllLines(Paths.get(txtPath + name.getName()));
	}
	public void FileSave(String txtName, String data) throws IOException {
		Files.writeString(Paths.get(txtPath + txtName), data, charSet);
	}

}