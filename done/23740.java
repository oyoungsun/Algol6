import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class node implements Comparable<node>{
    int s;
    int e;
    int cost;
    public node(int s,int e,int cost){
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(node o) {
        return this.s - o.s;
    }
}
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<node> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new node(s,e,cost));
        }
        Collections.sort(graph);
        ArrayList<int[]> lines = new ArrayList<>();
        int s = graph.get(0).s;
        int e = graph.get(0).e;
        int cost =graph.get(0).cost;
        for(int i=0; i<n; i++){
            node temp = graph.get(i);
            if(e < temp.s) {
                //겹치지 않는 경우
                lines.add(new int[]{s,e,cost});
                s = temp.s;
                e = temp.e;
                cost = temp.cost; //초기화
                continue;
            }
            e = Math.max(temp.e, e);
            cost = Math.min(cost,temp.cost);
        }
        lines.add(new int[]{s,e,cost});

        StringBuilder sb = new StringBuilder();
        sb.append(lines.size()).append('\n');
        for(int[] line : lines){
            sb.append(line[0]+" "+line[1]+" "+line[2]+"\n");
        }
        System.out.print(sb);
    }
}