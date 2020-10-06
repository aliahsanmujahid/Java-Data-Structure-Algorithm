
package naive.pattern.searching;

public class NaivePatternSearching {
public static void search(String txt, String pat) 
    { 
      int limit =  txt.length()-pat.length();
      
      for(int i=0;i<=limit;i++){
          int j;
          for( j=0;j<pat.length();j++){
              if(pat.charAt(j)!=txt.charAt(i+j)){
                  break;
              }
          }
          if(j==pat.length()){
              System.out.println("Patern found at "+i);
          }
      }
    } 
  
    public static void main(String[] args) 
    { 
        String txt = "THIS IS A TEST TEXT"; 
        String pat = "TEST"; 
        search(txt, pat); 
    } 
}
