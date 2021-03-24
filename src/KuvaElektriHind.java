import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KuvaElektriHind {

    private JSONObject jsonElering;

    public void loeJson(String maa){
        //JSONObject dataMaa = (JSONObject) jsonElering.get("ee");      // 2021-03-2
        JSONArray dataMaa = (JSONArray) jsonElering.get("ee");

        System.out.println("See peaks olema eesti: " + dataMaa);

        }


    public void kuvaHomseElektriHinnaTabel(){
    }

    public void määratudVahemikuMinMax(JSONObject statesJson, String maa){
        //System.out.println(JSONObject jsonElering);
        //Kuvab valitud perioodil 3 min hinda koos kuupäevaga ja 3 max hinda koos kuuupäevaga

    }

    public void kuvaSuvalineElektriHind(){

    }

}
