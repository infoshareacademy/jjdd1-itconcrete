package isacademy.jjdd1.itconcrete.smartconnect.map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Set;

public class StopsGetter {

    public Set<Stop> getStops() throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream("/stops_light.json"), Charset.forName("UTF-8")));
        Type type = new TypeToken<Set<Stop>>() {}.getType();
        Set<Stop> stops = gson.fromJson(bufferedReader, type);

        return stops;
    }

}
