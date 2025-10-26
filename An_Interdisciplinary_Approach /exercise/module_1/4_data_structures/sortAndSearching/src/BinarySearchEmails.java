import java.io.*;
import java.util.*;

public class BinarySearchEmails {

    public static void main(String[] args) throws FileNotFoundException {

    	 // Check for command-line argument
        if (args.length == 0) {
            System.out.println("Prompt: java BinarySearchEmails <allowlist file> < emails.txt>");
            return;
        }
    	
    	
//    	File allowListFile = new File("data/allowlist.txt"); reads from a file
       
     // Read allowlist file from args[0]
        File allowListFile = new File(args[0]); 
        
        
        // Read allowlist first (approved emails)
        Scanner allowScanner = new Scanner(allowListFile);
        ArrayList<String> allowList = new ArrayList<>();
        
        while (allowScanner.hasNext()) {
            allowList.add(allowScanner.next());
        }
        allowScanner.close();

        
        // Convert to array and sort the allowArray
        String[] allowArray = new String[allowList.size()];
        for (int i = 0; i < allowList.size(); i++) {
            allowArray[i] = allowList.get(i);
        }
        
        Arrays.sort(allowArray);
       
        
        // Read the emails to check
//        File emailFile = new File("data/emails.txt"); // it reads from file:
//        Scanner emailScanner = new Scanner(emailFile);
       

        //Read emails from standard input (emails.txt redirected with <)
        Scanner emailScanner = new Scanner(System.in); 
        ArrayList<String> emailList = new ArrayList<String>();
        while (emailScanner.hasNext()) {
            emailList.add(emailScanner.next());
        }
        emailScanner.close();

        // For each email in emails.txt, check if it’s NOT in allowlist
        for (String email : emailList) {
            if (search(email, allowArray) < 0) {
                System.out.println(email);
            }
        }
    }

    //----------------- Binary Search -------------------------
    private static int search(String key, String[] items) {
        return search(key, items, 0, items.length);
    }

    private static int search(String key, String[] items, int low, int high) {
        if (high <= low) return -1;
        int mid = low + (high - low) / 2;
        int cmp = items[mid].compareTo(key);
        if      (cmp > 0) return search(key, items, low, mid);
        else if (cmp < 0) return search(key, items, mid + 1, high);
        else              return mid;
    }
}



/*
 🧩 What "\\s+" Means:
Part	Meaning
\\	In a Java string literal, \ must be written twice — once for Java’s own escaping, and once for the regex engine. So "\\s" becomes \s in regex form.
\s	In regex, this means “any whitespace character” (space, tab, or newline).
+	Means “one or more occurrences.”

✅ Together:
"\\s+" means “one or more whitespace characters”.

💡 Example:
String s = "hello   world \n this is   Java";
String[] words = s.split("\\s+");
 ["hello", "world", "this", "is", "Java"]
 
 //Book Method: ---------------------------------------------------
 ///
    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }
    public static int search(String key, String[] a, int lo, int hi) {
        // possible key indices in [lo, hi)
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);
        if      (cmp > 0) return search(key, a, lo, mid);
        else if (cmp < 0) return search(key, a, mid+1, hi);
        else              return mid;
    }
    
	public static void main(String[] args) {
		
		In in = new In(args[0]);
        String s = in.readAll();
        String[] words = s.split("\\s+");
        System.err.println("Done reading words");

        // sort the words (if needed)
        Arrays.sort(words);
        System.err.println("Done sorting words");
        
        // prompt user to enter a word and check if it's there
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (search(key, words) < 0) StdOut.println(key);
        }
	}
 
 */
