class Solution {
    public int solution(String str1, String str2) {
        return KMPAlgorithm.KMPSearch(str2, str1);
    }
    
    
}

class KMPAlgorithm {
    public static int KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        
        int[] lps = new int[m];
        computeLPSArray(pat, m, lps);
        
        int i = 0;
        int j = 0;
        
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) {
                return 1;
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return 2;
    }
    
    public static void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}