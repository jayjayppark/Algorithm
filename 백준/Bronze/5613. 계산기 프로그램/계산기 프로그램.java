import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp;
        tmp = Integer.parseInt(br.readLine());
        char cur = br.readLine().charAt(0);
        while (cur != '=') {
            if (cur == '+') {
                tmp += Integer.parseInt(br.readLine());
            } else if (cur == '-') {
                tmp -= Integer.parseInt(br.readLine());
            } else if (cur == '*') {
                tmp *= Integer.parseInt(br.readLine());
            } else if (cur == '/') {
                tmp /= Integer.parseInt(br.readLine());
            }
            cur = br.readLine().charAt(0);
        }
        System.out.print(tmp);
        br.close();
    }
}