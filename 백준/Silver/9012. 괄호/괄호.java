import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean noVPS;
        int temp;
        for (int i = 0; i < T; i++) {
            temp = 0;
            noVPS = true;
            String curStr = br.readLine();
            for (int j = 0; j < curStr.length(); j++) {
                if (curStr.charAt(j) == '(') {
                    temp++;
                } else {
                    if (temp == 0) {
                        sb.append("NO\n");
                        noVPS = false;
                        break;
                    } else {
                        temp--;
                    }
                }
            }
            if (noVPS) {
                if (temp != 0) {
                    sb.append("NO\n");
                } else {
                    sb.append("YES\n");
                }
            }

        }
        System.out.print(sb.toString());
    }
}