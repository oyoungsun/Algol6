import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    //그래프, 배열에서 임의의 순서만 주어짐.
    // 정렬 -> 랜덤 요소x와 랜덤 요소y는 비교가능
    // 그래프 탐색 ->
    // 랜덤 요소x와 랜덤 요소y는 비교정보가 없을 수 있다.(직접 탐색하며 알게됨)
    // 특히, 답이 여러개일 수 있다.
    //위상 정렬은 위에서 아래로 찾아야한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); //정보의 수
        ArrayList<Integer> pre[] = new ArrayList[n+1];
        int[] in = new int[n+1];
        //자기 앞에 있을 수 있는 정보를 저장하고,
        // 자기 앞에 아무것도 없는 애를 root로 정함(Stack으로 자식 노드 빼기)
        // 부모를 stack에 넣고 마지막에 reverse?
        for(int i=0; i<=n; i++) pre[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            int p = sc.nextInt();
            int c = sc.nextInt();
            pre[p].add(c); //(in)
            in[c]+=1; //자식이 1개이상(out)
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(in[i]==0) {
                q.add(i); //out==0
                visit[i]=true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int child : pre[now]) {
                in[child]--; //부모 제거
                if(in[child]==0)
                    q.add(child);
            }
        }
        System.out.print(sb);
    }
}