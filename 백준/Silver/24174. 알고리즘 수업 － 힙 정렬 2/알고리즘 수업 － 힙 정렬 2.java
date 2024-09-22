import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static int changeCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        heap_sort(A, K);
        if (Main.changeCount < K) {
            System.out.print(-1);
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < A.length - 1; i++) {
                sb.append(A[i]).append(" ");
            }
            sb.append(A[A.length - 1]);
            System.out.print(sb);
        }
    }

    public static void heap_sort(int[] A, int K) {
        if (!build_min_heap(A, A.length - 1, K)) {
            return;
        }
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] != A[1]) {
                int temp = A[i];
                A[i] = A[1];
                A[1] = temp;
                Main.changeCount++;
                if (Main.changeCount == K) {
                    return;
                }
                if (!heapify(A, 1, i - 1, K)) {
                    return;
                }
            }
        }
    }

    public static boolean build_min_heap(int[] A, int n, int K) {
        for (int i = n / 2; i >= 1; i--) {
            if (!heapify(A, i, n, K)) {
                return false;
            }
        }
        return true;
    }

    public static boolean heapify(int[] A, int k, int n, int K) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller;
        if (right <= n) {
            if (A[left] < A[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return true;
        }

        if (A[smaller] < A[k]) {
            int temp = A[k];
            A[k] = A[smaller];
            A[smaller] = temp;
            if (++Main.changeCount == K) {
                return false;
            }
            return heapify(A, smaller, n, K);
        }
        return true;
    }
}