class Solution {
    public int solution(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                result = result * 10 + cur - '0';
            } else if (cur == 'z') {
                result = result * 10;
                i += 3;
            } else if (cur == 'o') {
                result = result * 10 + 1;
                i += 2;
            } else if (cur == 't') {
                if (s.substring(i, i + 3).equals("two")) {
                    result = result * 10 + 2;
                    i += 2;
                } else {
                    result = result * 10 + 3;
                    i += 4;
                }
            } else if (cur == 'f') {
                if (s.substring(i, i + 4).equals("four")) {
                    result = result * 10 + 4;
                    i += 3;
                } else {
                    result = result * 10 + 5;
                    i += 3;
                }
            } else if (cur == 's') {
                if (s.substring(i, i + 3).equals("six")) {
                    result = result * 10 + 6;
                    i += 2;
                } else {
                    result = result * 10 + 7;
                    i += 4;
                }
            } else if (cur == 'e') {
                result = result * 10 + 8;
                i += 4;
            } else {
                result = result * 10 + 9;
                i += 3;
            }
        }

        return result;
    }
}