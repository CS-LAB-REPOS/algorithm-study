public class Main {
    public static String[] dfs(String[][] tickets, String[] answer, int index, String from) {
        if (index == answer.length) {
            return answer;
        }

        String to = "ZZZ";
        int rememberIndex = -1;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && from == tickets[i][0]) {
                if (tickets[i][1].compareTo(to) < 0) {// tickets[i][1] < to => return -1
                    to = tickets[i][1];
                    rememberIndex = i;
                }
            }
        }

        answer[index] = to;
        tickets[rememberIndex] = null;
        dfs(tickets, answer, index + 1, to);

        return answer;
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        answer[0]="ICN";
        dfs(tickets, answer, 1, "ICN");

        return answer;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String answers[] = solution(tickets);
        for(String str : answers){
            System.out.println(str);
        }
    }
}