// https://neetcode.io/problems/is-anagram

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        {
            return false; 
        }

        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        for (int i = 0; i < s.length(); i++)
        {
            s1freq[(int) s.charAt(i) - 'a']++;
            s2freq[(int) t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1freq.length; i++)
        {
            if (s1freq[i] != s2freq[i])
            {
                return false;
            }
        }

        return true;
    }
}
