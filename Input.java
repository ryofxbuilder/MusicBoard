package jp.co.navitime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ryosuke-akanuma on 2016/05/05.
 */
public class Input {
    public static int input(int maxNumber){
        int number;
        String input = "error";
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                input = read.readLine();
            }catch (IOException e){
                System.out.println(e.getMessage() +  "1 ～ " + maxNumber + "までの数字を再度入力してください。\n> ");
                continue;
            }
            if(input == null){
                System.out.printf("Ctrl + Z は入力できません。\n再度入力してください。\n> ");
                continue;
            }
            try {
                number = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.printf("数字以外は入力できません。\n1 ～ " + maxNumber + "までの数字を再度入力してください。\n> ");
                continue;
            }
            if(number > maxNumber || number <= 0){
                System.out.printf("1 ～ " + maxNumber + "までの数字を再度入力してください。\n> ");
            }else {
                break;
            }
        }
        return number;
    }
}
