package HighFrequence;

public class ReverseWordsinaStringIII557 {
    //Approach #1 Simple Solution[Accepted]
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}
