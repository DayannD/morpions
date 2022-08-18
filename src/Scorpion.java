import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Scorpion {
    String[][] tabScore = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };

    List<List<String>> tabScoreList = new ArrayList<>();
    List<String> tabScoreList1 = Arrays.asList("1", "2", "3");
    List<String> tabScoreList2 = Arrays.asList("4", "5", "6");
    List<String> tabScoreList3 = Arrays.asList("7", "8", "9");


    public Scorpion(){
        this.tabScoreList.add(tabScoreList1);
        this.tabScoreList.add(tabScoreList2);
        this.tabScoreList.add(tabScoreList3);
    }

    public String[][] getTabScore() {
        return tabScore;
    }

    public void setTabScore(String[][] tabScore) {
        this.tabScore = tabScore;
    }

    public List<List<String>> getTabScoreList() {
        return tabScoreList;
    }

    public void setTabScoreList(List<List<String>> tabScoreList) {
        this.tabScoreList = tabScoreList;
    }

    public boolean game(String player, int val){
        // TODO: 18/08/2022 trouvé un moyen de le faire avec l'api stream
        /*tabScoreList.stream().filter(i -> i.get(0).equals(String.valueOf(val)) ||
                                          i.get(1).equals(String.valueOf(val)) ||
                                          i.get(2).equals(String.valueOf(val))).forEach(i -> i.set());*/

        int tour=0;
        for (List<String> list:
             tabScoreList) {
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals(String.valueOf(val))){
                    list.set(i,player);
                }
            }
        }
        return this.winner(player);
    }


    public boolean winner(String player){
        List<String> winner = Arrays.asList(player,player,player);
        if (tabScoreList1.equals(winner) || tabScoreList2.equals(winner) || tabScoreList3.equals(winner)){
            System.out.println("Player " + player + " à gagner");
            return true;
        } else if (tabScoreList.get(0).get(0) == player && tabScoreList.get(1).get(1) == player && tabScoreList.get(2).get(2) == player) {
            System.out.println("Player " + player + " à gagner");
            return true;
        }else if (tabScoreList.get(0).get(2) == player && tabScoreList.get(1).get(1) == player && tabScoreList.get(2).get(0) == player) {
            System.out.println("Player " + player + " à gagner");
            return true;
        }else if (tabScoreList.get(0).get(0) == player && tabScoreList.get(1).get(0) == player && tabScoreList.get(2).get(0) == player) {
            System.out.println("Player " + player + " à gagner");
            return true;
        }else if (tabScoreList.get(0).get(1) == player && tabScoreList.get(1).get(1) == player && tabScoreList.get(2).get(1) == player) {
            System.out.println("Player " + player + " à gagner");
            return true;
        }else if (tabScoreList.get(0).get(2) == player && tabScoreList.get(1).get(2) == player && tabScoreList.get(2).get(2) == player) {
            System.out.println("Player " + player + " à gagner");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Scorpion :" + "\n" +" |" + tabScoreList.get(0).get(0)+ "|" + tabScoreList.get(0).get(1) + "|" +tabScoreList.get(0).get(2) +"|"+
                "\n"+" |" + tabScoreList.get(1).get(0)+ "|" + tabScoreList.get(1).get(1) + "|" +tabScoreList.get(1).get(2) +"|"+
                "\n"+" |" + tabScoreList.get(2).get(0)+ "|" + tabScoreList.get(2).get(1) + "|" +tabScoreList.get(2).get(2) +"|";
    }

}
