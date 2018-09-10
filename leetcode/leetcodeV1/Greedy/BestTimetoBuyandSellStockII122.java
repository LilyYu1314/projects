package Greedy;

import org.junit.Test;

//solution, Approach 3: Simple One Pass
public class BestTimetoBuyandSellStockII122 {
        public int maxProfit(int[] prices) {
            int maxprofit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxprofit += prices[i] - prices[i - 1];
            }
            return maxprofit;
        }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        int[] prices = {7,1,5,3,6,4};

        int result = this.maxProfit(prices);
        System.out.println("result: "+result);
    }
}
