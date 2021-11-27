import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    private static final Baum TEST_BAUM = new Baum(List.of(
            new Ast(
                    Collections.emptyList(),
                    List.of(
                            new Ast(List.of(
                                    new Blatt(true),
                                    new Blatt(false),
                                    new Blatt(true)
                            ), Collections.emptyList()),
                            new Ast(List.of(
                                    new Blatt(true),
                                    new Blatt(false),
                                    new Blatt(false)
                            ), List.of(
                                    new Ast(
                                            List.of(
                                                    new Blatt(true),
                                                    new Blatt(true)
                                            ),
                                            Collections.emptyList()
                                    )
                            ))
                    )),
            new Ast(
                    List.of(
                            new Blatt(false),
                            new Blatt(false),
                            new Blatt(true)
                    ),
                    Collections.emptyList()
            )
    ));
    private static int anzahlTestKeaferInBaum = 6;
    private static int anzahlTestKeaferImErstenAst = 5;

    @org.junit.jupiter.api.Test
    void findeKaeferInBaumSchleife() {
        assertEquals(anzahlTestKeaferInBaum, Main.findeKaeferInBaumSchleife(TEST_BAUM));
    }

    @org.junit.jupiter.api.Test
    void findeKeaferInAstSchleife() {
        assertEquals(anzahlTestKeaferImErstenAst, Main.findeKeaferInAstSchleife(TEST_BAUM.getAeste().get(0)));
    }

    @org.junit.jupiter.api.Test
    void findeKaeferInBaumStream() {
        assertEquals(anzahlTestKeaferInBaum, Main.findeKaeferInBaumStream(TEST_BAUM));
    }

    @org.junit.jupiter.api.Test
    void findeKeaferInAstStream() {
        assertEquals(anzahlTestKeaferImErstenAst, Main.findeKeaferInAstStream(TEST_BAUM.getAeste().get(0)));
    }
}
