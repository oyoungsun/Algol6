import java.util.*;
class Solution {
    static HashMap<String, String> users = new HashMap<>();

    public String[] solution(String[] record) {
        //파싱하기 & HashMap set : uid : name
        for(String rec : record){
            String [] temp = rec.split(" ");

            String command = temp[0];
            if(command.equals("Leave")){
                String id = temp[1];
                interpret(command, id, "");
                continue;
            }
            String id = temp[1];
            String name = temp[2];
            interpret(command, id, name);
        }
        List<String> result = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String [] temp = record[i].split(" ");
            String command = temp[0];
            if(command.equals("Leave")){
                String id = temp[1];
                result.add(users.get(id)+"님이 나갔습니다.");
                continue;
            }
            String id = temp[1];
            String name = temp[2];

            if(command.equals("Change")) continue;
            if(command.equals("Enter")) {
                result.add(users.get(id)+"님이 들어왔습니다.");
            }
        }
        String[] answer= new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);

        }
        return answer;

    }
    public void interpret(String command, String id, String name) {
        if(command.equals("Enter")){
            users.put(id, name);
        }
        else if(command.equals("Leave")) return;
        else{//change
            users.put(id, name);
        }
    }
}