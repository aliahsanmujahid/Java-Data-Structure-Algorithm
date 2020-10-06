
package wildcard.pattern;

public class WildcardPattern {

    private static void printAllCombinations(char pattern[], int i)
    {
      
        if (i == pattern.length)
        {
              System.out.println("i "+i+" "+pattern.length+" ");
            System.out.println(pattern);
            return;
        }
 
        // if the current character is '?'
        System.out.println("I = "+i+" "+pattern[i]+"-------");
        if(pattern[i]=='?'){
            System.out.println("=======");
        }
        if (pattern[i] == '?')
        {
            for (char ch = '0'; ch <= '1'; ch++)
            {
                // replace '?' with 0 and 1
                pattern[i] = ch;
                System.out.println("inloop i "+i+" "+"ch = "+ch+" "+pattern[i]);
                System.out.println("-----");
                       
                // recur for the remaining pattern
                printAllCombinations(pattern, i + 1);
 
                // backtrack as array is passed by reference to the function
                System.out.println("BackT i "+i+" "+"ch = "+ch+" "+pattern[i]);
                pattern[i] = '?';
            }
            return;
        }
 
        // if the current character is 0 or 1, ignore it and
        // recur for the remaining pattern
        printAllCombinations(pattern, i + 1);
    }
    
public static void main(String[] args)
    {
        char[] pattern = "1?11?00?1?".toCharArray();
        printAllCombinations(pattern, 0);
    }
}
