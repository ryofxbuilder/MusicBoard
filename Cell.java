package jp.co.navitime;

/**
 * Created by ryosuke-akanuma on 2016/05/06.
 */
public abstract class Cell {
    private boolean cellState = false;
    private double cellNote = 0.0;

    public abstract boolean getCellState();

    public abstract void setCellState(boolean state);

    public abstract double getCellNote();

    public abstract void setCellNote(double heltz);

    public abstract int getVelocity();

    public abstract void reverseState();
}
