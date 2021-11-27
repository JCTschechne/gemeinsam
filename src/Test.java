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
    private static final int ANZAHL_KEAFER_IN_BAUM = 6;
    private static final int ANZAHL_KEAFER_IM_ERSTEN_AST = 5;

    @org.junit.jupiter.api.Test
    void findeKaeferInBaumSchleife() {
        assertEquals(ANZAHL_KEAFER_IN_BAUM, Main.findeKaeferInBaumSchleife(TEST_BAUM));
    }

    @org.junit.jupiter.api.Test
    void findeKeaferInAstSchleife() {
        assertEquals(ANZAHL_KEAFER_IM_ERSTEN_AST, Main.findeKeaferInAstSchleife(TEST_BAUM.getAeste().get(0)));
    }

    @org.junit.jupiter.api.Test
    void findeKaeferInBaumStream() {
        assertEquals(ANZAHL_KEAFER_IN_BAUM, Main.findeKaeferInBaumStream(TEST_BAUM));
    }

    @org.junit.jupiter.api.Test
    void findeKeaferInAstStream() {
        assertEquals(ANZAHL_KEAFER_IM_ERSTEN_AST, Main.findeKeaferInAstStream(TEST_BAUM.getAeste().get(0)));
    }
}
