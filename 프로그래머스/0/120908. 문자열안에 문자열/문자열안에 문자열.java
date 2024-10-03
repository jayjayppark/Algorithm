class Solution {
    public int solution(String str1, String str2) {
        boolean isSame;
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                isSame = true;
                for (int j = 1; j < str2.length(); j++) {
                    if (str1.charAt(i + j) != str2.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame == true) {
                    return 1;
                }
            }
        }
        return 2;
    }
}