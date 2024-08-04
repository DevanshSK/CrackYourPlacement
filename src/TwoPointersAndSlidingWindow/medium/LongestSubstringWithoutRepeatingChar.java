package TwoPointersAndSlidingWindow.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    /**
     *  Q. Given a string s, find the length of the longest substring without repeating characters.
     *
     *  # Bruteforce solution:
     *      - Explore all possible substrings and find the correct one.
     *      - Use hashing to check if char repeats or not.
     *      - Update and maintain the hash to check the occurence.
     *      TC: O(N^2)
     *      SC: O(256)
     *
     *      # Optimal Solution: Use sliding window
     *      - We need a hashing of some sort to remember the occurence of chars.
     *      - We initialize a window of size 1
     *      - Then we check if the element is already present in window.
     *          - This can be done using 2 check.
     *          - el exist in map and lies in range of window.
     *      - If found duplicate, shrink the window to next of duplicate el.
     *      - And update the position in map.
     *      - Then expand the window forward.
     *
     *      TC: O(N)
     *      SC: O(256)
     * */

    public int lengthOfLongestSubstringBrute(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = "";
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))) break;

                int len = j - i +1;
                maxLen = Math.max(maxLen, len);
                set.add(s.charAt(j));
            }
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring(String s){
        // hash array to check visited elements
        // We use array bcuz there are only 256 chars.
        int[] hash = new int[256];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }

        int l = 0, r = 0, maxlen = 0;
        while(r < s.length()){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    // Shrink window to next of repeating element
                    l = hash[s.charAt(r)] + 1;
                }
            }
            // Expand the window forwards.
            maxlen = Math.max(maxlen, r-l+1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxlen;
    }
}
