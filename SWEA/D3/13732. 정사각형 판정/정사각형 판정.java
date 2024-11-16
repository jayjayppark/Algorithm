import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        int N;
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            String[] board = new String[N];
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine();
            }
            
            int cnt = 0;
            boolean isSquare = true;
            boolean start = false;
            int row = 0;
            int col = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!start) {
                        if (board[i].charAt(j) == '#') {
                            start = true;
                            for (int k = j + 1; k < N; k++) {
                                if (board[i].charAt(k) == '#') {
                                    cnt++;
                                } else {
                                    break;
                                }
                            }
                            if (i + cnt >= N) {
                                isSquare = false;
                                break;
                            }
                            row = i;
                            col = j;
                            j += cnt;
                        }
                    } else {
                        if (i >= row && i <= row + cnt && j >= col && j <= col + cnt) {
                            if (board[i].charAt(j) == '.') {
                                isSquare = false;
                                break;
                            }
                        } else {
                            if (board[i].charAt(j) == '#') {
                                isSquare = false;
                                break;
                            }
                        }
                    }
                }
                if (!isSquare) {
                 	break;   
                }
            }
            if (isSquare) {
                sb.append('#').append(test_case).append(' ').append("yes").append('\n');
            } else {
                sb.append('#').append(test_case).append(' ').append("no").append('\n');
            }
		}
        System.out.print(sb.toString());
	}
}