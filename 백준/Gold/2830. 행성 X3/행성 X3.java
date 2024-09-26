import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
public class Main {
    public static void Combination(int[] arr, int n, int r, int start, int depth, int[] temp, ArrayList<int[]> al) {
        if (depth == r) {
            al.add(temp.clone());
            return;
        }

        for (int i = start; i <= n - r + depth; i++) {
            temp[depth] = arr[i];
            Combination(arr, n, r, i + 1, depth + 1, temp, al);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] one = new int[20];
        int cur;
        int index;
        for (int i = 0; i < N; i++) {
            cur = Integer.parseInt(br.readLine());
            index = 0;
            while (cur != 0) {
                one[index] += cur & 1;
                cur >>= 1;
                index++;
            }
        }
        long answer = 0;
        int tmp;
        for (int i = 0; i < one.length; i++) {
            tmp = one[i];
            answer += (1L << i) * tmp * (N - tmp);
        }
        System.out.print(answer);
    }
}