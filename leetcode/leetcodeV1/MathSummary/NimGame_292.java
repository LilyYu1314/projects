package MathSummary;

public class NimGame_292 {
    //You can always win a Nim game if the number of stones nn in the pile is not divisible by 44.

    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

    //Complexity Analysis
    //Time complexity is O(1)O(1), since only one check is performed.
    // No additional space is used, so space complexity is also O(1)O(1).
}
