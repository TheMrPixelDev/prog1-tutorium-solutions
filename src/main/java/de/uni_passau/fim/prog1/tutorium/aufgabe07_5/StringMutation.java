package de.uni_passau.fim.prog1.tutorium.aufgabe07_5;


/**
 * Aufgabe 8
 */
public class StringMutation {

    public static void main(String[] args) {
        // a)
        replaceAllA("Alle As sollen zu Es ersetzt werden!");
        // b)
        insertSpaces("Rindfleischetikettierungsüberwachungsaufgabenübertragungsgesetz");
    }

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
        System.out.println("Der String " + str + " wurde  zu " + output + " konvertiert.");
    }

    private static void insertSpaces(final String str) {
        String output = str;

        //Starte an 5. Stelle
        int i = 4;
        while (i < output.length()) {
            output = output.substring(0, i + 1) + " " + output.substring(i + 1);

            //Hier wird + 6 addiert, da durch ein Leerzeichen noch ein neues char eingefügt wurde.
            i = i + 6;
        }

        System.out.println("Der String " + str + " wurde " + output + " konvertiert.");
    }
}
