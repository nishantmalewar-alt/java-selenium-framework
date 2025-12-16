package BasicPractice;

public class FindMaxNoInArray {

	public static void main(String[] args) {
		
		int[] numbers = {15,25,35,8,9};
		int max = numbers[0];
		
		for(int i=1; i< numbers.length; i++)
		{
			if(numbers [i]>max) 
			{
				max =numbers[i];
			}
		}
		
		//System.out.println(java.util.Arrays.toString(numbers));
		System.out.println(max);
		System.out.println(java.util.Arrays.toString(numbers));
	} 

		
//		int[] numbers= {5,6,23,34,53,22,11};
//		
//		OptionalInt maxStream = Arrays.stream(numbers).max();
//		
//		
//		if(maxStream.isPresent()) {
//			System.out.println(maxStream.getAsInt());
//		}
//	}
	
		
	}
	
	
	    
	