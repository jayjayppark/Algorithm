import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] splitNums = br.readLine().split(" ");
        String v = br.readLine();
        int solution = 0;
        for (String cur : splitNums) {
            if (cur.equals(v)) {
                solution++;
            }
        }
        System.out.print(solution);
    }

}