package isacademy.jjdd1.itconcrete.smartconnect.map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;

public class StopsGetter {

    public List<Stop> getStops() throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("/stops_light.json"), Charset.forName("UTF-8")));
        Type type = new TypeToken<List<Stop>>() {}.getType();
        List<Stop> stops = gson.fromJson(bufferedReader, type);
        stops.forEach(a -> System.out.println(a));

        return stops;
    }

}
