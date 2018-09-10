package HighFrequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences187 {

    //Improve a little bit. Maintain a size 10 window rather than loop through every time.
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            //this part, why do you construct a hash operation like this? Is there some conventional method to construct hash function?
            //Suggestion: code can be improved. No need to use two hashmaps. And for every “i” algorithm is iterating through all the characters. Sliding window technique can be used and perform v <<= 2; after first “for” loop and v = v& 1111111111. Using this algorithm complexity can be improved.
            //But it is a very nice solution. I learned a lot from this.
            value <<= 2;  //Line 1: move v left 2 bit, for example 01 after moving 0100
            value |= map[s.charAt(i) - 'A'];  //Line 2: Append 2 bits, 0100 | 11 => 0111
            value &= 0xfffff;  //Line 3: 0xfffff is 20 1, aka Window of 10 2bits, the bits exceed 20 bits will be 0.

            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }

        }

        return result;
    }


    public List<String> findRepeatedDnaSequencesSec(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;

            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }

            if (!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }

        return rv;
    }


    //I really like your thought about how to store the string with a much smaller type.
    //But this is actually totally unnecessary, since you still need to store the same string in your rv list.
    //Just as a comparison, with this fantastic restore method with 4 bytes integer is 32%, the code below is 98%.
    public List<String> findRepeatedDnaSequencesThird(String s) {
        Set once = new HashSet(), more = new HashSet();
        // List<String> res = new ArrayList<>();
        // char[] map = new char[26];
        // map['C' - 'A'] = 1;
        // map['G' - 'A'] = 2;
        // map['T' - 'A'] = 3;

        // convert the 10 letter string -> 32bits integer(20 bits)
        for (int i = 0; i < s.length() - 9; i++) {
            // int v = 0;
            // for (int j = i; j < i + 10; j++) {
            //     v |= map[s.charAt(j) - 'A'];
            //     v <<= 2;
            // }
            String v = s.substring(i, i + 10);
            if (!once.add(v))
                more.add(v);
            // res.add(s.substring(i, i + 10));
        }
        return new ArrayList(more); //
    }
}
