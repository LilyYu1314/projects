package BitManipulation;

public class AddBinary_67 {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;

        String str = "";

        while (i >= 0 || j >= 0 || c == 1) {
            c += i >= 0 ? a.charAt(i--) - '0' : 0;
            c += j >= 0 ? b.charAt(j--) - '0' : 0;
            str = (c & 1) + str;
            c = c >> 1;
        }

        return str;
    }
}
