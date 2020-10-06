
package bracket.balancing;

public class BracketBalancing {
 static long swapCount(String s)  
    { 
      char [] chars =s.toCharArray();
      int countLeft = 0,countRight = 0;
      
      int swap = 0,imbalanced = 0;
      
      for(int i=0;i<chars.length;i++){
          if(chars[i]=='['){
              countLeft++;
              if(imbalanced>0){
                 swap = swap+imbalanced;
                 imbalanced--;
              }
          }else if(chars[i]==']'){
             countRight++;  
             imbalanced = (countRight-countLeft);  
          }
      }
      return swap; 
    } 
  
    public static void main(String[] args) {
       String s = "[]][]["; 
        System.out.println(swapCount(s) ); 
  
        s = "[[][]]"; 
        System.out.println(swapCount(s) ); 
    }
    
}
