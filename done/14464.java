import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class cow implements Comparable<cow>{
    int a;
    int b;
    List<Integer> coco;
    public cow(int a, int b){
        coco = new ArrayList<>();
        this.a=a;
        this.b=b;
    }

    @Override
    public int compareTo(final cow o) {
        return this.coco.size() - o.coco.size();
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int clist[] = new int[c];
        for (int i = 0; i < c; i++) {
            clist[i] = sc.nextInt();
        }
        int nlist[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            nlist[i][0] = sc.nextInt();
            nlist[i][1] = sc.nextInt();
        }
        Arrays.sort(clist);
        Arrays.sort(nlist, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        //정렬 후 , greedy
        int result = greedy(clist, nlist);
        System.out.println(result);
    }

    private static int greedy(final int[] clist, final int[][] nlist) {
        //소의 start와 clist비교해서, 가능한 것부터 쌓기
        int cnt=0;
        PriorityQueue<cow> pq = new PriorityQueue();
        for(int [] w : nlist){
            cow now = new cow(w[0], w[1]);
            int cidx = binaryS(clist, now.a);
            while(cidx<clist.length && w[0] <=clist[cidx] && clist[cidx]<= w[1]) {
                now.coco.add(cidx);
                cidx++;
            }
            pq.add(now);
        }
        boolean visit[] = new boolean[clist.length];
        while(!pq.isEmpty()){
            cow now = pq.poll();
            //건널 수 있다
            for(int i : now.coco){
                if(!visit[i]){//건널수있다 -> 사용한다
                    cnt++;
                    visit[i]=true;
                    break;
                }
            }
        }
        return cnt;
    }

    private static int binaryS(final int[] clist, final int a) {
        //이진탐색으로, start a같거나 바로 다음 큰 숫자 찾기
        int start=0;
        int end = clist.length -1;
        while(start<=end){
            int mid = (start+end) / 2;
            if(clist[mid]>a){
                end = mid-1;
            }else if(clist[mid]<a){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return start;
    }
}