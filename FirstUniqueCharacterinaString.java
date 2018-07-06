import org.junit.Test;

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++){
            freq [s.charAt(i) - 'a'] ++;
            System.out.println("freq [s.charAt(i) - 'a']:   "+freq [s.charAt(i) - 'a']);
        }
        System.out.println();
        for(int i = 0; i < s.length(); i ++){
            System.out.println("freq [s.charAt(i) - 'a']:   "+freq [s.charAt(i) - 'a']);
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }


    @Test
    public  void test() {
        //System.out.println("Hello World!");
        String S= "loveleetcode";
        this.firstUniqChar(S);
    }
}
