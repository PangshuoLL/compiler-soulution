package scanner;

import java.util.*;

/**
 * A class for the WordCount data structure.
 * A WordCount object is a map which pairs a word (string)
 * with a list of information (Info)
 */
//Generate information list for each word and count the frequency
public class WordCount {

	//Build a map container for word and information list
	private Map<String,List<Info>> wordTable;
	
	/**
	 * Builds an empty WordCount
	 */
	public WordCount() 
	{
		//Using treemap or HashMap
		wordTable = new TreeMap<String,List<Info>>();
	}
	
	/**
	 * Adds the given 'info' in the list of
	 * Infos of the given word 'word'
	 */
	
	public void add(String word, Info info)
	{
		//According to the parameters, first get the info list of the specified word
		List<Info> list = wordTable.get(word);
		if ( list == null ) 
		{
			//New a new list object that writes the empty list to the key value of word
			list = new LinkedList<Info>();
			wordTable.put(word, list);
		}
		//Point info to the list of word
		list.add(info);
	}
	
	/**
	 * Returns an iterator over the informations of
	 * the given word 'word'. If 'word' has no information
	 * returns null
	 */
	//Iterator that gets the information table of the specified word
	public Iterator<Info> getListIterator(String word)
	{
		List<Info> list = wordTable.get(word);
		if ( list == null )
			return null;
		return list.iterator();
	}
	
	/**
	 * Displays the WordCount on System.out
	 */
	public void display() 
	{
		//Iterate all the words
		for ( String word : wordTable.keySet() ) 
		{
			//Gets the information table of the specified word
			List<Info> list = wordTable.get(word);
			System.out.print(word + " " + "(" + list.size() + "): ");
			
			for ( Info info : list ) 
			{
				System.out.print(info + " ");
			}
			System.out.println();
		}
	}
}