package homeWorks;

public class StringMethods {
    public static void main(String[] args) {
        String word1 = "Learning";
        String word2 = "String meTHods.";
        System.out.println("word1 in uppercase: " + word1.toUpperCase());
        System.out.println("word2 in lowercase: " + word2.toLowerCase());
        System.out.println("the length of word1: " + word1.length());
        System.out.println("the length of word2: " + word2.length());
        if(word1.contains("ing")){
            boolean item1 = true;
            System.out.println("word1 contains \"ing\": " + item1);
        }
        if(word2.contains("yes")){

            System.out.println("word2 contains \"yes\": " + true);
        }
        else{
            System.out.println("word2 contains \"yes\": " + false);
        }

        if(word2.contains("ing")){
            boolean item3 = true;
            System.out.println("word2 contains \"ing\": " + item3);
        }
        if(word1.toLowerCase().equals("learning")){
            boolean item4 = true;
            System.out.println("lowercased word1 equals to \"learning\": " + item4);
        }
        if(word2.toUpperCase().equals("String Methods")){

            System.out.println("uppercase word2 equals to \"String Methods\": " + true);
        }
        else{
            System.out.println("uppercase word2 equals to \"String Methods\": " + false);
        }
        System.out.println(word1+word2);
    }
}
