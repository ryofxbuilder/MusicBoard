package jp.co.navitime;

/**
 * Created by ryosuke-akanuma on 2016/05/08.
 */
public class BoardSet {
    public static void initializeBoard(Cell[] board) {
        for (int i = 0; i < board.length; i++) {
            board[i] = new NoteCell();
        }
    }

    public static void randomizeBoard(Cell[] board) {
        for (int i = 0; i < board.length; i++) {
            int random = (int) (Math.random() * 10 % 2);
            if (random == 0) {
                board[i].setCellState(true);
            } else {
                board[i].setCellState(false);
            }
        }
    }

    public static void downStairBoard(Cell[] board) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (i == j) {
                    board[i * 16 + j].setCellState(true);
                } else {
                    board[i * 16 + j].setCellState(false);
                }
            }
        }
    }
}
