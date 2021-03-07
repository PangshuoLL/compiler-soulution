package scanner;

import java.io.*;

/**
 * This class implements a word (string) scanner
 */
//Scan words in sentences
public class WordScanner
{

	private BufferedReader input; //Read in an input file
	private String line; // Gets the current row
	private int charPos; // The position of the character in the current line
	private int lineNum; // The line number of the current line
	
	/**
	 * Builds a WordScanner object based on the given input
	 */
	public WordScanner(FileReader input) throws IOException
	{
		this.input = new BufferedReader(input);
		this.line = this.input.readLine();
		this.charPos = 0;
		this.lineNum = 1;
		moveToNextWord();
	}
	
	/**
	 * Returns the next word from input
	 * Precond: there must be at least
	 * one word left in the input
	 * (i.e. hasNextWord() must evaluate to true)
	 */
	//Traverses the elements of a word from the beginning of the word to the non word elements, 
	//and writes the word object (string and information (location and line number))
	public Word nextWord() throws IOException //Used to return a word message
	{
		int start = charPos;//Record at start, the initial position of the current line
		charPos++;
		boolean isWord = true; //Determines whether the current character belongs to a word
		
		while ( charPos < line.length() && isWord ) 
		{
			char c = line.charAt(charPos);
			if ( isLetter(c) || ( c == '\'' && charPos + 1 < line.length() && isLetter(line.charAt(charPos+1) ) ) )
				charPos++;
			else  //If the scan finds a space or other symbol, the scan for the current word ends
				isWord = false;
		}
		Word w = new Word(line.substring(start, charPos),new Info(start+1,lineNum));
		moveToNextWord(); //Moves the pointer to the next word
		return w;
	}
	
	/**
	 * Returns true if there is at least
	 * one word left in the input, false otherwise
	 */
	public boolean hasNextWord()  
	{
		return line != null;
	}
	
	//Scanning starts at charPos 
	//and skips the end of the line and invalid characters 
	//until you find alphabetic characters that break out of the loop
	private void moveToNextWord() throws IOException 
	{
		boolean hasLetter = true;
		while ( line != null && hasLetter ) 
		{
			if ( charPos == line.length() ) //If the pointer scans to the last position on the line
			{
				line = input.readLine();  //Reads in a new line, updates the character pointer, increments the line number 
				charPos = 0;
				lineNum++;
			}
			else if ( ! isLetter(line.charAt(charPos)) )//We assume that the first character of a word must be a letter
				charPos++;
			else
				hasLetter = false;
		}
	}
	
	private boolean isLetter(char c) {
		return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
	}	
}