// // https://neetcode.io/problems/string-encode-and-decode 

import java.util.*;

public class EncodeAndDecode {
    public static String encode(List<String> strs) {
        String[] updated = new String[strs.size()];

        // want to append the length of each string and a # to each element
        for (int i = 0; i < strs.size(); i++)
        {
            String len = String.valueOf(strs.get(i).length()).concat("#");
            updated[i] = len.concat(strs.get(i));
        }

        String encodedString = String.join("", updated);

        return encodedString;
    }

    public static List<String> decode(String str) {
    	
    	List<String> decoded = new ArrayList<>();
    	
    	while (str.length() != 0)
    	{
    		int hashIndex = str.indexOf("#");
    		int length = Integer.parseInt(str.substring(0, hashIndex));
    		String element = str.substring(hashIndex + 1, hashIndex + length + 1);
    		decoded.add(element);
    		
    		str = str.substring(hashIndex + length + 1);
    		
    	}
    	
    	return decoded;
    }
    
    
    public static void main(String[] args)
    {
    	List<String> str = new ArrayList<>();
    	str.add("neet");
    	str.add("code");
    	str.add("love");
    	str.add("you");
    	
    	String encoded = encode(str);
    	System.out.println("the encoded string is: " + encoded);
    	
    	List<String> decoded = decode(encoded);
    	System.out.println("the decoded elements are:");
    	for (String el : decoded)
    	{
    		System.out.println(el);
    	}
    }
    

}