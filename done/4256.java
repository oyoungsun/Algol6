import java.util.Scanner;


class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int[] preorder = new int[n];
            int[] inorder = new int[n];

            for (int i = 0; i < n; i++) {
                preorder[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                inorder[i] = sc.nextInt();
            }
            findPostOrder(0, 0, n - 1, n, preorder, inorder);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void findPostOrder(int rootIdx, int begin, int end, int n, int[] preorder, int[] inorder) {
        if (rootIdx >= n) {
            return;
        }
        int rootValue = preorder[rootIdx];

        for (int idx = begin; idx <= end; idx++) {
            if (rootValue == inorder[idx]) { //findIndex in inorder
                //start : root (inorder)
                findPostOrder(rootIdx + 1, begin, idx, n, preorder, inorder); //add left(begin~root)
                findPostOrder(rootIdx + idx + 1 - begin, idx + 1, end, n, preorder, inorder);
                //add right(root+1~end)
                sb.append(rootValue + " "); //finally, add root
                return;
            }
        }
    }


}