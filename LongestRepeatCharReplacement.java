// https://neetcode.io/problems/longest-repeating-substring-with-replacement

import java.util.HashMap;

public class LongestRepeatCharReplacement {
    public static int characterReplacement(String s, int k) {
       HashMap<Character, Integer> occurences = new HashMap<>();
       int maxLength = 0;
       int maxCount = 0;
       char[] a = s.toCharArray();
       int left = 0;
       
       for (int right = 0; right < a.length; right++)
       {
            occurences.put(a[right], occurences.getOrDefault(a[right], 0) + 1);
            maxCount = Math.max(maxCount, occurences.get(a[right]));
           
            /*
             * we compare the size of the current window - # occurences of the most frequent character in the window
             * if that's bigger than k, then that means k replacements wont be enough for us to get a substring with 
             * a unique character so we need to shrink the window.
             * 
             * While that's the case, keep shrinking the window, during which time we remove the character occurence
             * from the map because we're not considering it anymore until the window size becomes valid
             */
            while ((right - left +1) - maxCount > k)
            {
                occurences.put(a[left], occurences.get(a[left]) - 1);
                left++;
            }

            /*
             * when the window size becomes valid, compare the current window against the last recorded max window size
             * and update accordingly
             */
            maxLength = Math.max(maxLength, right - left + 1);
        }

       return maxLength;
    }

    public static void main(String[] args)
    {
        String s1 = "XYYX";
        int k1 = 2;
        System.out.println(characterReplacement(s1, k1)); // expect 4

        String s2 = "AAABABB";
        int k2 = 1;
        System.out.println(characterReplacement(s2, k2)); // expect 5

        String s3 = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k3 = 4;
        System.out.println(characterReplacement(s3, k3)); // expect 7

    }
}
