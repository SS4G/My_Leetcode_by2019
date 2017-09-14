package AlgorithmTraining.exercise.toOffer;

/**
 * Created by BUPT_SS4G on 2017/9/14.
 */

class Solution067 {
    public boolean match(char[] str, char[] pattern)
    {
        return matchRecursive(new StringBuilder().append(str).toString(), new StringBuilder().append(pattern).toString());
    }

    private boolean matchRecursive(String str, String pat) {
        char last = ' ';
        if (str.equals("") && pat.equals("")) {
            return true;
        }
        else {
            int i = 0;
            while (i < Math.min(str.length(), pat.length()) && pat.charAt(i) != '*') {
                if (pat.charAt(i) == '.' || pat.charAt(i) == str.charAt(i)) {
                    last = str.charAt(i);
                }
                else if (pat.charAt(i) != str.charAt(i)) {
                    return false;
                }
                i++;
            }
            //now i is the index of the *
            if (i == str.length() && i == pat.length()) {
                return true;
            }
            else if (i == str.length() || i == pat.length()) {
                return false;
            }
            else {
                //System.out.println(str.substring(i - 1) + ": pat " + pat.substring(i + 1));
                boolean result = matchRecursive(str.substring(i - 1), pat.substring(i + 1)); //repeat 0 times;
                if (result)
                    return true;
                int repeatTime = 0;
                while (repeatTime + i < str.length() && str.charAt(repeatTime + i) == last) {
                    repeatTime++;
                }
                for (int j = 0; j <= repeatTime; j++) {
                    System.out.println(str.substring(i + j) + ": pat " + pat.substring(i + 1));
                    result =  matchRecursive(str.substring(j + i), pat.substring(i + 1));
                    if (result)
                        return true;
                }
                return false;
            }
        }
    }
}

public class No067 {
    public static void main(String[] args) {
        Solution067 s = new Solution067();
        //assert s.match("abcdef".toCharArray(), "abcdef".toCharArray());
        //assert s.match("abcdef".toCharArray(), "ab..ef".toCharArray());
        //assert s.match("abef".toCharArray(), "ab.*ef".toCharArray());
        //assert s.match("abef".toCharArray(), "ab*ef".toCharArray());
        //assert s.match("abbbbef".toCharArray(), "ab*ef".toCharArray());
        //assert s.match("abxxyyydef".toCharArray(), "ab.*.*def".toCharArray());
        //assert s.match("abiiiioooof".toCharArray(), "ab.*ii.*oof".toCharArray());
        assert s.match("aasdh".toCharArray(), ".*.*.*.*".toCharArray());
        //assert s.match("".toCharArray(), ".*.*.*.*".toCharArray());

    }
}
