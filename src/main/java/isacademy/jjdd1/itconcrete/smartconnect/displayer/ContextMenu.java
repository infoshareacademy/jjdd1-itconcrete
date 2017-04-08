package isacademy.jjdd1.itconcrete.smartconnect.displayer;

/**
 * Created by katarzynadobrowolska on 02.04.2017.
 */
public class ContextMenu {

    String welcomeText;
    String priorityQuestion;
    String resultText;
    String comfortFactor;

    public ContextMenu(String welcomeText, String priorityQuestion, String resultText, String comfortFactor){
        this.welcomeText = welcomeText;
        this.priorityQuestion = priorityQuestion;
        this.resultText = resultText;
        this.comfortFactor = comfortFactor;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public String getPriorityQuestion() {
        return priorityQuestion;
    }

    public String getResultText() {
        return resultText;
    }

    public String getComfortFactor() {
        return comfortFactor;
    }
}
