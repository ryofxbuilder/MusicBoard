package java.GWpro;

import javax.sound.sampled.*;

/**
 * Created by ryosuke-akanuma on 2016/05/08.
 */
public class PlayBoard {
    static final int SAMPLE_RATE = 44100; // 44.1KHz
    static int BPM = 160, LOOP_MAX = 1;
    static AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
    static DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
    static SourceDataLine line;



    public static void play(Cell[] board){

        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            // Initialize Audio
            line.open();
            line.start();
            // 演奏
            int L16 = getSampleCount(16/*分音符*/);

            for(int loop = 0; loop < LOOP_MAX; loop++) {
                for (int i = 0; i < 16; i++) {
                    byte[] block = new byte[L16];
                    for (int j = 0; j < 16; j++) {
                        writeWave(block, board[i + j * 16].getCellNote(), board[i + j * 16].getVelocity());
                    }

                    line.write(block, 0, block.length);
                }
                //line.drain();
            }

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }

    // 実際に波形を書き込む
    static void writeWave(byte[] b, double frequency, int velocity) {
        double amplitude = SAMPLE_RATE / frequency;
        for (int i = 0; i < b.length; i++) {
            double r = i / amplitude;
            int v = (Math.round(r) % 2 == 0) ? velocity : -velocity;
            v += b[i];
            v = Math.min(Math.max(v, -128), 127);
            b[i] = (byte) v;
        }
    }

    // 音の長さを計算する
    static int getSampleCount(int nLength/*n分音符*/) {
        double n4 = (60.0 / BPM) * SAMPLE_RATE; // 四分音符のサンプル数
        double n1 = n4 * 4; // 全音符のサンプル数
        return (int) Math.round(n1 / nLength);
    }
}
