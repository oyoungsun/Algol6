import java.util.*;
class Solution {
    static HashMap<String, Integer> term;
    static long todayDays;
    public int[] solution(String today, String[] terms, String[] privacies) {
        //terms 매칭&find함수 만들기
        setting(terms, today);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            long compared = accumulate(privacy[0], findType(privacy[1]));
            boolean isTrash = compare(compared);
            if(isTrash) result.add(i+1);
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public long accumulate(String prevDay, int month) {
        String prev[] = prevDay.split("\\.");
        long days = Integer.parseInt(prev[0]) * 28 * 12; //12개월 * 28일
        days += (Integer.parseInt(prev[1])+month) * 28; //28일
        days += Integer.parseInt(prev[2]); //28일
        return days;
    }
    public void setting(String[] terms, String today) {
        term = new HashMap<String, Integer>();
        for(String t : terms){
            String temp[] = t.split(" ");
            term.put(temp[0], Integer.parseInt(temp[1]));
        }

        String prev[] = today.split("\\.");
        todayDays = Integer.parseInt(prev[0]) * 28 * 12; //12개월 * 28일
        todayDays += Integer.parseInt(prev[1])* 28; //28일
        todayDays += Integer.parseInt(prev[2]); //28일
    }
    public int findType(String month) {
        return term.get(month);
    }
    public boolean compare(long compared) {

        if(compared>todayDays) return false;
        else return true;
    }

}