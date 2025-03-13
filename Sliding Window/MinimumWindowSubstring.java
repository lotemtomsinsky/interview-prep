// https://neetcode.io/problems/minimum-window-with-characters

import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // if t longer than s, then s can't contain all the chars in t 
        if (s.length() < t.length())
        {
            return "";
        }

        HashMap<Character, Integer> frequencies = new HashMap<>();
        String result = "";
        String shortestSub = s; // start it off here as the max value placeholder         

        // map to store all the chars in t and # times they occur
        for (char c : t.toCharArray())
        {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        boolean found = false;
        for (int right = 0; right < s.length(); right++)
        {
            // if the character is a key, that means it's in t -> potential start for substring
            if (frequencies.containsKey(s.charAt(right)))
            {
                // keep checking until either we've found all the chars contained in t or we've hit the end of s 
                while (!frequencies.isEmpty() || right < s.length() - 1)
                {
                    left = right;
                    // remove this occurence of the char from frequencies 
                    frequencies.put(s.charAt(right), frequencies.get(s.charAt(right)) - 1);
                    // if we've seen all the occurences of it, remove it from the map
                    int f = frequencies.get(s.charAt(right)); 
                    if (f == 0)
                    {
                        frequencies.remove(s.charAt(right)); 
                    }
                    
                    right++;
                }
                // we found a valid substring. dont need to do right+1 because its incrememnted an extra time in the while loop above
                String subString = s.substring(left, right);

                // if it's shorter than the previously recorded substring, make this the new minimum one encountered
                if (subString.length() <= shortestSub.length())
                {
                    shortestSub = subString;
                    found = true; // if we make the swap at least once, then a valid substring exists 
                }
            }

        }

        if (found)
        {
            result = shortestSub;
        }
        return result;
    }

    public static void main(String[] args)
    {
        // String s = "xyz";
        // String t = "xyz";
        // System.out.println(minWindow(s, t)); // expect "xyz"

        // String s = "x";
        // String t = "xy";
        // System.out.println(minWindow(s, t)); // expect ""

        String s = "OUZODYXAZV";
        String t = "XYZ";
        System.out.println(minWindow(s, t)); // expect "YXAZ"
    }
}
