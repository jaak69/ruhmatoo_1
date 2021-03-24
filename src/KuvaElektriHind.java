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

    // List alumise top 3 salvestamiseks
    private ArrayList<Elektrihind> põhjad = new ArrayList<>();

    public void kuvaHomseElektriHinnaTabel(){
    }

    public void määratudVahemikuMinMax(JSONObject statesJson, String riik){

        // loen JSON objektist andmed
        loeJson(statesJson, riik);

        // Määran top'i pikkuse
        int topPikkus = 1;

        // Leian top 3 elektrihinnad
        topUp(topPikkus);

        // Leian madalamad 3 elektrihinda
        topDown(topPikkus);

        // Väljastan andmed
        System.out.println("---------------------------------------------------------------");
        System.out.println("|     Kõrgeim(ad) hin(na)d     |     Madalaim(ad) hin(na)d    |");
        System.out.println("---------------------------------------------------------------");

        // Näitan nii mitme anmde komplekti kui pikk on lühim top
        int ridu = tipud.size();
        if (põhjad.size() < tipud.size()){
            ridu = põhjad.size();
        }
        for (int i = 0; i < ridu; i++){
            System.out.println("| " + tipud.get(i).getAeg() + "   -   " + tipud.get(i).getHind() + "  | " + põhjad.get(i).getAeg() + "   -   " + põhjad.get(i).getHind() + "  |");
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void kuvaSuvalineElektriHind(){
    }

    //Loeb Json objektist andmed ja lisab need Elektrihind klassi alusel listi elektrihind
    private void loeJson(JSONObject statesJson, String riik){
        JSONArray dataRiik = (JSONArray) statesJson.get(riik);
        for (int i = 0; i < dataRiik.size();i++){
            JSONObject tunniInfo = (JSONObject) dataRiik.get(i);

            // Loeb timestamp'ist kellaaja ja kuupäeva
            String aeg = tunnidTimestampist((Long) tunniInfo.get("timestamp"));

            // Teisendab elektrihinna EUR/MWh ümber senti/kWh
            double hind = Math.round(((double) tunniInfo.get("price"))/10.0*100)/100.0;
            Elektrihind tunnihind = new Elektrihind(aeg,hind);
            elektrihind.add(tunnihind);
        }
    }

    // Elektrihinna ülemise top'i arvutamine
    private ArrayList<Elektrihind> topUp (int n){
        Collections.sort(elektrihind, Collections.reverseOrder());
        if (n > elektrihind.size()){
            n = elektrihind.size();
        }
        for (int i = 0; i < n; i++){
            tipud.add(elektrihind.get(i));
        }
        return tipud;
    }

    // Elektrihinna alumise top'i arvutamine
    private ArrayList<Elektrihind> topDown (int n){
        Collections.sort(elektrihind);
        if (n > elektrihind.size()){
            n = elektrihind.size();
        }
        for (int i = 0; i < n; i++){
            põhjad.add(elektrihind.get(i));
        }
        return põhjad;
    }

    // Timestamp'i tesendamine
    private String tunnidTimestampist (Long timestamp){
        return new SimpleDateFormat("dd-MM-yyyy hh:mm").format(new Date((timestamp)*1000L));
    }

}
