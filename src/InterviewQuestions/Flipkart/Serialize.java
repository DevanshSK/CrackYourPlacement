package InterviewQuestions.Flipkart;

public class Serialize {
    /**
     * Q.   You are given an array A of strings and we have to serialize it and return the serialized string.
     *      Serialization: Scan each element in a string, calculate its length and append it with a string and a element separator or deliminator (the deliminator is ~). We append the length of the string so that we know the length of each element.
     *      For example, for a string 'interviewbit', its serialized version would be 'interviewbit12~'.
     * */
    public String serialize(String[] A) {
        StringBuilder res = new StringBuilder("");
        for(String s : A){
            int count = 0;
            for(int i = 0; i< s.length(); i++){
                count++;
            }
            String str = s + String.valueOf(count) + "~";
            res.append(str);
        }
        return res.toString();
    }
}
