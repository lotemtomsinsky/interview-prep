// https://neetcode.io/problems/longest-repeating-substring-with-replacement

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatCharReplacement {
    public static int characterReplacement(String s, int k) {
       int maxLength = 0;
       
       // find the most frequently occuring char in s so we can minimize # replacements needed
       HashMap<Character, Integer> occurences = new HashMap<>();
       for (int i = 0; i < s.length(); i++)
       {
            if (occurences.containsKey(s.charAt(i)))
            {
                occurences.put(s.charAt(i), occurences.get(s.charAt(i)) + 1);
            }
            else
            {
                occurences.put(s.charAt(i), 1);
            }
       }
       int maxCount = 0;
       char mostFreq = s.charAt(0); // just a default
       for (Map.Entry<Character, Integer> entry : occurences.entrySet())
       {
            if (entry.getValue() > maxCount)
            {
                maxCount = entry.getValue();
                mostFreq = entry.getKey();
            }
       }

       // go through the string and do the K replacements
       char[] a = s.toCharArray();
       int replaced = 0; 
       for (int i = 0; i < a.length; i++)
       {
            /*
             * TODO: fix replacement logic, which includes somehow updating occurences map to check the conditions
             * we need to replace if:
             * 1. we haven't replaced up to k times yet
             * 2. there's at least 2 unique charactres in the string 
             */
            if (replaced < k && occurences.size() > 2)
            {
                if (a[i] != mostFreq) 
                {
                    a[i] = mostFreq;
                    replaced++;
                }
            }
            else
            {
                break;
            } 
        }

        // TODO: implement the final part, checking for longest substring with 1 unique char 
        // look through the new string for the longest substring with only 1 unique char
        String newS = new String(a);
        System.out.println(newS);
       
       return maxLength;
    }

    public static void main(String[] args)
    {
        String s1 = "XYYX";
        int k1 = 2;
        System.out.println(characterReplacement(s1, k1)); // expect 4

        // String s2 = "AAABABB";
        // int k2 = 1;
        // System.out.println(characterReplacement(s2, k2)); // expect 4
    }
}
