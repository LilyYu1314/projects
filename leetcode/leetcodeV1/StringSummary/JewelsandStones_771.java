package StringSummary;

public class JewelsandStones_771 {
    //https://leetcode.com/problems/jewels-and-stones/discuss/113574/1-liners-PythonJavaRuby

    public int numJewelsInStones(String J, String S) {
        //[^...] Matches any single character not in brackets.
        return S.replaceAll("[^" + J + "]", "").length();
    }
    //time O(n) // not too sure
    //space O(1) ????

    //Space should be O(k) k being the length of the string created by the replace, up to the length of String S if there are no characters in it that are not in String J.
    //Time: I'm a bit shakier when it comes to calculating time, but it looks like it should also be O(k), from what little research I did on it. With the same caveats on k as I said above.
    //And typically when it comes to these easy questions the solutions are something very simple and quick to implement,
    // so if you have something taking n^2 time you might be looking at an over complication.
}
