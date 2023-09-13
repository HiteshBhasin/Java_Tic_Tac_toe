
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ticTacToe {
    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> cpuPos = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameboard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

        while (true) {
            Scanner kb = new Scanner(System.in);
            int position = 0;
            Random rand = new Random();
            int cpuposition = rand.nextInt(9) + 1;

            System.out.print("please select the position betwen 1-9: ");
            position = kb.nextInt();
            while (playerPos.contains(position) || cpuPos.contains(position)) {
                System.out.println("postion taken please enter again");
                position = kb.nextInt();
            }
            placePiece(gameboard, position, "Player");
            while (playerPos.contains(cpuposition) || cpuPos.contains(cpuposition)) {
                cpuposition = rand.nextInt(9) + 1;
            }
            placePiece(gameboard, cpuposition, "cpu");
            printGameBoard(gameboard);
            String result = winning();
            System.out.println(result);
        }

    }

    public static void printGameBoard(char[][] gameboard) {
        for (char[] row : gameboard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameboard, int position, String user) {
        char symbol = ' ';
        if (user.equals("Player")) {
            symbol = 'X';
            playerPos.add(position);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPos.add(position);
        }
        switch (position) {
            case 1:
                gameboard[0][0] = symbol;
                break;
            case 2:
                gameboard[0][2] = symbol;
                break;
            case 3:
                gameboard[0][4] = symbol;
                break;
            case 4:
                gameboard[2][0] = symbol;
                break;
            case 5:
                gameboard[2][2] = symbol;
                break;
            case 6:
                gameboard[2][4] = symbol;
                break;
            case 7:
                gameboard[4][0] = symbol;
                break;
            case 8:
                gameboard[4][2] = symbol;
                break;
            case 9:
                gameboard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String winning() {
        List toprow = Arrays.asList(1, 2, 3);
        List midrow = Arrays.asList(4, 5, 6);
        List botrow = Arrays.asList(7, 8, 9);
        List topcol = Arrays.asList(1, 4, 7);
        List midcol = Arrays.asList(2, 5, 8);
        List botcol = Arrays.asList(3, 6, 9);
        List cros1 = Arrays.asList(1, 5, 9);
        List cros2 = Arrays.asList(7, 5, 3);

        List<List> newList = new ArrayList<List>();

        newList.add(0, toprow);
        newList.add(1, midrow);
        newList.add(2, botrow);
        newList.add(3, topcol);
        newList.add(4, midcol);
        newList.add(5, botcol);
        newList.add(6, cros1);
        newList.add(7, cros2);

        for (List list : newList) {
            if (playerPos.containsAll(list)) {
                return "congrats, you win!";
            } else if (cpuPos.containsAll(list)) {
                return "opps cpu wins";
            } else if (playerPos.size() + cpuPos.size() == 9) {
                return "its a tie";
            }
        }
        return " ";

    }

}
