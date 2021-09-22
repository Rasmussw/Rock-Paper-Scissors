import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class main {

    //metode til at uskrive array
    public static String gamemode(String[] gamemodes){
        String gamemode = null;
        for (int i = 0; i < gamemodes.length; i++) {
            gamemode = gamemodes[i];
            System.out.println(gamemode);
        }
        return gamemode;
    }

    public static String userStringInputValidation(String failMessage){
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        boolean isChoiseValid = false;
        while (!isChoiseValid) {
            userInput = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (userInput.equals("rock") || userInput.equals("paper")
                    || userInput.equals("scissor")){
                isChoiseValid = true;
            } else {
                System.out.println(failMessage);
            }
        }
        return userInput;
    }

    public static String gamemodeInputValidation(){
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        boolean isChoiseValid = false;
        while (!isChoiseValid) {
        userInput = scanner.nextLine().toLowerCase(Locale.ROOT);
        if (userInput.equals("multiplayer") || userInput.equals("singleplayer")){
            isChoiseValid = true;
        } else {
            System.out.println("You have to type in multiplayer or singleplayer!!");
        }
        }
        return userInput;
    }


    public static int userRoundsInputValidation(){
        int numberOfRounds = 0;
        boolean isInputValid = false;
        while (!isInputValid) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("How many rounds would you like to play?");
                numberOfRounds = scanner.nextInt() + 1;
                if (numberOfRounds > 1){
                    isInputValid = true;
                } else {
                    System.out.println("You have to type in a positive number!!");
                }
            } catch (Exception e) {
                System.out.println("You have to type in a number!!");
            }
        }
        return numberOfRounds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String gamemodeMessage = "Which gamemode do want to play?";
        System.out.println(gamemodeMessage);

        String[] gamemodes = {"1. Singleplayer", "2. Multiplayer"};

        gamemode(gamemodes);

        String rock = "rock";
        String paper = "paper";
        String scissor = "scissor";

        //bruges til optælling af sejre
        int user1Wins = 0;
        int user2Wins = 0;

        String gamemodeDecision = gamemodeInputValidation();

        if (gamemodeDecision.equals("multiplayer")) {

            System.out.println("Choose a name for user 1");
            String username1 = scanner.nextLine();

            System.out.println("Choose a name for user 2");
            String username2 = scanner.nextLine();

            int numberOfRounds = userRoundsInputValidation();

            String failMessage = "Invalid choise, you have to type rock, paper or scissor!!";

            //for loop så det bliver spillet de runder der bliver bedt om
            for (int i = 1; i < numberOfRounds; i++) {

                System.out.println(username1 + " choose, rock, paper or scissor");
                String rockPaperOrScissorUser1 = userStringInputValidation(failMessage);

                System.out.println(username2 + " choose, rock, paper or scissor");
                String rockPaperOrScissorUser2 = userStringInputValidation(failMessage);

                if (rockPaperOrScissorUser1.equals(rockPaperOrScissorUser2)) {
                    System.out.println("Round " + i + " is a draw" + "🤝");
                } else if (rockPaperOrScissorUser1.equals(rock) && rockPaperOrScissorUser2.equals(scissor)) {
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(rock) && rockPaperOrScissorUser2.equals(paper)) {
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + username2 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(scissor) && rockPaperOrScissorUser2.equals(rock)) {
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + username2 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(scissor) && rockPaperOrScissorUser2.equals(paper)) {
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(paper) && rockPaperOrScissorUser2.equals(rock)) {
                    user1Wins += 1;
                    System.out.println("Round " + i + " goes to " + username1 + "🎉");
                } else if (rockPaperOrScissorUser1.equals(paper) && rockPaperOrScissorUser2.equals(scissor)) {
                    user2Wins += 1;
                    System.out.println("Round " + i + " goes to " + username2 + "🎉");
                }
            }
            //vinderen bliver fundet
            if (user1Wins == user2Wins) {
                System.out.println("Its a draw🤝");
            } else if (user1Wins > user2Wins) {
                System.out.println(username1 + " is the winner🏆");
            } else if (user2Wins > user1Wins) {
                System.out.println(username2 + " is the winner🏆");
            }

            } else if (gamemodeDecision.equals("singleplayer")) {
                System.out.println("Choose a name for user");
                String username1 = scanner.nextLine();

                //laver array med rock paper og scissor, så jeg kan vælge random index
                String[] options = {rock, paper, scissor};

                //Hvor mange runder der skal spilles
                int numberOfRounds = userRoundsInputValidation();

                String failMessage = "Invalid choise, you have to type rock, paper or scissor!!";

                //Et forloop så der bliver spillet de runder der bliver bedt om
                for (int i = 1; i < numberOfRounds; i++) {
                    Random random = new Random();
                    String randomRockPaperOrScissor = options[random.nextInt(3)];

                    System.out.println(username1 + " choose, rock, paper or scissor");

                    String rockPaperOrScissorUser1 = userStringInputValidation(failMessage);

                    if (rockPaperOrScissorUser1.equals(randomRockPaperOrScissor)) {
                        System.out.println("Round " + i + " is a draw" + "🤝");
                    } else if (rockPaperOrScissorUser1.equals(rock) && randomRockPaperOrScissor.equals(scissor)) {
                        user1Wins += 1;
                        System.out.println("Round " + i + " goes to " + username1 + "🎉");
                    } else if (rockPaperOrScissorUser1.equals(rock) && randomRockPaperOrScissor.equals(paper)) {
                        user2Wins += 1;
                        System.out.println("Round " + i + " goes to " + "the computer" + "🎉");
                    } else if (rockPaperOrScissorUser1.equals(scissor) && randomRockPaperOrScissor.equals(rock)) {
                        user2Wins += 1;
                        System.out.println("Round " + i + " goes to " + "the computer" + "🎉");
                    } else if (rockPaperOrScissorUser1.equals(scissor) && randomRockPaperOrScissor.equals(paper)) {
                        user1Wins += 1;
                        System.out.println("Round " + i + " goes to " + username1 + "🎉");
                    } else if (rockPaperOrScissorUser1.equals(paper) && randomRockPaperOrScissor.equals(rock)) {
                        user1Wins += 1;
                        System.out.println("Round " + i + " goes to " + username1 + "🎉");
                    } else if (rockPaperOrScissorUser1.equals(paper) && randomRockPaperOrScissor.equals(scissor)) {
                        user2Wins += 1;
                        System.out.println("Round " + i + " goes to " + "the computer" + "🎉");
                    }
                }
                //finder vinderen
            if (user1Wins == user2Wins) {
                System.out.println("Its a draw🤝");
            } else if (user1Wins > user2Wins) {
                System.out.println(username1 + " is the winner🏆");
            } else if (user2Wins > user1Wins) {
                System.out.println("The computer" + " is the winner🏆");
            }
        }
    }
}
