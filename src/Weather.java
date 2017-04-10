import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * Created by Mike on 2017-04-10.
 */
public class Weather {
    private weatherJSON weather;
    public Weather() throws IOException {
        StringBuffer sb = new StringBuffer();
        URL w = new URL("http://api.openweathermap.org/data/2.5/weather?id=6087824&units=metric&APPID=549aa289fff643f349d6b649fadbc145");
        BufferedReader br = new BufferedReader(new InputStreamReader(w.openStream()));
        String line = null;
        int read;
        char[] chars = new char[1024];
        while ((read = br.read(chars)) != -1)
            sb.append(chars, 0, read);
        String json = sb.toString();
        Gson g = new Gson();
        weather = g.fromJson(json, weatherJSON.class);
        br.close();
    }
    public String getTemp(){
        return weather.main.temp;
    }
    static class weatherJSON {
        coord coord;
        List<weather> weather;
        String base;
        main main;
        String visibility;
        wind wind;
        clouds clouds;
        String dt;
        sys sys;
        String id;
        String name;
        String cod;
    }

    static class coord{
        String lon;
        String lat;
    }
    static class weather{
        String id;
        String main;
        String description;
        String icon;
    }
    static class main{
        String temp;
        String pressure;
        String humidity;
        String temp_min;
        String temp_max;
    }
    static class wind{
        String speed;
    }
    static class clouds{
        String all;
    }
    static class sys{
        String type;
        String id;
        String message;
        String country;
        String sunrise;
        String sunset;
    }
}

