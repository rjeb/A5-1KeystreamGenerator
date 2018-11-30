import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String key, keystream;
		int length;
		Scanner scanner = new Scanner(System.in);
		KeyGenerator A5;
		
		System.out.println("Please enter given key for A5/1 in binary");
		key = scanner.nextLine();
		A5 = new KeyGenerator(key);
		System.out.println("Please enter wanted size of keystream");
		length = scanner.nextInt();
		
		A5.generateKeystream(length);
		System.out.println("Here is the keysteam:");
		System.out.println(A5.getKeystream());
	}
}
