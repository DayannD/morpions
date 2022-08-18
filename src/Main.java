import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String player1 = null;
        String player2 = null;
        Scanner scanner = new Scanner(System.in);
        Scorpion scorpion = new Scorpion();
        boolean itsWinner = false;
        boolean turn = true;

        while(player1 == null){
            try{
                System.out.println("Player 1, choississez votre signe X ou O");
                player1 = scanner.nextLine();
                if (!player1.equals("X") && !player1.equals("O")){
                    System.out.println("Vous avez choissis un mauvais signe, réessayer");
                    player1 = null;
                    continue;
                }
                if (player1.equals("X")){
                    player2 = "O";
                }else {
                    turn = false;
                    player2 = "X";
                }
            }catch (InputMismatchException ime){
                System.out.println("Vous avez rentrer une maivaise valeur, reessayer");
                player1 = null;
                scanner.nextLine();
            }
        }

        while(itsWinner == false){
            System.out.println(scorpion.toString());
            int val = 0;
            if (turn == true){
                try{
                    System.out.println("Player X à toi de jouer");
                    System.out.println("quelle case souhaiter vous changer dans les cases disponible ?");
                    val = scanner.nextInt();
                    if (val >= 10 || val <= 0){
                        System.out.println("la valeurs rentrer est erroné,réessayer");
                        continue;
                    }
                    itsWinner = scorpion.game("X",val);
                    turn = false;
                }catch (InputMismatchException ime){
                    System.out.println("\"la valeurs rentrer est erroné,réessayer\"");
                    scanner.nextLine();
                }
            }else {
                try{
                    System.out.println("Player O à toi de jouer");
                    System.out.println("quelle case souhaiter vous changer dans les cases disponible ?");
                    val = scanner.nextInt();
                    itsWinner = scorpion.game("O",val);
                    turn = true;
                    if (val >= 10 || val <= 0){
                        System.out.println("la valeurs rentrer est erroné,réessayer");
                        continue;
                    }
                }catch (InputMismatchException ime){
                    System.out.println("\"la valeurs rentrer est erroné,réessayer\"");
                    scanner.nextLine();
                }
            }
        }
    }
}
