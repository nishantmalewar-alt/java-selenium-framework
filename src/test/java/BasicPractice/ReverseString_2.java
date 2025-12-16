package BasicPractice;

public class ReverseString_2 {

	public static void main(String[] args) {
		
		String origiString = "SDET lvl 2";
		
		StringBuilder builder = new StringBuilder(origiString);
		builder.reverse();
		
		String reverString = builder.toString();
		
		System.out.println(origiString);
		System.out.println(reverString);
	}

}
