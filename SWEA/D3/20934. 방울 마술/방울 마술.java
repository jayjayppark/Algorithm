import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        String[] a;
        int first;
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            a = br.readLine().split(" ");
            first = a[0].indexOf('o');
            
            if (a[1].equals("0")) {
                sb.append('#').append(test_case).append(' ').append(first).append('\n');
            } else {
                if (first == 1) {
                    if ((Integer.parseInt(a[1]) & 1) == 1) {
                        sb.append('#').append(test_case).append(' ').append(0).append('\n');
                    } else {
                        sb.append('#').append(test_case).append(' ').append(1).append('\n');
                    }
                } else {
                    if ((Integer.parseInt(a[1]) & 1) == 1) {
                        sb.append('#').append(test_case).append(' ').append(1).append('\n');
                    } else {
                        sb.append('#').append(test_case).append(' ').append(0).append('\n');
                    }
                }
            }
		}
        System.out.print(sb.toString().trim());
	}
}