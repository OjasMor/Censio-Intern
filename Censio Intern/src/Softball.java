import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Softball questions.
 */
public class Softball {
	
	/**
	 * The main method for testing.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String test = "I think one of the hardest things in the world for people to do is to love themselves.  "
				    + " If you loved yourself you would take"
				    + " better care of yourself, and respect the things around you because you respect yourself."
				    + " Even the condition of your home whether clean or dirty can reveal how much you love yourself."
				    + " Just don't expect someone else to give what you neglect to give yourself which is love. "
				    + " That's why relationships don't work out so well most times.";
				    
        System.out.println(MostPopularWord(test));
        
        System.out.println(reverseString("Hello"));
        System.out.println(reverseString("I"));
        System.out.println(reverseString("am"));
        System.out.println(reverseString("Ojas, and you are?"));
        
        System.out.println(longestWord(test));
	}
	
	/**
	 * Find the most popular word.
	 *
	 * @param paragraph the paragraph to check.
	 * @return the most popular word
	 */
	public static String MostPopularWord(String paragraph) {
		String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ");
		String[] words = normalizedStr.split("\\s++");
		
		Map<String, Integer> countWord = new HashMap<>();
		for (String word : words) {
			countWord.put(word, countWord.getOrDefault(word, 0) + 1);
		}
		
		return Collections.max(countWord.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
	
	/**
	 * Reverse a string.
	 *
	 * @param s the string to reverse
	 * @return the reversed string
	 */
	public static String reverseString(String s) {
		String answer = "";
		char[] StringToChar = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) {
			answer = answer + (StringToChar[i]);
		}
		return answer;
	}
	
	/**
	 * The sum 10 question mark problem
	 *
	 * @param s the string to check rules against.
	 * @return a string containing "true" or "false"
	 */
	public static String sum10(String s) {
		int firstNum = 0;
		int secondNum = 0; 
		int Qcount = 0;
		int numTens = 0;
        char[] chars = s.replaceAll("[^?0-9]","").toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c) && firstNum == 0) {
            	firstNum = (int)(c-'0');
            } else if (c == '?' && firstNum != 0) {
            	Qcount++;
            } else if (Character.isDigit(c) && firstNum != 0) {
                secondNum = (int)(c-'0');
                if (firstNum + secondNum == 10) {
                    if (Qcount != 3) {
                    	return "false";
                    }
                    numTens++;
                    firstNum = 0;
                    secondNum = 0;
                    Qcount = 0;
                }
            }
        }
        if (numTens > 0) {
        	return "true";
        }
        return "false";
   
	}
	
	/**
	 * Longest word.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String longestWord(String s) {
		String normalizedStr = s.replaceAll("[^a-zA-Z0-9 ]", " ");
		String[] words = normalizedStr.split("\\s++");
		
		int length = 0;
		String word = "";
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > length) {
				length = words[i].length();
				word = words[i];
			}
		}
		return word;
	}
}




















