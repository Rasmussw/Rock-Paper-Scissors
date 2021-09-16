import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class main {

    

    public static void main(String[] args) {
        System.out.println("Which gamemode do want to play?");
        String [] gamemode = {"1. Singleplayer", "2. Multiplayer"};
        for (int i = 0; i < gamemode.length; i++) {
            System.out.println(gamemode[i]);
        }
        String rock = "rock";
        String paper = "paper";
        String scissor = "scissor";
        int user1Wins = 0;
        int user2Wins = 0;

        Scanner scanner = new Scanner(System.in);
        String gamemodeDecision = scanner.nextLine().toLowerCase(Locale.ROOT);
        if (gamemodeDecision.equals("multiplayer")){

            System.out.println("Choose a name for user 1");
            String username1 = scanner.nextLine();
            System.out.println("Choose a name for user 2");
            String username2 = scanner.nextLine();

            System.out.println("How many rounds would you like to play?");
            Scanner scanner1 = new Scanner(System.in);
            int numberOfRounds = scanner1.nextInt() + 1;

            for (int i = 1; i < numberOfRounds; i++) {
                System.out.println(username1 + " choose, rock, paper or scissor");
                String rockPaperOrScissorUser1 = scanner.nextLine().toLowerCase(Locale.ROOT);
                System.out.println(username2 + " choose, rock, paper or scissor");
                String rockPaperOrScissorUser2 = scanner.nextLine().toLowerCase(Locale.ROOT);

                if (rockPaperOrScissorUser1.equals(rockPaperOrScissorUser2)){
                    System.out.println("Round " + i + " is a draw" + "🤝");
                } else if (rockPaperOrScissorUser1.equals(rock) && rockPaperOrScissorUser2.equals(scissor)){
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(rock) && rockPaperOrScissorUser2.equals(paper)){
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + username2 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(scissor) && rockPaperOrScissorUser2.equals(rock)){
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + username2 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(scissor) && rockPaperOrScissorUser2.equals(paper)){
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(paper) && rockPaperOrScissorUser2.equals(rock)){
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(paper) && rockPaperOrScissorUser2.equals(scissor)){
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + username2 + "🎉");
                }
            }
            if (user1Wins == user2Wins){
                System.out.println("Its a draw🤝");
            } else if (user1Wins > user2Wins){
                System.out.println(username1 + " is the winner🏆");
            } else if (user2Wins > user1Wins){
                System.out.println(username2 + " is the winner🏆");
            }

        } else if (gamemodeDecision.equals("singleplayer")){
            System.out.println("Choose a name for user");
            String username1 = scanner.nextLine();

            //laver array med rock paper og scissor, så jeg kan vælge random index
            String[] options = {rock, paper, scissor};

            System.out.println("How many rounds would you like to play?");
            Scanner scanner1 = new Scanner(System.in);
            int numberOfRounds = scanner1.nextInt() + 1;

            for (int i = 1; i < numberOfRounds; i++) {

                Random random = new Random();
                String randomRockPaperOrScissor = options[random.nextInt(3)];
                System.out.println(username1 + " choose, rock, paper or scissor");
                String rockPaperOrScissorUser1 = scanner.nextLine().toLowerCase(Locale.ROOT);

                if (rockPaperOrScissorUser1.equals(randomRockPaperOrScissor)){
                    System.out.println("Round " + i + " is a draw" + "🤝");
                } else if (rockPaperOrScissorUser1.equals(rock) && randomRockPaperOrScissor.equals(scissor)){
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(rock) && randomRockPaperOrScissor.equals(paper)){
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + "the computer" + "🎉");
                } else if (rockPaperOrScissorUser1.equals(scissor) && randomRockPaperOrScissor.equals(rock)){
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + "the computer" + "🎉");
                } else if (rockPaperOrScissorUser1.equals(scissor) && randomRockPaperOrScissor.equals(paper)){
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(paper) && randomRockPaperOrScissor.equals(rock)){
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(paper) && randomRockPaperOrScissor.equals(scissor)){
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + "the computer" + "🎉");
                }
            }
            if (user1Wins == user2Wins){
                System.out.println("Its a draw🤝");
            } else if (user1Wins > user2Wins){
                System.out.println(username1 + " is the winner🏆");
            } else if (user2Wins > user1Wins){
                System.out.println("The computer" + " is the winner🏆");
            }
        }
    }
}
