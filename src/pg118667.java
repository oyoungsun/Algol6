class Solution {
    public int solution(int[] queue1, int[] queue2) {
        //투포인터
        long sum1=0, sum2=0;
        int [] largeQ = new int[queue1.length*2];
        //setting
        for(int i=0; i<queue1.length; i++){
            largeQ[i] = queue1[i];
            largeQ[i+queue1.length] = queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        //sum1<sum2 : q2에서 하나 빼서q1에 더하기
        //sum1==sum2 : return;
        //sum1>sum2  : q1에서 하나 뺴서 q2에 더하기
        int right = queue1.length;
        int left = 0;
        int cnt=0;
        while(left<right){
            right = (right % (queue1.length*2));
            left = (left % (queue1.length*2));
            if(sum1>sum2) {
                sum1 -= largeQ[left];
                sum2 += largeQ[left];
                left++;
                cnt++;
            }
            else if(sum1<sum2) {
                sum1 += largeQ[right];
                sum2 -= largeQ[right];
                right++;
                cnt++;
            }
            else {
                break;
            }
        }
        if(sum1!=sum2) return -1;
        return cnt;
    }
}