package de.uni_passau.fim.prog1.tutorium.tutorial4.exercise20;

/**
 * Create a method isPalindrom which checks whether a given char-Array contains a palindrom.
 * Returns true if the given array contains a palindrom.
 * A palindrom is a word which does not change if you reverse it.
 * <p>
 * Example: otto, maoam, rentner, asdffdsa, foooof
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */
public class Palindrome {

    public static void main(String[] args) {

        // rennEr ist kein Palindrom, da e != E
        char[] rennEr = {'r', 'e', 'n', 'n', 'E', 'r'};
        System.out.println("Ist '" + String.valueOf(rennEr) + "' ein Palindrom? " + (isPalindrome(rennEr) ? "Ja" : "Nein"));

        // rentner ist ein Paldindrom
        char[] rentner = {'r', 'e', 'n', 't', 'n', 'e', 'r'};
        System.out.println("Ist '" + String.valueOf(rentner) + "' ein Palindrom? " + (isPalindrome(rentner) ? "Ja" : "Nein"));
    }

    /**
     * Gibt zurück, ob ein gegebenes Wort in Form eines char-Arrays ein Palindrom ist.
     *
     * @param charArray gegebenes Wort in Form eines char-Arrays.
     * @return Ob, das gegebene Wort ein Palindrom ist.
     */
    private static boolean isPalindrome(char[] charArray) {

        // man muss das Wort nur bis zur Hälfte durchgehen,
        // da man die erste Hälfte mit der zweiten vergleicht
        for (int i = 0; i < ((charArray.length / 2) - 1); i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
