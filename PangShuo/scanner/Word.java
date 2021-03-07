package scanner;

/**
 * A class for Word
 */
public class Word {

	//Define word strings
	//Reference entity info to record the location and line number of words
	private String word;
	private Info info;
	
	/**
	 * Builds a Word object with the actual
	 * word (string) 'word' and the information 'info'
	 */
	public Word(String word, Info info) {
		this.word = word;
		this.info = info;
	}
	
	/**
	 * Returns the actual word (string)
	 * of this Word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Returns the information (Info)
	 * of this Word
	 */
	public Info getInfo() {
		return info;
	}
	
	/**
	 * Returns a String representation
	 * of this Word
	 * (for testing/debugging only)
	 */
	//Returns words and information strings
	public String toString() {
		return word + " " + info;
	}
}
