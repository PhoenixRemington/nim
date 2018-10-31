package NIM;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Multiplayer {
    Scanner input = new Scanner(System.in);
    //Nim Nim = new Nim();
    Pile Pile = new Pile(0);
    public Pile pileA;
    public Pile pileB;
    public Pile pileC;
    int[] players;
    int gameState;
    int size;



    public Multiplayer() {
//        Pile pileA = new Pile(size);
//        Pile pileB = new Pile(size);
//        Pile pileC = new Pile(size);
    }
    private void playerCreation() {
        int numberPlayers;
        out.println("How many players would you like to have? ");
        while (true) {
            try {
                numberPlayers = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                out.println("Please give me an actual number.");
            }
        }
        players = new int[numberPlayers];
    }

    public void pileCreation() {
        out.println("How many sticks would you like to be in each  of the 3 piles ");
        size = input.nextInt();

//        while (true) {
//            try {
//                size = input.nextInt();
//                break;
//            } catch (InputMismatchException e) {
//                out.println("Please give me an actual number.");
//            }
//        }

    }


    public void MultiPlayerMove() {
        boolean number = true;
        do {
            Pile pileA = new Pile(size);
            Pile pileB = new Pile(size);
            Pile pileC = new Pile(size);
            number = false;
        }
        while (number == true);

        int playerNum;
        char playerChoice;

        do {
            out.print("Select a pile: ");
            playerChoice = Character.toLowerCase(input.next().charAt(0));
        }
        while (playerChoice != 'a' && playerChoice != 'b' && playerChoice != 'c');
        switch (playerChoice) {
            case 'a':
                out.print("How many do you want to remove? ");
                while (true) {
                    try {
                        playerNum = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        out.println("Please give me an actual number.");
                    }
                }
                while (playerNum > pileA.sticks || playerNum < 1) {
                    out.println("You have picked more sticks than there are in pile A please pick again.");
                    out.print("How many do you want to remove? ");
                    while (true) {
                        try {
                            playerNum = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            out.println("Please give me an actual number.");
                        }
                    }
                }
                Pile.remove(playerNum, pileA);
                break;
            case 'b':
                out.print("How many do you want to remove? ");
                while (true) {
                    try {
                        playerNum = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        out.println("Please give me an actual number.");
                    }
                }
                while (playerNum > pileB.sticks || playerNum < 1) {
                    out.println("You have picked more sticks than there are in pile B please pick again.");
                    out.print("How many do you want to remove? ");
                    while (true) {
                        try {
                            playerNum = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            out.println("Please give me an actual number.");
                        }
                    }
                }
                Pile.remove(playerNum, pileB);
                break;
            case 'c':
                out.print("How many do you want to remove? ");
                while (true) {
                    try {
                        playerNum = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        out.println("Please give me an actual number.");
                    }
                }
                while (playerNum > pileC.sticks || playerNum < 1) {
                    out.println("You have picked more sticks than there are in pile C please pick again.");
                    out.print("How many do you want to remove? ");
                    while (true) {
                        try {
                            playerNum = input.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            out.println("Please give me an actual number.");
                        }
                    }
                }
                Pile.remove(playerNum, pileC);
                break;
        }
        out.println(Pile.getSize(pileA, pileB, pileC));
        if (Pile.get(pileA) + Pile.get(pileB) + Pile.get(pileC) == 1) {
            out.println("Congrats! You Won");
            gameState = 0;

        }
    }


    public void MultiGameplay() {

        playerCreation();
        pileCreation();
        for (int i : players) {
            do {
                MultiPlayerMove();
            }
            while (gameState != 1);
        }
    }
}