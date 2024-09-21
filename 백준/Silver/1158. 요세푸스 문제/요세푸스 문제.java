import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            ll.add(i);
        }
        int size = N;
        LinkedList<Integer> solution = new LinkedList<>();
        int temp = 0;
        while (!ll.isEmpty()) {
            temp = (temp + K - 1) % size;
            solution.add(ll.remove(temp));
            size -= 1;
        }

        System.out.print(solution.stream().map(String::valueOf).collect(Collectors.joining(", ", "<", ">")));
    }
}