// https://neetcode.io/problems/permutation-string

import java.util.HashSet;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        // s1 can't be contained in s2 if its length is greater
        if (s1.length() > s2.length())
        {
            return false;
        }

        // count how many occurences each char in s1 occurs 
        int[] s1Freq = new int[26];
        for (int i = 0; i < s1.length(); i++)
        {
            s1Freq[(int) s1.charAt(i) - 'a']++; // letter a starts at 97 so it needs to be -97 to size to this arr
        }

        int[] s2Freq = new int[26];
        int windowSize = s1.length();
        int left = 0;

        /*
         * use a fixed sliding window of size = s1.length() to go over s2 and check frequencies of each char 
         * in the window. Because we only care about the current window, once we move it remove all old characters
         * from the s2 frequencies because we don't care about them anymore
         * 
         */
        for (int right = 0; right < s2.length(); right++)
        {
            s2Freq[(int) s2.charAt(right) - 'a']++; // track # times this char occured
            
            // check frequencies once the window is the right size
            if ((right - left + 1) == windowSize)
            {
                // if its a match, return true
                if (match(s1Freq, s2Freq))
                {
                    return true;
                }
                // if it's not a match, remove the first character in the window from the mapping and shift the 
                // beginning of the window over by 1
                s2Freq[(int) s2.charAt(left) - 'a']--;
                left++;
            }
        }

        return false;
    }

    public static boolean match(int[] arr1, int[] arr2)
    {
        for (int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] != arr2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        // String s1 = "abc";
        // String s2 = "lecabee";
        // System.out.println(checkInclusion(s1, s2)); // expect true 

        String s1 = "abc";
        String s2 = "lecaabee";
        System.out.println(checkInclusion(s1, s2)); // expect false 
    }
}
