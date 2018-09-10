package BitSummary;

public class SingleNumber_136 {
    //If we take XOR of zero and some bit, it will return that bit
    //a \oplus 0 = aa⊕0=a
    //If we take XOR of two same bits, it will return 0
    //a \oplus a = 0a⊕a=0
    //a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b

    int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= A[i];
        }
        return result;
    }

    //Complexity Analysis
    //Time complexity : O(n)O(n). We only iterate through \text{nums}nums,
    // so the time complexity is the number of elements in \text{nums}nums.
    //
    //Space complexity : O(1)O(1).
}
