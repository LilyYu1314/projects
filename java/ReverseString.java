import org.junit.Test;

public class ReverseString {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            System.out.println("i: "+i);
            System.out.println("j: "+j);
            System.out.println("word[i]: "+word[i]);
            System.out.println("word[j]: "+word[j]);
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    @Test
    public  void test() {
        //System.out.println("Hello World!");
        String S= "hello";
        this.reverseString(S);
    }
}
