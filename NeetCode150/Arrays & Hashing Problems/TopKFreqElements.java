// https://neetcode.io/problems/top-k-elements-in-list

import java.util.HashMap;
import java.util.Map;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        // want to make a hashtable linking element -> # occurences
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (!frequencies.containsKey(nums[i]))
            {
                frequencies.put(nums[i], 1); // first occurence
            }
            else
            {
                frequencies.put(nums[i], frequencies.get(nums[i])+1);
            }
        }
        // find the most frequent element k times and each time, pop the value 
        // and store the key
        int[] topK = new int[k];
        for (int i = 0; i < k; i++)
        {
            Map.Entry<Integer, Integer> maxValuePair = frequencies.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

            topK[i] = maxValuePair.getKey();

            frequencies.remove(topK[i]);
        }

        return topK;

    }
}
