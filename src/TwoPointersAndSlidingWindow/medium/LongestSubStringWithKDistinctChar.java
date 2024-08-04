package TwoPointersAndSlidingWindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChar {
    /**
     *  Q.  Given a string you need to print longest possible substring that has exactly M unique characters.
     *      If there is more than one substring of longest possible length, then print length of them.
     *
     *      # Bruteforce solution
     *      - Generate and traverse over all possible substrings.
     *      - Count and maintain the frequency of the characters in a map.
     *      - if size > K : Not a valid substring and next substring is also not valid.
     *      TC: O(N*N)
     *      SC: O(256)
     *
     *      ## Better Solution: Using Sliding Window
     *      - Use Sliding window with 2 pointers.
     *      - Initial size is 1, then expand and record occurences in a map.
     *      - If size > K:  Shrink the window:
     *      - If size <= K: Update the max length and expand the window
     *      TC: O(2N)
     *      SC: O(256)
     *
     *
     *      ## Optimal Solution: Optimizatino on Better solution
     *      - We can shrink the window by incrementing the left window once instead of while loop.
     *      - Then we only updata max value when size <= K
     *      TC: O(N)
     *      SC: O(256)
     * */

    public static int findLongestSubStringOptimal(String s, int k){
        // Initialize a sliding window of size 1
        int l = 0, r = 0, maxlen = 0;
        // hashmap for recording occurences
        Map<Character, Integer> mpp = new HashMap<>();
        while(r < s.length()){
            // Add current character
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0) + 1);

            // Check for invalid string
            if(mpp.size() > k){
                // Shrink window until valid substring.
                mpp.replace(s.charAt(l), mpp.get(s.charAt(l))-1 );
                if(mpp.get(s.charAt(l)) == 0){
                    mpp.remove(s.charAt(l));
                }
                l++;
            }

            // Update the max length of valid substring
            if(mpp.size() <= k){
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
            }
            // Expand the window
            r++;
        }
        return maxlen;
    }
    public static int findLongestSubStringBetter(String s, int k){
        // Initialize a sliding window of size 1
        int l = 0, r = 0, maxlen = 0;
        // hashmap for recording occurences
        Map<Character, Integer> mpp = new HashMap<>();
        while(r < s.length()){
            // Add current character
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0) + 1);

            // Check for invalid string
            if(mpp.size() > k){
                // Shrink window until valid substring.
                while(mpp.size() <= k){
                    mpp.replace(s.charAt(l), mpp.get(s.charAt(l))-1 );
                    if(mpp.get(s.charAt(l)) == 0){
                        mpp.remove(s.charAt(l));
                    }
                    l++;
                }
            }

            // Update the max length of valid substring
            if(mpp.size() <= k){
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
            }
            // Expand the window
            r++;
        }
        return maxlen;
    }
    public static int findLongestSubStringBrute(String s, int k){
        int maxlen = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mpp.clear();
            for (int j = i; j < s.length(); j++) {
                // Add current character in map
                mpp.put(s.charAt(j), mpp.getOrDefault(s.charAt(j), 0) + 1);
                // check validity of substring
                if(mpp.size() <= k){
                    // Update the max length
                    int len = j - i + 1;
                    maxlen = Math.max(maxlen, len);
                }
                else{
                    // Next substrings are also invalid
                    break;
                }
            }
        }
        return maxlen;
    }


}
