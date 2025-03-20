// https://neetcode.io/problems/anagram-groups

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
         * the key is a list of letters in a word sorted, and the value is the string that has those letters
         * this way anagrams of one another are grouped together
         */
        HashMap<List<Character>, List<String>> anagrams = new HashMap<>();

        for (String s: strs)
        {
            // generate the key 
            List<Character> chars = new ArrayList<>();
            for (char c : s.toCharArray())
            {
                chars.add(c);
            }
            Collections.sort(chars); // needs to be sorted because the word only has to contain same letters, order doesn't matter

            // if key alr exists, add this string to the list value associated with the key
            if (anagrams.containsKey(chars))
            {
                anagrams.get(chars).add(s);
            }
            // otherwise, make the key and make a new list with this string as the value
            else
            {
                List<String> val = new ArrayList<>();
                val.add(s);
                anagrams.put(chars, val);
            }
        }

        // add all the values in the map to a list so that we match the return type
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<List<Character>, List<String>> entry : anagrams.entrySet())
        {
            result.add(entry.getValue());
        }

        return result;
    }

}
