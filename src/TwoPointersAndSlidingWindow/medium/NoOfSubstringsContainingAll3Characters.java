package TwoPointersAndSlidingWindow.medium;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoOfSubstringsContainingAll3Characters {
    /**
     *  Q.  Given a string s consisting only of characters a, b and c.
     *      Return the number of substrings containing at least one occurrence of all these characters a, b and c.
     *
     *
     * */
    public int numberOfSubstrings(String s) {
        int[] lastseen = { -1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            lastseen[s.charAt(i) - 'a'] = i;
            int min = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
            count = count + (1 + min);
        }
        return count;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            int num = Integer.parseInt(input);
            int fact = 1;
            for(int i = 1; i<= num; i++){
                fact *= i;
            }
            System.out.println(fact);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
