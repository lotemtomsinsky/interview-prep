// https://neetcode.io/problems/minimum-window-with-characters

import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // if t longer than s, then s can't contain all the chars in t 
        if (s.length() < t.length())
        {
            return "";
        }

        HashMap<Character, Integer> frequenciesT = new HashMap<>();
        // map to store all the chars in t and # times they occur
        for (char c : t.toCharArray())
        {
            frequenciesT.put(c, frequenciesT.getOrDefault(c, 0) + 1);
        }


        HashMap<Character, Integer> frequenciesS = new HashMap<>();
        int have = 0, need = frequenciesT.size();
        int minLength = Integer.MAX_VALUE, minStart = 0;
        int left = 0;

        
        // this loop expands the window with the right pointer 
        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            // if the character is a key, that means it's in t -> potential start for substring
            if (frequenciesT.containsKey(c))
            {
                // update the count of this character
                frequenciesS.put(c, frequenciesS.getOrDefault(c, 0) + 1);
                // if it matches the count in t, then increase how many of t's characters we've seen
                if (frequenciesS.get(c) == frequenciesT.get(c))
                {
                    have++;
                }
            }
            
            // When we have a valid window, try to contract it from the left.
            while (have == need) {
                // Update result if this window is smaller.
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                
                // Remove the leftmost character from the window.
                char leftChar = s.charAt(left);
                // if the leftmost char is one of the ones from the mapping, need to update the frequencies
                if (frequenciesT.containsKey(leftChar)) {
                    frequenciesS.put(leftChar, frequenciesS.get(leftChar) - 1);
                    if (frequenciesS.get(leftChar) < frequenciesT.get(leftChar)) {
                        have--;
                    }
                }
                // shrink the window
                left++;  
            }
        }

        /*
         * check min length: if it's still Integer.MAX_VALUE return "" (no substring found)
         * else return the substring formed from the left pointer + the length of the min substring
         */ 
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    
    }

    // public static boolean isValid(HashMap<Character, Integer> original, HashMap<Character, Integer> updated)
    // {
    //     for (Map.Entry<Character, Integer> entry : original.entrySet())
    //     {
    //         // not valid if the other map doesn't have this key, or has key but value < value in OG 
    //         if (!updated.containsKey(entry.getKey()))
    //         {
    //             return false;
    //         }
    //         else
    //         {
    //             if (updated.get(entry.getKey()) < entry.getValue())
    //             {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args)
    {
        // String s = "xyz";
        // String t = "xyz";
        // System.out.println(minWindow(s, t)); // expect "xyz"

        // String s = "x";
        // String t = "xy";
        // System.out.println(minWindow(s, t)); // expect ""

        String s = "ABXAXZY";
        String t = "XXYZ";
        System.out.println(minWindow(s, t)); // expect "XZY"
    }
}
