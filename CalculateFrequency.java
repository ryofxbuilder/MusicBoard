package jp.co.navitime;

/**
 * Created by ryosuke-akanuma on 2016/05/08.
 */
public class CalculateFrequency {
    static double note_freq[] = new double[128];

    // 音名から NoteNo を計算する
    static int getNoteNo(int octave, int noteName) {
        return octave * 12 + noteName;
    }
    static double getNoteFreq(int octave, int noteName) {
        return note_freq[getNoteNo(octave, noteName)];
    }
    // 周波数を計算してテーブルにセットする
    static void calcFrequency() {
        double r = Math.pow(2.0, 1.0 / 12.0);// 半音(2の12乗根)を計算

        note_freq[69] = 440.0;
        for (int i = 70; i < 128; i++) {
            note_freq[i] = note_freq[i-1] * r;
        }
        for (int i = 68; i >= 0; i--) {
            note_freq[i] = note_freq[i+1] / r;
        }
        return;
    }


}
