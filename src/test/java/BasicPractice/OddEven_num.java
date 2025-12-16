package BasicPractice;

import java.util.Scanner;

public class OddEven_num {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int num= scanner.nextInt();
		
		if(num%2==0)
		{
			System.out.println(num + " even");
		}
		else {
			System.out.println(num + " odd");
		}
		scanner.close();
	}

}
