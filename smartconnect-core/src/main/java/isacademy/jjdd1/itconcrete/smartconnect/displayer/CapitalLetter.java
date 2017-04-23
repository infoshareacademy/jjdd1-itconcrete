package isacademy.jjdd1.itconcrete.smartconnect.displayer;

public class CapitalLetter {

    public static String makeFirstLetterCapital(String busName){

        String result = busName.substring(0,1).toUpperCase() + busName.substring(1, busName.length()).toLowerCase();

        return result;
    }

}
