package TwoPointersAndSlidingWindow.hard;

import java.util.HashMap;

public class MinimumWindowSubString {
    /**
     *  Q.  Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
     *      such that every character in t (including duplicates) is included in the window.
     *      If there is no such substring, return the empty string "".
     *      The testcases will be generated such that the answer is unique.
     *
     *      # Bruteforce Solution:
     *      - Generate all substrings, and find out the minimum length of valid substring.
     *      - The frequency of characters of t will be stored in the mapp.
     *      - We use a counter to record how many chars of t will be in the substring.
     *      - We scan each char:
     *          - If char is found in map : It's frequency is +ve.
     *          - Increment counter and move on.
     *          - Also reduce the frequency of that character.
     *
     *          - If char's freq is -ve in map :
     *          - Do nothing and just mark its frequency [Decrease or -1 if not present]
     *
     *      - Also, when count == s.size() [Valid condition]
     *          - Update minimum subarray and its values.
     *      - This will calculate the minimum value from all possible substrings.
     *
     *      TC: O(N^2)
     *      SC: O(256)
     *
     *      # Optimal Solution: Use sliding window with this pattern: "Minimum substring/subarray with <condition>"
     *      - Here, the roles are reversed
     *          - We initially have an invalid condition
     *          - We expand the window the condition is valid.
     *          - Then we shrink the window until condition is valid.
     *          - Also we update the values in shrinking phase, instead of growing phase.
     *
     *      - Now we add additional logic for condition when shrinking
     *          - If length < minLength: update the minimum window and indices.
     *          - Then Increment the leftmost character in frequency map.
     *          - Check if the increment lead to +ve frequency : [Increment counter]
     *          - Increment left pointer.
     *
     *      - Else, increment the right pointer.
     *      TC: O(2N + M)
     *      SC: O(256)
     *
     *
     * */
    public String minWindowOptimal(String s, String t){
        HashMap<Character, Integer> mpp = new HashMap<>();
        int l = 0, r=0, minLength = Integer.MAX_VALUE, sIndex = -1, eIndex = -1;
        int count = 0;
        // Pre insert the target characters in map
        for (int i = 0; i < t.length(); i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }

        while(r < s.length()){
            // Handle count and decrement index.
            if(mpp.getOrDefault(s.charAt(r), -1) > 0) count++;
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0) -1);

            // Valid condition : Shrink the window
            while(count == t.length()){
                // Update the minimum substring
                if( (r-l+1) < minLength ){
                    minLength = r-l+1;
                    sIndex = l;
                    eIndex = r;
                }
                // Remove the left char from window
                mpp.replace(s.charAt(l), mpp.get(s.charAt(l)) + 1);
                if(mpp.get(s.charAt(l)) > 0)  count--;
                l++;
            }

            // Expand the window
            r++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, eIndex + 1);
    }

    public String minWindowBrute(String s, String t) {
        int minLength = Integer.MAX_VALUE, sIndex = -1, eIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> mpp = new HashMap<>();
            int count = 0;
            // Preinsert the frequency values.
            for (int j = 0; j < t.length(); j++){
                mpp.put(t.charAt(j), mpp.getOrDefault(t.charAt(j), 0) + 1);
            }

            // Evaluate the subarrays
            for (int j = i; j < s.length(); j++) {
                // Decrement the current character
                mpp.put(s.charAt(j), mpp.getOrDefault(s.charAt(j), 0) - 1);
                // Check and handle if char exist in map
                if (mpp.get(s.charAt(j)) > 0) {
                    count++;
                }


                // Handle valid substring
                if(count == t.length()){
                    if((j-i+1) < minLength){
                        minLength = j-i+1;
                        sIndex = i;
                        eIndex = j;
                    }
                    break;
                }
            }
        }
        return sIndex == -1 ? "" : s.substring(sIndex, eIndex + 1);
    }
}
