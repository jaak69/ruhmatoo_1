public class Main {

    public static void main(String[] args) {

        //kas kõik need TODO võiks ka klassi panna ???
        //TODO Riigi valik, mille infot vajame
        String algus;
        //TODO Siia kasutajalt algus kuupäeva ja kellaaja küsimine kujul '2021-01-01 00:00'
        String lõpp;
        //TODO Siia kasutajalt lõpu kuupäeva ja kellaaja küsimine kujul '2021-01-01 00:00'
        String restEndpoint;
        //TODO REST endpointi valik


        //klass, mis tõmbab Eleringi API json infot
        EleringJsonApi info = new EleringJsonApi(algus, lõpp, restEndpoint);

        while(true){
            //kasutaja sisestus siia menüü number mida ta tahab käivitada

            int menuItemNumber;

            doSomething();
            doSomethingElse();
            System.out.println("some debugging info");
            doAnotherThing();
        }
    }
}
