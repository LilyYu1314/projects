package MathSummary;

public class LargestPalindromeProduct_479 {
    //https://leetcode.com/problems/largest-palindrome-product/discuss/96297/Java-Solution-using-assumed-max-palindrom

    public int largestPalindrome(int n) {
        // if input is 1 then max is 9
        if (n == 1) {
            return 9;
        }

        // if n = 3 then upperBound = 999 and lowerBound = 99
        int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10;
        long maxNumber = (long) upperBound * (long) upperBound;

        // represents the first half of the maximum assumed palindrom.
        // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
        int firstHalf = (int) (maxNumber / (long) Math.pow(10, n));

        boolean palindromFound = false;
        long palindrom = 0;

        while (!palindromFound) {
            // creates maximum assumed palindrom
            // e.g. if n = 3 first time the maximum assumed palindrom will be 998 899
            palindrom = createPalindrom(firstHalf);

            // here i and palindrom/i forms the two factor of assumed palindrom
            for (long i = upperBound; upperBound > lowerBound; i--) {
                // if n= 3 none of the factor of palindrom  can be more than 999 or less than square root of assumed palindrom
                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }

                // if two factors found, where both of them are n-digits,
                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }

        return (int) (palindrom % 1337);
    }

    private long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }


    public int largestPalindromeSec(int n) {
        long upperBound = (long) Math.pow(10, n) - 1;
        long lowerBound = (long) Math.pow(10, n - 1);
        long maxNum = upperBound * upperBound;
        long firstHalf = maxNum / (long) Math.pow(10, n);
        while (firstHalf >= lowerBound) {
            long palindrome = getPal(firstHalf);
            for (long i = upperBound; i >= lowerBound; i--) {
                if (palindrome / i > upperBound || i * i < palindrome) {
                    break;
                }
                if (palindrome % i == 0) {
                    return (int) (palindrome % 1337);
                }
            }
            firstHalf--;
        }
        return (int) upperBound;
    }

    public long getPal(long i) {
        StringBuilder sb = new StringBuilder();
        return Long.parseLong(i + "" + sb.append(i).reverse().toString());
    }
}
