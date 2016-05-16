package jp.co.navitime;


/**
 * Created by ryosuke-akanuma on 2016/05/04.
 */
public class Main {
    public static void main(String[] args){
        Cell[] board = new NoteCell[256];
        Scale[] scale = {new PentatonicScale(), new OriginalScale(), new DiminishScale()};
        int cellNum = 0, mode = 0, row = 0, column = 0, key = 1, scaleNum = 1;
        String[] scaleName = {"Pentatonic", "Original" , "Diminish"};
        String[] keyName = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        BoardSet.initializeBoard(board);
        CalculateFrequency.calcFrequency();
        scale[0].setScale(board, 0);


        /* ルール説明 */
        System.out.println("ボードには16×16の○がありそれぞれ音が割り当てられています。");
        System.out.println("音が入っている場合●で表示されます。");
        System.out.println("音の高さは列の番号で決まり、左の行から順に再生されます。\n");
        PrintScreen.print(board);
        System.out.println("Scale : " + scaleName[scaleNum - 1]);
        System.out.println("Key   : " + keyName[key - 1]);
        System.out.println("BPM   : " + PlayBoard.BPM);
        System.out.println("Loop  : " + PlayBoard.LOOP_MAX);
        System.out.println("\nそれでは指示に従い音楽を楽しんでください。\n");



        while (true) {
            System.out.println("\n1から8までの数字を入力し次の変更を行う。");
            System.out.println("1. 指定した座標のマルの色を反転させる");
            System.out.println("2. Scale を変更する");
            System.out.println("3. Key を変更する");
            System.out.println("4. BPM を変更する");
            System.out.println("5. ループ回数を変更する");
            System.out.println("6. サンプルボードを作成する");
            System.out.println("7. ランダムボードを作成する");
            System.out.println("8. プログラムを終了");
            System.out.printf("1 ～ 8 までの数字を入力してください。\n> ");
            mode = Input.input(8);
            switch (mode) {
                case 1:
                    System.out.printf("反転させるマルの列番号を入力してください。\n> ");
                    row = Input.input(16);
                    System.out.printf("反転させるマルの行番号を入力してください。\n> ");
                    column = Input.input(16);
                    cellNum = (row - 1) * 16 + column - 1;
                    board[cellNum].reverseState();
                    break;
                case 2:
                    System.out.println("変更する Scale を選んでください。");
                    System.out.println("1. Pentatonic Scale\n2. Original Scale\n3. Diminish Scale");
                    System.out.printf("1 ～ 3 までの数字を入力してください。\n> ");
                    scaleNum = Input.input(3);
                    scale[scaleNum - 1].setScale(board, key - 1);
                    break;
                case 3:
                    System.out.println("変更する Key を選んでください。");
                    System.out.println(" 1. C\n 2. C#\n 3. D\n 4. D#\n 5. E\n 6. F\n 7. F#\n 8. G\n 9. G#\n10. A\n11. A#\n12. B");
                    System.out.printf("1 ～ 12 までの数字を入力してください。\n> ");
                    key = Input.input(12);
                    scale[scaleNum - 1].setScale(board, key - 1);
                    break;
                case 4:
                    System.out.println("BPMを入力してください。");
                    System.out.printf("1 ～ 260 までの数字を入力してください。\n> ");
                    PlayBoard.BPM = Input.input(260);
                    break;
                case 5:
                    System.out.println("Loopを入力してください。");
                    System.out.printf("1 ～ 10 までの数字を入力してください。\n> ");
                    PlayBoard.LOOP_MAX = Input.input(10);
                    break;
                case 6:
                    BoardSet.downStairBoard(board);
                    break;
                case 7:
                    BoardSet.randomizeBoard(board);
                    break;
                case 8:
                    System.out.println("プログラムを終了します。\nご利用ありがとうございました。");
                    break;
            }
            if (mode == 8) break;
            PrintScreen.print(board);
            System.out.println("Scale : " + scaleName[scaleNum - 1]);
            System.out.println("Key   : " + keyName[key - 1]);
            System.out.println("BPM   : " + PlayBoard.BPM);
            System.out.println("Loop  : " + PlayBoard.LOOP_MAX);
            PlayBoard.play(board);
        }
    }
}
