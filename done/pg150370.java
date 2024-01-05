import java.util.*;
import java.util.Collections;
class Solution {
    public static final int NOTHING = 4;

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        solution(survey, choices);
    }
    public static String solution(String[] survey, int[] choices) {
        //Hashset mbti 에 성격유형 두자리 저장하기
        //survey 알파벳 순 정렬 후 mbti 매칭
        //사전순 : 그대로 비사전순 : 사전순으로, choices는 (7-choice+1)로 변경
        //선택지에 따라 AN : int[2] A값, N값으로 매칭하기
        //choices 누적
        //누적후 집계, 출력하기
        HashMap<String, int[]> mbti = new HashMap<>();
        mbti.put("RT", new int[]{0,0});
        mbti.put("CF", new int[]{0,0});
        mbti.put("JM", new int[]{0,0});
        mbti.put("AN", new int[]{0,0});
        int i=0;
        for(String temp : survey){
            char[] surv = temp.toCharArray();
            if(surv[0]<surv[1]){//정렬 완료
                int[] values = mbti.get(temp);
                accumulate(values, choices[i]);
                mbti.put(temp, values);
            }else{ // 정렬 필요 
                StringBuffer sb = new StringBuffer(temp);
                temp = sb.reverse().toString();
                int[] values = mbti.get(temp);
                accumulate(values, choices[i]);
                mbti.put(temp, values);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(summary(mbti, "RT"));
        sb.append(summary(mbti, "CF"));
        sb.append(summary(mbti, "JM"));
        sb.append(summary(mbti, "AN"));

        return sb.toString();
    }

    public static Character summary(HashMap<String, int[]> mbti, String temp) {
        int values[] = mbti.get(temp);
         if(values[0]>values[1]) return temp.charAt(0);
         else return temp.charAt(1);
    }
    public static void accumulate(int [] values, int choice) {
        if(choice < NOTHING){
            values[0] += NOTHING - choice;
        }else{
            values[1] += choice-NOTHING;
        }
    }

}