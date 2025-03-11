// https://neetcode.io/problems/longest-substring-without-duplicates

import java.util.HashSet;

public class LongestSubstrNoRepeatChar {
    
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> strContent = new HashSet<>();
        int maxLength = 0;

        for (char c: s.toCharArray())
        {
            if (!strContent.contains(c))
            {
                strContent.add(c);
            }
            else
            {
                maxLength = Math.max(maxLength, strContent.size());
                strContent.clear();
                strContent.add(c); // otherwise we skip the letter we're currently looking at as part of a potential substring
            }
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        //String s = "zxyzxyz"; // expect 3
        //String s = "xxxx"; // expect 0
        String s="pwwkew"; // expect 3

        System.out.println(lengthOfLongestSubstring(s));
    }
}
