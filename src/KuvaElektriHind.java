import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class KuvaElektriHind {

    private JSONObject jsonElering;

    public KuvaElektriHind(JSONObject jsonElering) {
        this.jsonElering = jsonElering;
        System.out.println(this.jsonElering);
    }

    public void loeJson(JSONObject jsonElering){
        JSONArray country = (JSONArray) jsonElering.get("ee");
        Iterator<JSONObject> iterator = country.iterator();
        while (iterator.hasNext()){
            System.out.println("Järgmine: 2" + iterator.next());
        }
    }

    public void kuvaHomseElektriHinnaTabel(){

    }

    public void kuvaMaxMinElektriHind(){
        //System.out.println(JSONObject jsonElering);
        //Kuvab valitud perioodil 3 min hinda koos kuupäevaga ja 3 max hinda koos kuuupäevaga

    }

    public void kuvaSuvalineElektriHind(){

    }

}
