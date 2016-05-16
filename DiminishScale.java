package java.GWpro;

/**
 * Created by ryosuke-akanuma on 2016/05/09.
 */
public class DiminishScale implements Scale{
    public void setScale(Cell[] board, int key) {
        for (int i = 0; i < 16; i++) {
            board[i].setCellNote(CalculateFrequency.getNoteFreq(6, key + 9));
            board[i + 16].setCellNote(CalculateFrequency.getNoteFreq(6, key + 6));
            board[i + 32].setCellNote(CalculateFrequency.getNoteFreq(6, key + 3));
            board[i + 48].setCellNote(CalculateFrequency.getNoteFreq(6, key));
            board[i + 64].setCellNote(CalculateFrequency.getNoteFreq(5, key + 9));
            board[i + 80].setCellNote(CalculateFrequency.getNoteFreq(5, key + 6));
            board[i + 96].setCellNote(CalculateFrequency.getNoteFreq(5, key + 3));
            board[i + 112].setCellNote(CalculateFrequency.getNoteFreq(5, key));
            board[i + 128].setCellNote(CalculateFrequency.getNoteFreq(4, key + 9));
            board[i + 144].setCellNote(CalculateFrequency.getNoteFreq(4, key + 6));
            board[i + 160].setCellNote(CalculateFrequency.getNoteFreq(4, key + 3));
            board[i + 176].setCellNote(CalculateFrequency.getNoteFreq(4, key));
            board[i + 192].setCellNote(CalculateFrequency.getNoteFreq(3, key + 9));
            board[i + 208].setCellNote(CalculateFrequency.getNoteFreq(3, key + 6));
            board[i + 224].setCellNote(CalculateFrequency.getNoteFreq(3, key + 3));
            board[i + 240].setCellNote(CalculateFrequency.getNoteFreq(3, key));
        }
    }
}
