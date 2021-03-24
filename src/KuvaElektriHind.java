import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class KuvaElektriHind {

    private JSONObject jsonElering;
    private JSONArray maaEE;




    public void kuvaHomseElektriHinnaTabel(){
    }

    public void määratudVahemikuMinMax(JSONObject statesJson, String riik){
        
        maaEE = loeJson(statesJson,riik);

        for (Object aeg: maaEE) {

            //töötle hind (see peaks olema privaatne meetod, sest käib kõigi andmete tõmbamise variantide kohta

            //töötle timestamp, mida me siit tahame

            //Min, Max väärtused

        }

        //kas see meetod tagastab väärtused või prindib lõpptulemuse välja?
    }

    public void kuvaSuvalineElektriHind(){

    }

    private JSONArray loeJson(JSONObject statesJson, String riik){
       return (JSONArray) jsonElering.get(riik);
    }

}
