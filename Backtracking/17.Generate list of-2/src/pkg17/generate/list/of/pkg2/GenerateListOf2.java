
package pkg17.generate.list.of.pkg2;
import java.util.*;
 
// A Trie node
class Trie
{
    // true when node is a leaf node
    boolean isLeaf;
 
    Map<Character, Trie> character = new HashMap<>();
 
    // Constructor
    Trie() {
        isLeaf = false;
    }
};
public class GenerateListOf2 {
  // M x N matrix
    private static int M, N;
 
    // Iterative function to insert a String into a Trie
    private static void insert(Trie root, String str)
    {
        // start from the root node
        Trie curr = root;
 
        for (char ch: str.toCharArray())
        {
            // create a new node if path doesn't exists
            if (!curr.character.containsKey(ch)) {
                curr.character.put(ch, new Trie());
            }
 
            // go to the next node
            curr = curr.character.get(ch);
        }
 
        curr.isLeaf = true;
    }
 
    // Below arrays details all 8 possible movements from a cell
    // (top, right, bottom, left and 4 diagonal moves)
    private static int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
    private static int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };
 
    // The function returns false if (x, y) is not valid matrix coordinates
    // or cell (x, y) is already processed or doesn't lead to the solution
    public static boolean isSafe(int x, int y, boolean[][] processed,
                                char[][] board, char ch)
    {
        return (x >= 0 && x < M) && (y >= 0 && y < N) &&
                !processed[x][y] && (board[x][y] == ch);
    }
 
    // A recursive function to search valid words present in a boggle using trie
    public static void searchBoggle(Trie root, char[][] board, int i, int j,
                    boolean[][] processed, String path, Set<String> result)
    {
        // if leaf node is encountered
        if (root.isLeaf) {
            // update result with the current word
            result.add(path);
        }
 
        // mark current cell as processed
        processed[i][j] = true;
 
        // traverse all children of the current Trie node
        for (Map.Entry<Character, Trie> it : root.character.entrySet())
        {
            // check for all 8 possible movements from current cell
            for (int k = 0; k < 8; k++)
            {
                // skip if cell is invalid or it is already processed
                // or doesn't lead to any path in the Trie
                if (isSafe(i + row[k], j + col[k], processed, board, it.getKey())) {
                    searchBoggle(it.getValue(), board, i + row[k], j + col[k],
                                        processed, path + it.getKey(), result);
                }
            }
        }
 
        // mark current cell as unprocessed
        processed[i][j] = false;
 
    }
 
    // Function to search for given set of words in a boggle
    public static void searchBoggle(char[][] board, List<String> words)
    {
        // insert all words into a trie
        Trie root = new Trie();
        for (String word: words) {
            insert(root, word);
        }
 
        // construct a set for storing the result
        Set<String> result = new HashSet<>();
 
        // construct a boolean matrix to store whether a cell is processed or not
        boolean[][] processed = new boolean[M][N];
 
        String s;
 
        // consider each character in the matrix
        for (int i = 0 ; i < M; i++)
        {
            for (int j = 0 ; j < N ; j++)
            {
                // current character
                char ch = board[i][j];
 
                // proceed only if current character is child of the Trie root node
                if (root.character.containsKey(ch)) {
                    s = Character.toString(ch);
                    searchBoggle(root.character.get(ch), board, i, j,
                                    processed, s, result);
                }
            }
        }
 
        // print each word in the result set
        for (String word: result) {
            System.out.println(word);
        }
    }
 
    public static void main(String[] args)
    {
        char[][] board = {
            {'M', 'S', 'E', 'F'},
            {'R', 'A', 'T', 'D'},
            {'L', 'O', 'N', 'E'},
            {'K', 'A', 'F', 'B'}
        };
 
        M = board.length;
        N = board[0].length;
 
        List<String> words = Arrays.asList("START", "NOTE", "SAND", "STONED");
        searchBoggle(board, words);
    }
}
