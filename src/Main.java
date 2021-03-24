import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        String apiEndPoint;
        boolean kuupäevaKontroll;
        String algusKuupäev;
        String lõpuKuupäev;
        String restEndPoint = "/api/nps/price";
        JSONObject data;

        System.out.println("Programm - Elektrihinnad soovitud ajavahemikul.");
        System.out.println("Programm väljastab:");

        //Objekt kuupäevade määramiseks ja kontrollimiseks
        SisestatudKuupäevadeKontroll kuupäevadeVahemik = new SisestatudKuupäevadeKontroll();

        //klass, mis tõmbab Eleringi API json infot
        EleringJsonApi eleringInfo = new EleringJsonApi(restEndPoint);

        //Kasutaja menüü sisestus
        Scanner scan = new Scanner(System.in);

        System.out.println("Vali mis infot sa soov2id Eleringist saada. Valiku kinnitamiseks sisesta\n loetelu ees " +
                "olev järjenumber");
        System.out.println("1. Soovin elektri kWh hindade tabelit minu valitud kuupäevade vahemikus.");
        System.out.println("2. Näita järgmise päeva 3 kõrgemat ja 3 madalamat tunnihinda.");
        System.out.println("3. Näita suvalise kuupäeva elektrihinda.");
        System.out.println("4. Lõpeta programmi töö.");
        //Salvesta kasutaja valik1
        int valik = scan.nextInt();

        switch(valik) {
            case 1:
                //Lase kasutajal valida kuupäevade vahemik
                kuupäevadeVahemik.getKuupäevad();
                //Käivita kasutaja sisestatud kuupäevadega Eleringi päring
                    eleringInfo.setStart(kuupäevadeVahemik.getAlgusKuuPäev());
                    eleringInfo.setEnd(kuupäevadeVahemik.getLõppKuuPäev());
                    data = eleringInfo.getEleringData();

                //Käivita KuvaElektrihind vajalik meetod, mis tagastab soovitud kujul elektrihinnad
                   JSONObject stateData = (JSONObject) data.get("data");

                    JSONArray eeData = (JSONArray) stateData.get("ee");
                System.out.println("See on EE data: " + eeData);

                //TODO

                break;
            case 2:
                //Määra algusaeg päringu hetkest + 24H
                kuupäevadeVahemik.getHomnePäev();
                //Käivita kasutaja sisestatud kuupäevadega Eleringi päring
                eleringInfo.setStart(kuupäevadeVahemik.getAlgusKuuPäev());
                eleringInfo.setEnd(kuupäevadeVahemik.getLõppKuuPäev());
                data = eleringInfo.getEleringData();
                //Käivita KuvaElektrihind vajalik meetod, mis tagastab soovitud kujul elektrihinnad




                //TODO


                break;
            case 3:
                // code block
                break;
            default:
                // code block
        }



       /* JSONObject data = info.getEleringData();

        JSONArray data2 = data.getJSONArray("data");

        System.out.println(info.getEleringData());
*/
        //KuvaElektriHind proov = new KuvaElektriHind(info.getEleringData());
        //System.out.println(proov);
        /*while(true){
            //kasutaja sisestus siia menüü number mida ta tahab käivitada

            int menuItemNumber;

            doSomething();
            doSomethingElse();
            System.out.println("some debugging info");
            doAnotherThing();
        }*/
    }
}
