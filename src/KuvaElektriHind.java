import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

public class KuvaElektriHind {

    private JSONObject jsonElering;
    private JSONArray maaEE;


    Elektrihind eesti = new Elektrihind();

    // List elektritarbimise andmetega
    private ArrayList<Elektrihind> elektrihind = new ArrayList<>();

    // List top 3 salvestamiseks
    private ArrayList<Elektrihind> tipud = new ArrayList<>();

    public void kuvaHomseElektriHinnaTabel(){
    }

    public void määratudVahemikuMinMax(JSONObject statesJson, String riik){
        
        //maaEE = loeJson(statesJson,riik);                           //SEE KUTSUB LÕPLIKU loeJson meetodi
        loeJson(statesJson, riik);

        // Vaatan, kas midagi jäi üldse meelde
        System.out.println(elektrihind.size());

        // Leian top 3 elektrihinnad
        System.out.println(top(3));
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
            String aeg = tunnidTimestampist((Long) tunniInfo.get("timestamp"));
            double hind = Math.round(((double) tunniInfo.get("price"))/10.0*100)/100.0;
            //System.out.println("Hind " + aeg +  " on " + hind + " senti/kWh");
            Elektrihind tunnihind = new Elektrihind(aeg,hind);
            elektrihind.add(tunnihind);
        }
        //System.out.println(eesti.);
        //return (JSONArray) jsonElering.get(riik);                     SEE PEAB LÕPLIKUL OLEMA
    }

    // Elektri top'i arvutamine
    private ArrayList<Elektrihind> top (int n){
        Collections.sort(elektrihind, Collections.reverseOrder());
        if (n > elektrihind.size()){
            n = elektrihind.size();
        }
        for (int i = 0; i < n; i++){
            tipud.add(elektrihind.get(i));
        }
        return tipud;
    }

    private String tunnidTimestampist (Long timestamp){
        return new SimpleDateFormat("dd-MM-yyyy hh:mm").format(new Date((timestamp)*1000L));
    }

}
