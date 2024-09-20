import java.util.LinkedList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        LinkedList<Integer> ll = new LinkedList<>();
        boolean isAdd;
        for (int a : arr) {
            if (a % divisor == 0) {
                isAdd = true;
                for (int i = 0; i < ll.size(); i++) {
                    if (a <= ll.get(i)) {
                        ll.add(i, a);
                        isAdd = false;
                        break;
                    }
                }
                if (isAdd) {
                    ll.add(a);
                }
            }
        }

        if (ll.isEmpty()) {
            return new int[] {-1};
        } else {
            return ll.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}