import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        if (arr.length == 1) {
            return arr;
        }

        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int a = arr[i];
            if (arrList.get(arrList.size() - 1) != a) {
                arrList.add(a);
            }
        }

        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}
