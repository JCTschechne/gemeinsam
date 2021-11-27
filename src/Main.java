public class Main {

    /**
     * What the??… #RootsCoder?? Ich glaub ich steh im Wald!
     *
     * …dann aber hoffentlich in einem Mischwald. Sei ein produktiver Teil unseres Mischwald-Teams und bringe deine Stärken ein.
     * Denn wir brauche jetzt jemanden, der Käfer zählt! Irgendwie haben es die kleinen Biester geschafft sich einzuschleichen.
     * Wenn wir wissen, wie viele Käfer es schon sind, dann können wir die geeigneten Maßnahmen ergreifen und sie schnell los werden…da fällt dir gleich was ein?
     * Dann hau in die Tasten und rette unseren Wald: schreibe deine Methode für „findeKaeferInBaum(baum)“ and: #savethewoods
     *
     * Kleine Info für alle, die jetzt nicht so im Baumthema drin sind: eine Monokultur kann sich nicht gut wehren.
     * Nicht gegen Sturm, nicht gegen Trockenheit und auch nicht gegen Schädlinge. Aber ein Mischwald, der aus individuell gewachsenen Bäumen besteht,
     * die sich gegenseitig helfen und beschützen – der kann das wohl. Seine Wurzeln arbeiten symbiotisch nicht nur mit Pilzen – auch untereinander.
     *
     * Die Kronen lassen kleineren Bäumen Licht und stärken diese somit. Sie kommunizieren auch über Duftstoffe und warnen vor Gefahr.
     * So kann ein gesunder Baum dank einer Warnung ein spezielles Harz produzieren, welches Käfer abschreckt. Eben Teamwork und Rücksichtnahme. Der Mischwald.
     */
    public static void main(String[] args) {
        // Baum wird gebaut
        Baum baum = Baum.zufallsBaum();
        // Lösung
        int anzahlKaefer = findeKaeferInBaum(baum);
        System.out.println("Der Baum hat " + anzahlKaefer + " Käfer");
    }

    static int findeKaeferInBaum(Baum baum) {
        return findeKaeferInBaumSchleife(baum);
    }


    static int findeKaeferInBaumSchleife(Baum baum){
        int anzahlKaefer = 0;
        for(Ast ast : baum.getAeste()){
            anzahlKaefer += findeKeaferInAstSchleife(ast);
        }
        return anzahlKaefer;
    }

     static int findeKeaferInAstSchleife(Ast ast) {
        int anzahlKaefer = 0;
        for(Blatt blatt : ast.getBlaetter()){
            if(blatt.hatKaefer()) anzahlKaefer++;
        }
        for(Ast kinderAst : ast.getAeste()){
            anzahlKaefer += findeKeaferInAstStream(kinderAst);
        }
        return anzahlKaefer;
    }

    static int findeKaeferInBaumStream(Baum baum) {
        return baum.getAeste().stream().mapToInt(Main::findeKeaferInAstStream).sum();
    }

    static int findeKeaferInAstStream(Ast ast){
        return ast.getAeste().stream().mapToInt(Main::findeKeaferInAstStream).sum() +
                (int) ast.getBlaetter().stream().filter(Blatt::hatKaefer).count();
    }
}
