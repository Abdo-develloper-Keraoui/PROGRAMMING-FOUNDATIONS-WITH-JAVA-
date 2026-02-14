package Chapter5;

public class WordCounter {
    public static int countWords(String sentence) {
        if(sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        System.out.println(countWords("Hello World"));          // 2
        System.out.println(countWords("  spaces  everywhere ")); // 2
        System.out.println(countWords(""));                      // 0
        System.out.println(countWords("OneWord"));               // 1
    }
}
