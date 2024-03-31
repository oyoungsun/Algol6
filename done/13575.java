import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] array = new int[n];
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            set.add(array[i]);
        }
        for(int i=1; i<k; i++){
            HashSet<Integer> set2 = new HashSet<>();
            for(int a : array){
                for(int s : set){
                    set2.add(a+s);
                }
            }
            set = set2;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int s : set){
            temp.add(s);
        }
        Collections.sort(temp);
        for (int t : temp) {
            System.out.print(t+" ");
        }
    }
}