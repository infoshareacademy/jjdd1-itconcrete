package isacademy.jjdd1.itconcrete.smartconnect.test.ExemplaryCSVFileBuilder;


public class OneLineInCSVWariantyBuilder extends Object {


    private String id;
    private String flag;
    private String commune;
    private String name;
    private String delta;

    public OneLineInCSVWariantyBuilder(String id, String flag, String commune, String name, String delta) {
        super();
        this.id = id;
        this.flag = flag;
        this.commune = commune;
        this.name = name;
        this.delta = delta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    @Override
    public String toString() {
        return "OneLineInCSVWariantyBuilder{" +
                "id='" + id + '\'' +
                ", flag='" + flag + '\'' +
                ", commune='" + commune + '\'' +
                ", name='" + name + '\'' +
                ", delta='" + delta + '\'' +
                '}';
    }
}
