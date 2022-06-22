/**
 * This class reads a file from command line
 * and prints the contens of the file
 * 
 * 
 * @author chris
 *
 */

public class lab5main {

	public static void main(String[] args) {
		
		String fileName = "text.txt";
		String[] wordArray = new String[20];
		
		inputFromFile(fileName, wordArray);
		for(int i = 0; i < 8; i++) {
			System.out.println(wordArray[i]);
		}
	}
	private static int inputFromFile(String filename, String[] words){
		TextFileInput in = new TextFileInput(filename);
		int lengthFilled = 0;
		String line = in.readLine();
		while ( lengthFilled < words.length && line != null ) {
			words[lengthFilled++] = line; 
			line = in.readLine(); 
		}
		if ( line != null ) {
			System.out.println("File contains too many numbers.");
			System.out.println("This program can process only " + words.length + " numbers."); System.exit(1);
			} 
		in.close();
		return lengthFilled;
	} // method inputFromFile 
}

