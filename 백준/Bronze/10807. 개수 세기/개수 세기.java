import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] splitNums = br.readLine().split(" ");
        String v = br.readLine();
        int solution = 0;
        for (int i = 0; i < N; i++) {
            if (v.equals(splitNums[i])) {
                solution++;
            }
        }
        System.out.print(solution);
    }

}