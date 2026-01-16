package de.uni_passau.fim.prog1.tutorium.aufgabe07_5;


/**
 * Write a static method for each of the following sub-tasks in which a modification is
 * performed on a string.
 * Hint: The method toCharArray() might be useful.
 */
public class StringMutation {

    public static void main(String[] args) {
        // (a)
        replaceAllA("An apple falls on the ground.");
        // (b)
        insertSpaces("HereSomeSpacesAreInsertedAtEvery5thPosition");
    }

    /**
     * Write a method, which replaces all occurrences of 'A' or 'a' with 'E' or 'e' in the given string.
     */
    private static void replaceAllA(final String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a') {
                charArray[i] = 'e';
            } else if (charArray[i] == 'A') {
                charArray[i] = 'E';
            }
        }
        String output = new String(charArray);
        System.out.println("The String " + str + " was converted to " + output);
    }

    /**
     * Write a method which inserts a space after every fifth character.
     * Note : The space should be inserted and not replace any other character.
     * Hint : You may need to copy the string or array.
     */
    private static void insertSpaces(final String str) {
        String output = str;

        //Start at the fifth position
        int i = 4;
        while (i < output.length()) {
            output = output.substring(0, i + 1) + " " + output.substring(i + 1);

            //Adding +6 since when adding another character in between, there is one additional character there.
            i = i + 6;
        }

        System.out.println("The String " + str + " was converted to " + output);
    }
}
