import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        String apiEndPoint;
        boolean kuupäevaKontroll;
        String restEndPoint = "/api/nps/price";

        System.out.println("Programm - Elektrihinnad soovitud ajavahemikul.");
        System.out.println("Programm väljastab:");

        //Lähteandmete küsimine kasutajalt
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta perioodi alguskuupäev kujul \"2021-01-01 20:00\":");
        String algusKuupäev = scan.nextLine();
        System.out.println("Sisesta perioodi lõpukuupäev kujul \"2021-01-01 20:00\":");
        String lõpuKuupäev = scan.nextLine();

        //Sisestud kuupäevade konroll.
        //Alguskuupöev peab olema varase kui lõpukuupäev
        //Kuupäevade vahe ei tohi olla suurm kui 365 päeva
        //Sisestatud kuupäeva vale formaadikorral kuvatakse veateade
        SisestatudKuupäevadeKontroll kont = new SisestatudKuupäevadeKontroll("2021-01-01","2021-01-01 22:00");
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
        int valik = scan.nextInt();

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
