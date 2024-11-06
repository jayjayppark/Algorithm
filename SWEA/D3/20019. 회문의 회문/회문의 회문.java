import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();

        String curString;
        int size;
        int half;
        int quarter;
        StringBuilder sb = new StringBuilder();
        boolean isPalindrome;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            curString = sc.nextLine();
            size = curString.length();
            if ((size & 1) == 0) {
                sb.append('#').append(test_case).append(' ').append("NO").append('\n');
                continue;
            }
            
            half = size / 2;
            isPalindrome = true;
            for (int i = 0; i < half; i++) {
                if (curString.charAt(i) != curString.charAt(size - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome) {
                sb.append('#').append(test_case).append(' ').append("NO").append('\n');
                continue;
            }
            
            quarter = half / 2;
            for (int i = 0; i < quarter; i++) {
                if (curString.charAt(i) != curString.charAt(half - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            
            if (!isPalindrome) {
                sb.append('#').append(test_case).append(' ').append("NO").append('\n');
                continue;
            }
            
            for (int i = 0; i < quarter; i++) {
                if (curString.charAt(half + 1 + i) != curString.charAt(size - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            
            if (!isPalindrome) {
                sb.append('#').append(test_case).append(' ').append("NO").append('\n');
                continue;
            }
            
            sb.append('#').append(test_case).append(' ').append("YES").append('\n');
		}
        System.out.print(sb.toString());
	}
}