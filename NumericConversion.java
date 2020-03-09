/* Numeric Conversion
 * Created by Noah Burkhart
 * Last Modified 2-11-20
 */
import java.util.Scanner;
public class NumericConversion {
    public static void main(String[] args) {
        // Initializes variables needed for while loop to run, then starts while loop
        int choice = 0;
        Scanner scnr = new Scanner(System.in);
        while (choice != 4) {
            // Prints menu and (if user has not decided to quit) prompts for conversion
            System.out.println("Decoding Menu");
            System.out.println("------------- ");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit ");
            System.out.print("\nPlease enter an option: ");
            choice = scnr.nextInt();
            if(choice != 4) {
                System.out.print("Please enter the numeric string to convert: ");
            }
            // Calls proper methods for conversion, or quits
            switch(choice) {
                case 1:
                    long result = hexStringDecode(scnr.next());
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    short shResult = binaryStringDecode(scnr.next());
                    System.out.println("Result: " + shResult);
                    break;
                case 3:
                    System.out.println("Result: " + binaryToHex(scnr.next()));
                    break;
                case 4:
                    System.out.println("Goodbye!");
            }
            System.out.println();
        }
    }

    // Decode hex String to decimal
    public static long hexStringDecode(String hex) {
        // Appends prefix if it is missing
        if(hex.charAt(0) != '0') {
            hex = "0x" + hex;
        }
        long result = 0;
        int length = hex.length();
        // For each char in the string after the prefix, adds that number's value to total
        // after calling hexCharDecode
        for(int i = 2; i < length; i++) {
            result += hexCharDecode(hex.charAt(i)) * (Math.pow(16, (length - i) - 1));
        }
        return(result);
    }

    // Decode one character of hex to decimal
    public static short hexCharDecode(char digit) {
        // Uses switch based on char to determine numeric value (break statements are
        // redundant because return statements end the program)
        switch(digit) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'a':
            case 'A':
                return 10;
            case 'b':
            case 'B':
                return 11;
            case 'c':
            case 'C':
                return 12;
            case 'd':
            case 'D':
                return 13;
            case 'e':
            case 'E':
                return 14;
            case 'f':
            case 'F':
                return 15;
            default:
                return 0;
        }
    }

    // Decodes binary string to decimal
    public static short binaryStringDecode(String binary) {
        short result = 0;
        int length = binary.length();
        int j = 0;
        if (binary.charAt(1) == 'b') {
            j = 2;
        }
        // For each char: if it is a 1, adds that value to total, otherwise does nothing
        for (int i = j; i < length; i++) {
            if (binary.charAt(i) == '1') {
                result += (Math.pow(2, (length - i) - 1));
            }
        }
        return result;
    }

    // Converts binary string to hexadecimal string
    public static String binaryToHex (String binary) {
        // Decodes binary string to decimal
        short shResult = binaryStringDecode(binary);
        String result = "";
        int max = 16;
        char nextDigit;
        int nextVal;
        // For each power of 10 up to the decimal number, encodes that value as hexadecimal
        while (shResult > 0) {
            nextVal = shResult % 16;
            switch(nextVal) {
                case 10:
                    nextDigit = 'A';
                    break;
                case 11:
                    nextDigit = 'B';
                    break;
                case 12:
                    nextDigit = 'C';
                    break;
                case 13:
                    nextDigit = 'D';
                    break;
                case 14:
                    nextDigit = 'E';
                    break;
                case 15:
                    nextDigit = 'F';
                    break;
                default:
                    nextDigit = (char)(nextVal + '0');
            }
            result = nextDigit + result;
            shResult /= 16;
        }
        return result;
    }

}
