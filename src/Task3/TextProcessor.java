package src1.Task3;

public class TextProcessor {

    // Count words in a sentence
    public static int countWords(String sentence) {
        // Split the sentence and count words
        // Handle empty strings
        if (sentence != null ) {
            String [] words = sentence.split(" ");
            return words.length;
        }
        return 0;
    }

    // Replace specific words
    public static String replaceWord(String text, String oldWord, String
            newWord) {
        // Replace all occurrences of oldWord with newWord
        //reduce the complexity and handels the passible errors
        if (text != null) {
            text = text.replaceAll(oldWord, newWord);
        }
        return text;
    }

    public static void main(String[] args) {
         String test1= "Java is fun and Java is powerful";
        // Count words
        System.out.println(countWords(test1));
        // Replace "Java" with "Programming"
        System.out.println(replaceWord(test1, "Java", "Programming"));
    }
}
