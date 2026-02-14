package Chapter4;


public class Palindrome {
    /*public static boolean isPalindrome(String str) {
        String strBackwards = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            strBackwards += str.charAt(i);
        }
        return str.equalsIgnoreCase(strBackwards);
    }
    */

    //using stringbuilder
    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
       }

        String strBackwards = sb.toString();
        return str.equalsIgnoreCase(strBackwards);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A"));
    }
}
