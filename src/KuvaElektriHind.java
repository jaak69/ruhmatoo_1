import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KuvaElektriHind {

    private JSONObject jsonElering;
    private JSONArray maaEE;




    public void kuvaHomseElektriHinnaTabel(){
    }

    public void määratudVahemikuMinMax(JSONObject statesJson, String riik){
        
        //maaEE = loeJson(statesJson,riik);                           //SEE KUTSUB LÕPLIKU loeJson meetodi
        loeJson(statesJson, riik);

        //for (Object aeg: maaEE) {

            //töötle hind (see peaks olema privaatne meetod, sest käib kõigi andmete tõmbamise variantide kohta

            //töötle timestamp, mida me siit tahame

            //Min, Max väärtused

        //}

        //kas see meetod tagastab väärtused või prindib lõpptulemuse välja?
    }

    public void kuvaSuvalineElektriHind(){

    }

    //private JSONArray loeJson(JSONObject statesJson, String riik){    SEE PEAB TULEMA ja ANDMA iNFO VÄLJA
    private void loeJson(JSONObject statesJson, String riik){
        JSONArray dataRiik = (JSONArray) statesJson.get(riik);
        for (int i = 0; i < dataRiik.size();i++){
            JSONObject tunniInfo = (JSONObject) dataRiik.get(i);
            //String tund = tunnidTimestampist((String) tunniInfo.get("timestamp"));
            //String tund = (String) tunniInfo.get("timestamp");
            //String hind = (String) tunniInfo.get("price");
            System.out.println("Hind " + tunniInfo.get("price") + " ajal " + tunniInfo.get("timestamp"));

        }
        //return (JSONArray) jsonElering.get(riik);                     SEE PEAB LÕPLIKUL OLEMA
    }

    private String tunnidTimestampist (String timestamp){
        return new SimpleDateFormat("H").format(new Date(Integer.parseInt(timestamp)*1000L));
    }

}
