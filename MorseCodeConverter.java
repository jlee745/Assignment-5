import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MorseCodeConverter class provides methods to convert Morse code into English.
 * It uses a MorseCodeTree to fetch the corresponding English letters for the Morse code.
 * This class can convert a string of Morse code or a file containing Morse code into English.
 * 
 * @see MorseCodeTree
 * @see TreeNode
 * @see java.io.File
 * @see java.util.Scanner
 * @see java.util.ArrayList
 * 
 * @author JLi
 * 
 * @version 1.0
 */

public class MorseCodeConverter {
	private static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	/**
     * Returns a string with all the data in the MorseCodeTree in LNR order with a space between them.
     * 
     * @return a string with all the data in the tree in LNR order separated by a space.
     */
	public static String printTree() {
		ArrayList<String> list = morseCodeTree.toArrayList();
	    StringBuilder sb = new StringBuilder();
	    for (String s : list) {
	        sb.append(s).append(" ");
	    }
	    return sb.toString().trim();
	}
	
	/**
     * Converts a string of Morse code into English. Each letter is delimited by a space (' ').
     * Each word is delimited by a '/'.
     * 
     * @param code the Morse code string to be converted.
     * @return the English translation of the Morse code.
     */
	public static String convertToEnglish(String code) {
	    StringBuilder result = new StringBuilder();
	    String[] words = code.split(" / ");
	    for (String word : words) {
	        String[] letters = word.split(" ");
	        for (String letter : letters) {
	            result.append(morseCodeTree.fetch(letter));
	        }
	        result.append(" ");
	    }
	    return result.toString().trim();
	}
	
	/**
     * Converts a file of Morse code into English. Each letter is delimited by a space (' ').
     * Each word is delimited by a '/'.
     * 
     * @param codeFile the file containing the Morse code to be converted.
     * @return the English translation of the Morse code in the file.
     * @throws FileNotFoundException if the file is not found.
     */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(codeFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) { 
                result.append(convertToEnglish(line)).append("\n");
            }
        }
        scanner.close();
        return result.toString().trim();
    }
}