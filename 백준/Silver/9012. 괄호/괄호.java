import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] arg) throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> ad = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean noVPS;
        for (int i = 0; i < T; i++) {
            noVPS = true;
            String curStr = br.readLine();
            for (int j = 0; j < curStr.length(); j++) {
                char cur = curStr.charAt(j);
                if (cur == '(') {
                    ad.push(cur);
                } else {
                    if (ad.isEmpty()) {
                        sb.append("NO\n");
                        noVPS = false;
                        break;
                    } else {
                        if (ad.peek() == ')') {
                            sb.append("NO\n");
                            noVPS = false;
                            break;
                        } else {
                            ad.pop();
                        }
                    }
                }
            }
            if (noVPS) {
                if (ad.isEmpty()) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
            ad.clear();
        }
        System.out.print(sb.toString());
    }
}