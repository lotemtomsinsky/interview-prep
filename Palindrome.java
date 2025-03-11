// https://neetcode.io/problems/is-palindrome
public class Palindrome {
	public static boolean isPalindrome(String s) {
		
        // ignore all non-alphanumeric chars & spaces. Make everything lower case, and then use regex to filter out non alphanumeric 
		// chars
        String filtered = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        char[] filteredChars = filtered.toCharArray();
        int lenght = filteredChars.length;
        // find the index to "stop" at
        int mid = 0;
        
        if (lenght % 2 == 0)
        {
        	mid = lenght / 2 - 1;
        }
        else {
        	mid = lenght / 2 ;
        }
        
        for (int i = 0; i <= mid; i++)
        {
        	if (filteredChars[i] != filteredChars[lenght - i - 1])
    		{
    			return false;
    		}
        }
        
        return true;
    }
	
	public static void main(String[] args)
	{
		String s = "Was it a car or a cat I saw?";
		System.out.println(isPalindrome(s));
		
		System.out.println(isPalindrome(s));
		
	}
}
