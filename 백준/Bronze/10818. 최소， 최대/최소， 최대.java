import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int a;
        int max = -1000001;
        int min = 1000001;
        for (int i = 0; i < N; i++) {
            a = Integer.parseInt(st.nextToken());
            min = a < min ? a : min;
            max = a > max ? a : max;
        }
        System.out.printf("%d %d", min, max);
    }
}
