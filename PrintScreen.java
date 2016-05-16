package java.GWpro;

/**
 * Created by ryosuke-akanuma on 2016/05/05.
 */
public class PrintScreen {
    public static void print(Cell[] board) {
        System.out.println();
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16");
        System.out.println("  +― ― ― ― ― ― ― ― ― ― ― ― ― ― ― ―");
        for (int i = 0; i < 16; i++) {
            printLine(board, i);
        }
    }

    public static void printLine(Cell[] board, int i) {
        if (i < 9) System.out.printf(" ");
        System.out.printf((i + 1) + "|");
        for (int j = 0; j < 16; j++) {
            if (!board[(i * 16) + j].getCellState()) {
                System.out.printf("○ ");
            } else {
                System.out.printf("● ");
            }
        }
        System.out.println();
    }
}
