package jp.co.navitime;

/**
 * Created by ryosuke-akanuma on 2016/05/06.
 */
public class NoteCell extends Cell {
    private boolean cellState = false;
    private double cellNote = 0.0;

    public NoteCell() {
        cellState = false;
        cellNote = 0.0;
    }

    public boolean getCellState() {
        return this.cellState;
    }

    public void setCellState(boolean state) {
        this.cellState = state;
    }

    public double getCellNote() {
        return this.cellNote;
    }

    public void setCellNote(double heltz) {
        this.cellNote = heltz;
    }

    public int getVelocity() {
        if (this.cellState) {
            return 8;
        } else {
            return 0;
        }
    }

    public void reverseState() {
        if (this.cellState) {
            setCellState(false);
        } else {
            setCellState(true);
        }
    }

}
