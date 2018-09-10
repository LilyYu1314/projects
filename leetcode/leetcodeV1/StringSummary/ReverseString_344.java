package StringSummary;

public class ReverseString_344 {
    //https://leetcode.com/problems/reverse-string/discuss/80937/JAVA-Simple-and-Clean-with-Explanations-6-Solutions

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    //Complexity Analysis
    //Time Complexity: `O(n)` (Average Case) and `O(n)` (Worst Case) where `n` is the total number character in the input string.
    // Depending on the implementation. However, it is not possible to reverse string in less than `O(n)`.
    //
    //Auxiliary Space: `O(n)` space is used where `n` is the total number character in the input string.
    // Space is needed to transform immutable string into character buffer in StringBuilder


    public String reverseStringSec(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
    //Time Complexity: `O(n)` (Average Case) and `O(n)` (Worst Case) where `n` is the total number character in the input string.
    // The algorithm need to reverse the whole string.
    //
    //Auxiliary Space: `O(n)` space is used where `n` is the total number character in the input string.
    // Space is needed to transform string to character array.

}


//I would not recommend using byte arrays, as it assumes all the characters are from the ASCII set.
// For characters beyond that set you might get negative values.