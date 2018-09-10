package HighFrequence;

public class RectangleArea223 {

    //x canot be just min -max because of the int limit
    int ComputeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.min(G, C) > Math.max(E, A) ? (Math.min(G, C) - Math.max(E, A)) : 0;
        int y = Math.min(D, H) > Math.max(B, F) ? (Math.min(D, H) - Math.max(B, F)) : 0;
        return (D - B) * (C - A) + (G - E) * (H - F) - x * y;
    }


    public int ComputeAreaSec(int A, int B, int C, int D, int E, int F, int G, int H) {

        int abcd = (A - C) * (B - D);
        int efgh = (E - G) * (F - H);

        int common = OverlapLength(A, C, E, G) * OverlapLength(B, D, F, H);

        return abcd + efgh - common;
    }

    private int OverlapLength(int A, int C, int E, int G) {
        if (C < E || A > G)
            return 0;
        return Math.min(C, G) - Math.min(A, E);
    }


    //https://leetcode.com/problems/rectangle-area/discuss/62142/If-you-want-to-laugh-look-at-my-solution
    int ComputeAreaThird(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        int coverX = C < E ? 0 : C < G ? A < E ? C - E : C - A : A > G ? 0 : A < E ? G - E : G - A;
        int coverY = D < F ? 0 : D < H ? B < F ? D - F : D - B : B > H ? 0 : B < F ? H - F : H - B;
        return area1 + area2 - coverX * coverY;
    }

}
