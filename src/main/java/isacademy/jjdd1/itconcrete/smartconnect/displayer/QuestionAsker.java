package isacademy.jjdd1.itconcrete.smartconnect.displayer;

import java.util.Scanner;

public class QuestionAsker{

    public static String askForInfo(){

        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        return info;
    }

}
