import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

public class KuvaElektriHind {

    private JSONObject jsonElering;
    private JSONArray maaEE;

    // List elektritarbimise andmetega
    private ArrayList<Elektrihind> elektrihind = new ArrayList<>();

    // List top 3 salvestamiseks
    private ArrayList<Elektrihind> tipud = new ArrayList<>();

    // List alumise top 3 salvestamiseks
    private ArrayList<Elektrihind> põhjad = new ArrayList<>();

    public void kuvaHomseElektriHinnaTabel(JSONObject statesJson, String riik){

        // Loeb JSON objektist andmed
        loeJson(statesJson, riik);

        // Määrab top'i pikkuse
        int topPikkus = 3;

        // Leiab top 3 elektrihinnad
        topUp(topPikkus);

        // Leiab madalamad 3 elektrihinda
        topDown(topPikkus);

        // Väljastab andmed
        System.out.println("---------------------------------------");
        System.out.println("| Järgneva 24 tunni elektrihinnad     |");
        System.out.println("---------------------------------------");
        System.out.println("| Kõrgeimad                           |");
        System.out.println("---------------------------------------");
        for (int i = 0; i < tipud.size();i++){
            System.out.println("|  " + tipud.get(i).getAeg() + "     |     " + tipud.get(i).getHind() + "    |");
        }
        System.out.println("---------------------------------------");
        System.out.println("| Madalaimad                          |");
        System.out.println("---------------------------------------");
        for (int i = 0; i < põhjad.size();i++){
            System.out.println("|  " + põhjad.get(i).getAeg() + "     |     " + põhjad.get(i).getHind() + "    |");
        }
        System.out.println("---------------------------------------");
    }

    public void määratudVahemikuMinMax(JSONObject statesJson, String riik){

        // Loeb JSON objektist andmed
        loeJson(statesJson, riik);

        // Määrab top'i pikkuse
        int topPikkus = 1;

        // Leiab top n elektrihinnad
        topUp(topPikkus);

        // Leiab madalamad n elektrihinda
        topDown(topPikkus);

        // Väljastab andmed
        System.out.println("---------------------------------------------------------------");
        System.out.println("|     Kõrgeim(ad) hin(na)d     |     Madalaim(ad) hin(na)d    |");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < topPikkus; i++){
            System.out.println("| " + tipud.get(i).getAeg() + "   -   " + tipud.get(i).getHind() + "  | " + põhjad.get(i).getAeg() + "   -   " + põhjad.get(i).getHind() + "  |");
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void kuvaSuvalineElektriHind(JSONObject statesJson){
        // Loeb andmed Eesti kohta
        System.out.println(statesJson);
        loeJson(statesJson,"ee");
        ArrayList<Elektrihind> eesti = (ArrayList<Elektrihind>) elektrihind.clone();
        elektrihind.clear();
        // Loeb andmed Läti kohta
        loeJson(statesJson,"lv");
        ArrayList<Elektrihind> läti = (ArrayList<Elektrihind>) elektrihind.clone();
        elektrihind.clear();
        // Loeb andmed Leedu kohta
        loeJson(statesJson,"lt");
        ArrayList<Elektrihind> leedu = (ArrayList<Elektrihind>) elektrihind.clone();
        elektrihind.clear();
        // Loeb andmed Soome kohta
        loeJson(statesJson,"fi");
        ArrayList<Elektrihind> soome = (ArrayList<Elektrihind>) elektrihind.clone();
        elektrihind.clear();

        // Väljastab andmed
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| Aeg                  |     Eesti    |     Läti     |     Leedu    |     Soome    |");
        System.out.println("------------------------------------------------------------------------------------");
        for (int i = 0; i < eesti.size(); i++){
            System.out.println("|   " + eesti.get(i).getAeg() + "   |      " + eesti.get(i).getHind() + "    |      " + läti.get(i).getHind() + "    |      " + leedu.get(i).getHind() + "    |      " + soome.get(i).getHind() + "    |");
        }
        System.out.println("------------------------------------------------------------------------------------");
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
