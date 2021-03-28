package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        int []result = new int[2];
        boolean found = false;
        for(int i=0;i<list.length;i++){
            if(pairs.containsKey(list[i]))
            {
                result[0] = pairs.get(list[i]);
                result[1]= i;
                found = true;
                break;
            }
            else {
                pairs.put(sum - list[i], i);
            }
        }

        return found ?result: null;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
