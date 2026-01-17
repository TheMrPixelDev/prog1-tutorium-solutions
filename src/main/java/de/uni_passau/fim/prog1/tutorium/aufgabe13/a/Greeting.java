package de.uni_passau.fim.prog1.tutorium.aufgabe13.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Greeting: Write a program that first uses the Scanner to read a string input from
 * the console and then prints "Hello <input>". In case of an error (Exception), a
 * meaningful error message should be displayed. The following packages need to be
 * imported:
 * <blockquote><pre>
 * import java.io.InputStreamReader;
 * import java.util.Scanner;
 * import java.io.BufferedReader;
 * </pre></blockquote>
 */
public class Greeting {

    /**
     * This program reads one line at a time from the console using {@link BufferedReader} and {@link Scanner}
     * and outputs it to the console with a prefix.
     *
     * @param args Console arguments that are not used in this program.
     */
    public static void main(String[] args) {
        /*
         * Initialization of the BufferedReader. The BufferedReader can be given an input source as a parameter
         * via the constructor. It must be an instance of the ‘Reader’ class.
         * This could be a FileReader, a StringReader, or an InputStreamReader, for example.
         * System.out is already known and is an OutputStream. Its counterpart is System.in, an InputStream
         * that can read data from the console.
         *
         * The InputStreamReader decodes the bytes you entered in the console into characters.
         * The BufferedReader provides a buffer that allows the input to be read more efficiently.
         */
        final InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);


        /*
         * Initialization of the scanner. The scanner must be provided
         * with an input source as a parameter via the constructor.
         * Since the console inputs are to be read, you can directly
         * specify an InputStream. As above, System.in is selected again.
         */
        Scanner scanner = new Scanner(new InputStreamReader(System.in));


        // BufferedReader
        System.out.println("Reading input with BufferedReader: ");

        /*
         * Reading process using BufferedReader and storing the input in the string `input1`.
         * Errors could potentially occur during the reading process with readLine(). A simple example of this is
         * reading a source from the Internet without a connection.
         * Although such behavior is the exception, it is still important to deal with it appropriately.
         * A try/catch construct is used for this purpose. "I try to execute something, but if
         * my program fails in the try block, the catch block is called."
         * The catch block has another parameter, in this case an IOException. The readLine() method specifies in the
         * method header “throws IOException” that this exception could occur when the method is called.
         * Specifically, in the event of an error, the code “throw new IOException” is called, i.e., an instance
         * of the IOException class is created and thrown. This exact instance is then passed to the catch block.
         *
         * An IOException is a “checked” exception. The compiler checks whether this exception is handled.
         * Without a try/catch construct, the program would not compile.
         * Another option would be to pass the exception to the calling method. To do this, you would specify “throws IOException” in
         * this method, just as it is defined in readLine().
         * The choice of exception handling depends on the functionality of the method.
         */
        try {
            String input1 = bufferedReader.readLine();
            System.out.println("Hello " + input1);
        } catch (IOException e) {
            System.err.println("Error during input with BufferedReader!");
        }


        // Scanner
        System.out.println("Reading input with Scanner: ");

        /*
         * Reading process by the scanner and storage of the input in the string `input2`.
         * Similar to BufferedReader, an exception may occur.
         * Specifically, a NoSuchElementException may occur, which is an “unchecked” exception.
         * Such “unchecked” exceptions are not checked by the compiler. The program compiles first,
         * but as soon as the exception occurs and is not handled, the program unfortunately crashes.
         * Unchecked exceptions often indicate programming errors or signal that the
         * program cannot recover from the exception behavior that occurred.
         */
        try {
            String input2 = scanner.nextLine();
            System.out.println("Hello " + input2);
        } catch (NoSuchElementException e) {
            System.err.println("Error during input with Scanner!");
        }
    }
}


