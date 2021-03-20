import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShortMain {

    public static void main(String[] args) throws IOException, ParseException {

        String apiEndPoint;
        boolean kuupäevaKontroll;
        String restEndPoint = "/api/nps/price";

        System.out.println("Programm - Elektrihinnad soovitud ajavahemikul.");
        System.out.println("Programm väljastab:");

        //Lähteandmete küsimine kasutajalt
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Sisesta perioodi alguskuupäev kujul \"2021-01-01 20:00\":");
        String algusKuupäev = "2021-03-19 00:00";
        //System.out.println("Sisesta perioodi lõpukuupäev kujul \"2021-01-01 20:00\":");
        String lõpuKuupäev = "2021-03-19 23:59";

        //Sisestud kuupäevade konroll.
        //Alguskuupöev peab olema varase kui lõpukuupäev
        //Kuupäevade vahe ei tohi olla suurm kui 365 päeva
        //Sisestatud kuupäeva vale formaadikorral kuvatakse veateade
        SisestatudKuupäevadeKontroll kont = new SisestatudKuupäevadeKontroll(algusKuupäev,lõpuKuupäev);
        try {
            Boolean kuupäevadeKontroll = kont.kuupäevadeKontroll();
        } catch (java.text.ParseException e) {
            System.out.println("Vale kuupäeva formaat. Kuupäev peab olema formaadis - 2021-01-01 00:00");
        }

        System.out.println("Vali mis infot sa soovid Eleringist saada. Valiku kinnitamiseks sisesta\n loetelu ees " +
                "olev järjenumber");
        System.out.println("1. Soovin elektri kWh hindade tabelit minu valitud kuupäevade vahemikus.");
        System.out.println("2. Soovin kõige kallimat ja odavamt elektri kWh hinda minu valitud kuupäevade vahemikus.");
        System.out.println("3. Näita suvalise kuupäeva elektrihinda.");
        System.out.println("4. Lõpeta programmi töö.");
        int valik = 1;

        switch(valik) {
            case 1:
                // code block
                break;
            case 2:
                // code block
                break;
            case 3:
                // code block
                break;
            default:
                // code block
        }

        //klass, mis tõmbab Eleringi API json infot
        EleringJsonApi info = new EleringJsonApi(algusKuupäev, lõpuKuupäev, restEndPoint);
        System.out.println(info.getEleringData());

        // Proov leida timestam'ist tund ja kuupäev
        int prooviaeg = 1616115600;
        String hourFromTimestamp = new SimpleDateFormat("H").format(new Date(prooviaeg*1000L));
        String dateFromTimestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date(prooviaeg*1000L));
        System.out.println(hourFromTimestamp);
        System.out.println(dateFromTimestamp);

        KuvaElektriHind  proov = new KuvaElektriHind(info.getEleringData());


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
