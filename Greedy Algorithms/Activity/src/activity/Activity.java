
package activity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pair
{
    private int start, finish;
 
    public Pair(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
 
    public int getFinish() {
        return finish;
    }
 
    public int getStart() {
        return start;
    }
 
    @Override
    public String toString() {
        return "{" + getStart() + ", " + getFinish() + "}";
    }
};
public class Activity {
public static Set<Integer> selectActivity(List<Pair> activities)
    {
        // k keeps track of the index of the last selected activity
        int k = 0;
 
        // set to store the selected activities index
        Set<Integer> out = new HashSet<>();
 
        // select 0 as first activity
        out.add(0);
       // System.out.println(activities.get(0).getFinish()+" "+activities.get(0).getFinish());
           
           
           
        // start iterating from the second element of
        // vector up to its last element
        for (int i = 1; i < activities.size(); i++)
        {
            // if start time of i'th activity is is greater or equal
            // to the finish time of the last selected activity, it
            // can be included in activities list
            if (activities.get(i).getStart() >= activities.get(k).getFinish())
            {
                   //   System.out.println(activities.get(0).getStart()+" "+activities.get(0).getFinish());
                out.add(i);
                k = i;    // update i as last selected activity
            }
        }
 
        return out;
    }
    public static void main(String[] args) {
  List<Pair> activities = Arrays.asList(new Pair(1, 4), new Pair(3, 5),
                new Pair(0, 6), new Pair(5, 7), new Pair(3, 8),
                new Pair(5, 9), new Pair(6, 10), new Pair(8, 11),
                new Pair(8, 12), new Pair(2, 13), new Pair(12, 14));
 
        // Sort the activities according to their finishing time
        Collections.sort(activities,new Sortbyroll());
 
        Set<Integer> res = selectActivity(activities);
 
        for (Integer i: res) {
            System.out.println(activities.get(i));
        }
}
}
class Sortbyroll implements Comparator<Pair> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Pair a, Pair b) 
    { 
        return a.getFinish() -b.getFinish(); 
    } 
} 