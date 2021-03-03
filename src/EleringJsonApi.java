import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;


public class EleringJsonApi {
    private String start;
    private String end;
    private String restEndPoint;
    private String baseUrl="https://dashboard.elering.ee/";

    public EleringJsonApi(String algus, String lõpp, String endpoint) {
        this.start = algus;
        this.end = lõpp;
        this.restEndPoint = endpoint;
    }

    private URL createURL(String base, String endpoint, String start, String end) {
        URL url = null;
        try{
            URL url = new URL(base+endpoint + "?" + "start=" + start + "&end=" + end);
        }catch (MalformedURLException e) {
            System.err.println("URL oli vigane");
            System.err.println("Väljastatud viga: " + e.getMessage());
        }
        return url;
    }

    public void httpConnection(URL url){

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //Elering API nõuab GET meetodit
        conn.setRequestMethod("GET");
        conn.connect();

        //Testi kas ühendus on korras HTTP kood 200
        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("Http vastuskood vea korral: " + responsecode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Kirjuta kõik andmed JSON stringi
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Sulge scanner
            scanner.close();

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);

        }


    }


}
