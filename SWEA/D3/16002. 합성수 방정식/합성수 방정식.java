import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        Long N;
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Long.parseLong(br.readLine());
            if ((N & 1) == 1) {
                sb.append('#').append(test_case).append(' ').append(N + 9).append(' ').append(9).append('\n');
            } else {
                sb.append('#').append(test_case).append(' ').append(N + 4).append(' ').append(4).append('\n');
            }
		}
        System.out.print(sb.toString());
	}
}