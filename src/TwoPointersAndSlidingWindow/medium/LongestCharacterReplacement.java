package TwoPointersAndSlidingWindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestCharacterReplacement {
    /**
     *  Q.  You are given a string s and an integer k.
     *      You can choose any character of the string and change it to any other uppercase English character.
     *      You can perform this operation at most k times.
     *      Return the length of the longest substring containing the same letter you can get after performing the above operations.
     *
     *      # Bruteforce Solution
     *      - How to determine which and how many characters to change.
     *      - Generate all substrings
     *      - We can get the changes by removing the highest freq from the length.
     *      -       Changes = length - maxFrequency
     *      - We can also use a Hashmap to store frequencies.
     *      - If no of changes increases beyond, then those are not valid subarrays.
     *      TC: O(N*N)
     *      SC: O(26)
     *
     *
     *
     *      # Better Solution: Use sliding window
     *      - Valid criteria: len - maxF <= K
     *      - Valid: Expand the window and update maxLength
     *      - Invalid: Shrink the window and update the maxF again.
     *      TC: O( 26 * 2N )
     *      SC: O(26)
     *
     *
     *      # Optimizations:
     *      - Do not calculate maxFreq in shrinking phase:
     *          - As the length increase, the only chance to convert infavourable situation to favourable is to increase the maxF.
     *          - Also, this reduces TC from 26 * 2N to 2N
     *      - Only shrink the window once per iteration.
     *          - Updation can be done when condition is valid.
     *          - Also, logically if we want count or maximum subarray,
     *          - The shrinking while loop is not needed.
     *
     *
     *
     * */

    public int characterReplacementOptimal(String str, int k){
        int l = 0, r=0, maxLen = 0, maxF = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();

        while(r < str.length()){
            // Add character to hash
            mpp.put(str.charAt(r), mpp.getOrDefault(str.charAt(r), 0) + 1);
            // Update max frequency
            maxF = Math.max(maxF, mpp.get(str.charAt(r)));

            // Optimizations add here:
            if( (r-l+1) - maxF > k ){
                // Shrink the window once.
                // remove the left character from the frequency.
                mpp.replace(str.charAt(l), mpp.get(str.charAt(l)) - 1);
                if(mpp.get(str.charAt(l)) == 0) mpp.remove(str.charAt(l));
                l++;
            }

            if( (r-l+1) - maxF <= k ){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public int characterReplacementBetter(String str, int k){
        int l = 0, r=0, maxLen = 0, maxF = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();

        while(r < str.length()){
            // Add character to hash
            mpp.put(str.charAt(r), mpp.getOrDefault(str.charAt(r), 0) + 1);
            // Update max frequency
            maxF = Math.max(maxF, mpp.get(str.charAt(r)));

            // Check for invalid case:
            while( (r-l+1) - maxF > k ){
                // Shrink the window
                // remove the left character from the frequency.
                mpp.replace(str.charAt(l), mpp.get(str.charAt(l)) - 1);
                if(mpp.get(str.charAt(l)) == 0){
                    mpp.remove(str.charAt(l));
                }

                // Calculate maximum frequency in map
                maxF = 0;
                for(Map.Entry<Character, Integer> temp : mpp.entrySet()){
                    maxF = Math.max(maxF, temp.getValue());
                }
                l++;
            }

            if( (r-l+1) - maxF <= k ){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }


    public int characterReplacementBrute(String str, int k){
        int maxLength = 0;
        // Generate all substrings
        for (int i = 0; i < str.length(); i++) {
            // Hashmap to store all values.
            HashMap<Character, Integer> mpp = new HashMap<>();
            int maxFreq = 0;
            for (int j = i; j < str.length(); j++) {
                // Add current char to hash
                mpp.put(str.charAt(j), mpp.getOrDefault(str.charAt(j), 0) + 1);
                // Find max frequency
                maxFreq = Math.max(maxFreq, mpp.get(str.charAt(j)));
                // Calculate no of changes
                int changes = (j - i + 1) - maxFreq;
                // Check if substring fits valid critera.
                if(changes <= k){
                    maxLength = Math.max(maxLength, j - i + 1);
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }
}
