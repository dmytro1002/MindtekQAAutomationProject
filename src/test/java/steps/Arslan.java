package steps;

import java.util.HashMap;
import java.util.Map;

public class Arslan {

    public static void main(String[] args) {
        //Write a code that counts number of letters in String? String str=”Java”; output: J=1, a=2, v=1
        String str1 = "Java is unbelievable";
        System.out.println(countLetters(str1));

    }
    private static Map<Character, Integer> countLetters(String str1) {
        Map<Character, Integer> count = new HashMap<>();
        String replaced = str1.replaceAll(" ", "");
        for (int i = 0; i < replaced.length(); i++) {
            if(!count.containsKey(replaced.charAt(i))){
                count.put(replaced.charAt(i), 1);
            }else{
                count.put(replaced.charAt(i), count.get(replaced.charAt(i))+1);
            }
        }
        return count;
    }
}
