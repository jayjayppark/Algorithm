import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num <= 4) {
            System.out.print("YES");
            return;
        }

        List<ArrayDeque<Integer>> stacks = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            stacks.add(new ArrayDeque<>());
            stacks.get(i).push(0);
        }

        int stackNum;
        boolean isContinue;
        for (int i = 0; i < num; i++) {
            stackNum = scanner.nextInt();
            isContinue = false;
            for (ArrayDeque<Integer> stack : stacks) {
                if (stackNum > stack.peek()) {
                    stack.push(stackNum);
                    isContinue = true;
                    break;
                }
            }
            if (!isContinue) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}
