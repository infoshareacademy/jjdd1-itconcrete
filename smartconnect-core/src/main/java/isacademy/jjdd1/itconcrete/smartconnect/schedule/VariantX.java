package isacademy.jjdd1.itconcrete.smartconnect.schedule;
import java.util.ArrayList;


public class VariantX {

    private String variant;
    private ArrayList<BusStopDeltas> variantDeltas;

    public VariantX(String variant) {
        this.variant = variant;
    }

    public VariantX() {
    }

    public String getVariant() {
        return variant;
    }

    public ArrayList<BusStopDeltas> getVariantDeltas() {
        return variantDeltas;
    }
}
