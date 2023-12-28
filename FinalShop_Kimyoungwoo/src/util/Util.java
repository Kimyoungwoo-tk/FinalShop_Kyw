package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);

	public static void closeScanner() {
		sc.close();
	}
	
	public static int getValue(String msg, int start, int end) {
		System.out.printf("%s %d~%d :",msg, start, end);
		int sel = -1;
		try {
			sel = sc.nextInt();
			if(sel < start || sel >end) {
				System.out.printf("%d~%d 값 입력하시오",start, end);
				return -1;
			}
		}catch(InputMismatchException e) {
			sc.nextLine();
			System.out.println("숫자만 입력");
		}
		
		return sel;
	}
	
	public static String getValue(String msg) {
		System.out.println(msg);
		return sc.next();
	}
	
	
}
