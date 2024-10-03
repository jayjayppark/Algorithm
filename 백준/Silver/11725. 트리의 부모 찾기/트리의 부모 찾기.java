import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] al = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            al[node1].add(node2);
            al[node2].add(node1);
        }

        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        parent[0] = -2;

        ArrayDeque<Integer> aq = new ArrayDeque<>();
        for (int k : al[0]) {
            parent[k] = 1;
            aq.offer(k);
        }

        while (!aq.isEmpty()) {
            int p = aq.poll();
            for (int k : al[p]) {
                if (parent[k] == -1) {
                    parent[k] = p + 1;
                    aq.offer(k);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb.toString());


    }
}