import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        st = new StringTokenizer(br.readLine(), " ");

        int next;
        int targetIndex;
        for (int i = 0; i < M; i++) {
            next = Integer.parseInt(st.nextToken());
            targetIndex = deque.indexOf(next);
            if (targetIndex + 1 <= (deque.size() / 2) + 1) {
                for (int j = 0; j < targetIndex; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.print(count);
    }
}
