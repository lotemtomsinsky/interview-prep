// https://neetcode.io/problems/longest-substring-without-duplicates

import java.util.HashSet;

public class LongestSubstrNoRepeatChar {
    
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> strContent = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            while (strContent.contains(c))
            {
                strContent.remove(s.charAt(left));
                left++;
            }

            strContent.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args)
    {
        //String s = "zxyzxyz"; // expect 3
        //String s = "xxxx"; // expect 1
        String s="pwwkew"; // expect 3
        //String s = " "; // expect 1
        //String s = "dvdf"; // expect 3

        System.out.println(lengthOfLongestSubstring(s));
    }
}
