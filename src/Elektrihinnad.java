public class Elektrihinnad {
    private String maa;             // ee, fi, lt, lv
    private String kuupäev;         // formaat kujul yyyy-mm-dd
    private int tund;               // täistund N: 18 tähistab aega vahemikus 18:00-18:59
    private double elektrihind;     // Elektrihinnd senti/kWh

    public Elektrihinnad(String maa, String kuupäev, int tund, double elektrihind) {
        this.maa = maa;
        this.kuupäev = kuupäev;
        this.tund = tund;
        this.elektrihind = elektrihind;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public String getKuupäev() {
        return kuupäev;
    }

    public void setKuupäev(String kuupäev) {
        this.kuupäev = kuupäev;
    }

    public int getTund() {
        return tund;
    }

    public void setTund(int tund) {
        this.tund = tund;
    }

    public double getElektrihind() {
        return elektrihind;
    }

    public void setElektrihind(double elektrihind) {
        this.elektrihind = elektrihind;
    }
}
