import java.util.*;
class Main{
    static int n;
    static int resource;
    static ArrayList<node> graph[];
    static int items[];
    static int INF = Integer.MAX_VALUE;
    static int dist[][];
    public static void main(String[] args) {
        /*
        1<=cost<=15
        갈수있는 최대 자원 m O(v*m) 1500 * v= 15*15*100 = 10^4
        * */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        resource = sc.nextInt();
        int r = sc.nextInt();
        graph = new ArrayList[n+1];
        dist = new int[n+1][n+1];
        items = new int[n+1];
        for(int i=1; i<=n; i++) {
            items[i] = sc.nextInt();
            graph[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
            dist[i][i]=0;
        }

        for(int i=0; i<r; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph[v1].add(new node(v2, cost));
            graph[v2].add(new node(v1, cost));
        }
        int max=0;
        for(int i=1; i<n; i++) {
            max = Math.max(max, getItems(i));
        }
        System.out.println(max);
    }

    private static int getItems(int start) {
        //start와 그 외 노드간의 총 거리를 구한 dist배열을 만듦.
        //리소스와 비교해, 결과 반환
        //=> v1->v2와 v2->v1은 같으니 dist[][]으로 재활용

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));
        //dist 초기화
        while(!pq.isEmpty()){
            node now = pq.poll();
            //현 노드와 이어진 모든 노드 업데이트
            for(node neigh : graph[now.num]){
//                if(neigh.num<start) continue; 를 넣으면 안되나?
//                -> 그려본 결과, start의 neighbor아니면 update가 안됨
                if(dist[start][neigh.num] > dist[start][now.num]+neigh.cost){
                    dist[start][neigh.num] = dist[start][now.num]+neigh.cost;
                    pq.add(new node(neigh.num, dist[start][now.num]+neigh.cost));
                }
            }
        }
        //item세기
        //while이 끝나면 dist[start]는 최적의 값을 가지게 됨.
        int itemSum=0;
        for(int i=1; i<=n; i++){
//            if(dist[start][i] < dist[i][start]) dist[i][start] = dist[start][i];
//            이것도 하면 안된다. update가 안됨
            if(dist[start][i] <= resource) itemSum += items[i];
        }
        return itemSum;
    }
}

class node implements Comparable<node>{
    int num;
    int cost;
    public node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
    @Override
    public int compareTo(node o1){
        return this.cost - o1.cost;
    }
}