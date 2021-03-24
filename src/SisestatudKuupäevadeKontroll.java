import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SisestatudKuupäevadeKontroll {
    private String algusKuuPäev;
    private String lõppKuuPäev;
    private boolean algusVäiksemLõpust = false;
    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void setAlgusKuuPäev(String algusKuuPäev) {
        this.algusKuuPäev = algusKuuPäev;
    }

    public void setLõppKuuPäev(String lõppKuuPäev) {
        this.lõppKuuPäev = lõppKuuPäev;
    }

    public String getAlgusKuuPäev() {
        return algusKuuPäev;
    }

    public String getLõppKuuPäev() {
        return lõppKuuPäev;
    }

    public void getKuupäevad(){
        //Kuupäevade küsimine kasutajalt
        Scanner scan = new Scanner(System.in);
        while (!algusVäiksemLõpust) {
            System.out.println("Sisesta perioodi alguskuupäev kujul \"2021-01-01\":");
            this.algusKuuPäev = scan.nextLine() + " 00:00";
            System.out.println("Sisesta perioodi lõpukuupäev kujul \"2021-01-02\":");
           this.lõppKuuPäev = scan.nextLine() + " 23:59";

            try {
                this.kuupäevadeKontroll();
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Vale kuupäeva formaat!");
            }
        }
    }

    public void getHomnePäev(){
        algusKuuPäev = sdformat.format(new Date((System.currentTimeMillis())));
        lõppKuuPäev = sdformat.format(new Date((System.currentTimeMillis() + 24*60*60*1000)));
    }

    /*Kuupäevade kontroll:
        String alguskuupäev peab olema väiksem kui lõppkuupäev
        Kuupäevade vahe peab olema väiksem kui 365 päeva.

         */
    private void kuupäevadeKontroll() throws ParseException {

        Date d1 = sdformat.parse(this.algusKuuPäev);
        Date d2 = sdformat.parse(this.lõppKuuPäev);

        if (d1.compareTo(d2) < 0 && d2.compareTo(d1) < 365) {
            algusVäiksemLõpust = true;
        } else  {
            System.out.println("Kontrolli sisestatud kuupäevi!");
            algusVäiksemLõpust = false;
        }
    }
}
