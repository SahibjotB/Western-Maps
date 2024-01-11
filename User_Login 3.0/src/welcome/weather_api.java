package welcome;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;

/**
 *
 * @author karanvir
 */
public class weather_api {
    //toggle to prevent application from performing excessive api calls.
    public boolean api_active = true;
    // API KEY: 43bf013664d12ae850e29d4f0ce17df4
    
    //parameters of api request:
    public static String[] city_names = {"London", "Toronto", "Montreal", 
    "Vancouver", "Winnipeg"};
    public static String[] city_ids = {"6058560", "6167865", "6077243",
    "6173331", "6183235"};
    public static String[] city_lats = {"42.9834", "43.700111", "45.508839",
    "49.24966", "49.884399"};
    public static String[] city_longs = {"-81.233", "-79.416298", "-73.587807",
    "-123.119339", "-97.147041"};
    
    public static String API_key = "75fd83a4f5e86677cf86e63a159f9e17";
    //by default, backup key is deactivated to test the case that Api calls fail on server-side,
    //if necessary to activate back-up key, activation time takes 1-2 hours
    public static String API_backup_key = "43bf013664d12ae850e29d4f0ce17df4";
    public static URL new_url;
    public static String[] query_result = new String[4];

    //formulates the request to the API
    public static String[] api_call(int selec_city) throws Exception {
        //formats the api call string with the api key and the lat/long
        String queryString = String.format(
                "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s", 
                city_lats[selec_city], city_longs[selec_city], API_key);

        try {
            new_url = new URL(queryString);    
        } catch (MalformedURLException e) {

            throw new Exception("Error: URL is Malformed; confirm API query syntax", e);
        }
    
        
        HttpURLConnection http_con = (HttpURLConnection)new_url.openConnection();
        http_con.setRequestMethod("GET");
        
        // String weather_desc = http_con.getHeaderField("weather");
        int status = http_con.getResponseCode();
        
        //buffered reader to store entire api query result as a StringBuffer sequence.
        BufferedReader api_in = new BufferedReader(
        new InputStreamReader(http_con.getInputStream()));
        String inputLine;
        StringBuilder query_content = new StringBuilder();
        while ((inputLine = api_in.readLine()) != null) {
            query_content.append(inputLine);
        }
        api_in.close();
        
        
        
        //System.out.println(query_content);
        //main weather type
        int m_start = query_content.indexOf("\"main\":\"");
        int m_end = query_content.indexOf("\",", m_start);
        //takes substring of api query and returns weather type component
        String main_type = query_content.substring(m_start+8, m_end);
        //System.out.println(main_type);

        //weather desc
        int d_start = query_content.indexOf("\"description\":\"");
        int d_end = query_content.indexOf("\",", d_start);
        //takes substring of api query and returns weather type component
        String desc_type = query_content.substring(d_start+15, d_end).toUpperCase();
        //System.out.println(desc_type);
        
        //current temp
        int t_start = query_content.indexOf("\"temp\":");
        int t_end = query_content.indexOf(",", t_start);
        //takes substring of api query and returns weather type component
        String curr_temp = query_content.substring(t_start+7, t_end);
        //conversion to celsius
        int temp = (int)(Double.parseDouble(curr_temp) - 273.15);
        curr_temp = Integer.toString(temp);
        //System.out.println(curr_temp);

        //feels like temp
        int fl_start = query_content.indexOf("\"feels_like\":");
        int fl_end = query_content.indexOf(",", fl_start);
        //takes substring of api query and returns weather type component
        String fl_temp = query_content.substring(fl_start+13 , fl_end);
        //conversion to celsius, temporary int as api result array is String[]
        int temp_fl = (int)(Double.parseDouble(fl_temp) - 273.15);
        fl_temp = Integer.toString(temp_fl);
        //System.out.println(fl_temp);
        
        query_result[0] = main_type;
        query_result[1] = desc_type;
        query_result[2] = curr_temp;
        query_result[3] = fl_temp;
        //main_type, desc_type, curr_temp, fl_temp;
        
        //System.out.println(query_content);
        //System.out.println(query_result.toString());
        return query_result;

    };

    //initialises variables
    
    
}
