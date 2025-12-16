package BasicPractice;

public class ReverseString_1 {

	public static void main(String[] args) {
		
		String originalString= "hello Java";
		String reverseString="";
		
		int length=originalString.length();
		
		for(int i=length-1;i>=0;i--) 
		{
			reverseString = reverseString + originalString.charAt(i);
		}
		
		System.out.println(originalString);
		System.out.println(reverseString);
				

	}

}
