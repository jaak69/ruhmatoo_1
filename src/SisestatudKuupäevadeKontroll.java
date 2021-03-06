import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SisestatudKuupäevadeKontroll {
    private String algusKuuPäev;
    private String lõppKuuPäev;
    private boolean algusVäiksemLõpust;
    private boolean vahemikVäiksemKuiAasta;

    public SisestatudKuupäevadeKontroll(String algusKuuPäev, String lõppKuuPäev) {
        this.algusKuuPäev = algusKuuPäev;
        this.lõppKuuPäev = lõppKuuPäev;
    }

    /*Kuupäevade kontroll:
        String alguskuupäev peab olema väiksem kui lõppkuupäev
        Kuupäevade vahe peab olema väiksem kui 365 päeva.

         */
    public boolean kuupäevadeKontroll() throws ParseException {

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d1 = sdformat.parse(this.algusKuuPäev);
        Date d2 = sdformat.parse(this.lõppKuuPäev);

        if (d1.compareTo(d2) < 0 && d2.compareTo(d1) < 365) {
            return true;
        } else  {
            return false;
        }
    }
}
