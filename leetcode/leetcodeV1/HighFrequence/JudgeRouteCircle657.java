package HighFrequence;

public class JudgeRouteCircle657 {
    //Approach #1: Simulation [Accepted]

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }

    //Time Complexity: O(N)O(N), where NN is the length of moves. We iterate through the string.
    //
    //Space Complexity: O(1)O(1). In Java, our character array is O(N)O(N).
}
