package isacademy.jjdd1.itconcrete.smartconnect.test.ExemplaryCSVFileBuilder;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CSVFileWriter {

    private static final String COMMA_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMUNE = "ZTM";
    private static final String FILE_HEADER = "5;Flagi;Gmina;Nazwa;X0(00:00-29:59)";

    public static void writeCsvFile(String fileName) {

        OneLineInCSVWariantyBuilder olicwb1;
        olicwb1 = new OneLineInCSVWariantyBuilder("1", "B,P(213)",COMMUNE, "Strzyża PKM", "0");
        OneLineInCSVWariantyBuilder olicwb2;
        olicwb2 = new OneLineInCSVWariantyBuilder("2","P(2030)",COMMUNE,"Zajezdnia","1");
        OneLineInCSVWariantyBuilder olicwb3;
        olicwb3 = new OneLineInCSVWariantyBuilder("3","B,N,P(2168),1,I", COMMUNE,"Zajezdnia Nowy Port (dla wysiad.)","0");
        OneLineInCSVWariantyBuilder olicwb4;
        olicwb4 = new OneLineInCSVWariantyBuilder("4","P(2169)", COMMUNE,"Władysława IV", "-1");
        OneLineInCSVWariantyBuilder olicwb5;
        olicwb5 = new OneLineInCSVWariantyBuilder("5","B,N,K,P(209)",COMMUNE,"Nowy Port (Oliwska)","-1");


        ArrayList<OneLineInCSVWariantyBuilder> lines = new ArrayList<OneLineInCSVWariantyBuilder>();
        lines.add(olicwb1);
        lines.add(olicwb2);
        lines.add(olicwb3);
        lines.add(olicwb4);
        lines.add(olicwb5);

        OutputStreamWriter outputStreamWriter = null;

        try {

            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("Windows-1250"));
            outputStreamWriter.append(FILE_HEADER.toString());
            outputStreamWriter.append(NEW_LINE_SEPARATOR);


            for  (OneLineInCSVWariantyBuilder olicwb : lines) {
                outputStreamWriter.append(olicwb.getId());
                outputStreamWriter.append(COMMA_DELIMITER);
                outputStreamWriter.append(olicwb.getFlag());
                outputStreamWriter.append(COMMA_DELIMITER);
                outputStreamWriter.append(olicwb.getCommune());
                outputStreamWriter.append(COMMA_DELIMITER);
                outputStreamWriter.append(olicwb.getName());
                outputStreamWriter.append(COMMA_DELIMITER);
                outputStreamWriter.append(olicwb.getDelta());
                outputStreamWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}

