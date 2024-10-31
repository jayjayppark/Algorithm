import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringBuilder arr = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> hm = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                hm.put(Integer.parseInt(st.nextToken()), i);
            }

            int cnt = 0;
            int empty = N + 1;

            arr.setLength(0);
            
            while (true) {
                boolean isEnd = true;
                int a = 0;
                int b = 0;

                for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                    a = entry.getKey();
                    b = entry.getValue();
                    if (a != b) {
                        isEnd = false;
                        break;
                    }
                }

                if (isEnd) {
                    sb.append(cnt).append('\n').append(arr.toString().trim()).append('\n');
                    break;
                }

                hm.put(a, empty);
                empty = b;
                cnt++;
                arr.append(b).append(' ');

                while (empty != N + 1) {
                    b = hm.get(empty);
                    hm.put(empty, empty);
                    empty = b;
                    cnt++;
                    arr.append(b).append(' ');
                }
            }
        }
        System.out.print(sb.toString().trim());
    }
}
