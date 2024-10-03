class Solution {
    public int[] solution(int[] numbers, String direction) {
        int size = numbers.length;
        int[] answer = new int[size];
        if (direction.equals("left")) {
            for (int i = 0; i < size - 1; i++) {
                answer[i] = numbers[i + 1];
            }
            answer[size - 1] = numbers[0];
        } else {
            for (int i = 1; i < size; i++) {
                answer[i] = numbers[i - 1];
            }
            answer[0] = numbers[size - 1];
        }
        return answer;
    }
}