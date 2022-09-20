package net.hypnozcore.hypnozcore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FormatTextTest {
    /**
     * Method under test: {@link FormatText#formatCode(String)}
     */
    @Test
    void testFormatCode() {
        assertEquals("code", FormatText.formatCode("Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("Code");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("foo");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("U");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre4() {
        assertEquals(9, FormatText.getOrdre(HypnozCoreCostance.REGEX_0_9));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("UU");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre7() {
        assertEquals(9, FormatText.getOrdre("U[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("UCode");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre9() {
        assertEquals(42, FormatText.getOrdre("U42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre10() {
        assertEquals(9, FormatText.getOrdre("[^0-9]U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre11() {
        assertEquals(909, FormatText.getOrdre("[^0-9][^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre12() {
        assertEquals(9, FormatText.getOrdre("[^0-9]Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre13() {
        assertEquals(942, FormatText.getOrdre("[^0-9]42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre14() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("CodeU");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre15() {
        assertEquals(9, FormatText.getOrdre("Code[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre16() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("CodeCode");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre17() {
        assertEquals(42, FormatText.getOrdre("Code42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre18() {
        assertEquals(42, FormatText.getOrdre("42U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre19() {
        assertEquals(4209, FormatText.getOrdre("42[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre20() {
        assertEquals(42, FormatText.getOrdre("42Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre21() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("UUU");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre22() {
        assertEquals(9, FormatText.getOrdre("UU[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre23() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("UUCode");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre24() {
        assertEquals(42, FormatText.getOrdre("UU42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre25() {
        assertEquals(9, FormatText.getOrdre("U[^0-9]U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre26() {
        assertEquals(909, FormatText.getOrdre("U[^0-9][^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre27() {
        assertEquals(9, FormatText.getOrdre("U[^0-9]Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre28() {
        assertEquals(942, FormatText.getOrdre("U[^0-9]42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre29() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("UCodeU");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre30() {
        assertEquals(9, FormatText.getOrdre("UCode[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre31() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("UCodeCode");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre32() {
        assertEquals(42, FormatText.getOrdre("UCode42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre33() {
        assertEquals(42, FormatText.getOrdre("U42U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre34() {
        assertEquals(4209, FormatText.getOrdre("U42[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre35() {
        assertEquals(42, FormatText.getOrdre("U42Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre36() {
        assertEquals(4242, FormatText.getOrdre("U4242"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre37() {
        assertEquals(9, FormatText.getOrdre("[^0-9]UU"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre38() {
        assertEquals(909, FormatText.getOrdre("[^0-9]U[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre39() {
        assertEquals(9, FormatText.getOrdre("[^0-9]UCode"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre40() {
        assertEquals(942, FormatText.getOrdre("[^0-9]U42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre41() {
        assertEquals(909, FormatText.getOrdre("[^0-9][^0-9]U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre42() {
        assertEquals(90909, FormatText.getOrdre("[^0-9][^0-9][^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre43() {
        assertEquals(909, FormatText.getOrdre("[^0-9][^0-9]Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre44() {
        assertEquals(90942, FormatText.getOrdre("[^0-9][^0-9]42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre45() {
        assertEquals(9, FormatText.getOrdre("[^0-9]CodeU"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre46() {
        assertEquals(909, FormatText.getOrdre("[^0-9]Code[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre47() {
        assertEquals(9, FormatText.getOrdre("[^0-9]CodeCode"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre48() {
        assertEquals(942, FormatText.getOrdre("[^0-9]Code42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre49() {
        assertEquals(942, FormatText.getOrdre("[^0-9]42U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre50() {
        assertEquals(94209, FormatText.getOrdre("[^0-9]42[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre51() {
        assertEquals(942, FormatText.getOrdre("[^0-9]42Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre52() {
        assertEquals(94242, FormatText.getOrdre("[^0-9]4242"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre53() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("CodeUU");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre54() {
        assertEquals(9, FormatText.getOrdre("CodeU[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre55() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("CodeUCode");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre56() {
        assertEquals(42, FormatText.getOrdre("CodeU42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre57() {
        assertEquals(9, FormatText.getOrdre("Code[^0-9]U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre58() {
        assertEquals(909, FormatText.getOrdre("Code[^0-9][^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre59() {
        assertEquals(9, FormatText.getOrdre("Code[^0-9]Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre60() {
        assertEquals(942, FormatText.getOrdre("Code[^0-9]42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre61() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("CodeCodeU");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre62() {
        assertEquals(9, FormatText.getOrdre("CodeCode[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrdre63() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ""
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Integer.parseInt(Integer.java:678)
        //       at java.lang.Integer.parseInt(Integer.java:786)
        //       at net.hypnozcore.hypnozcore.utils.FormatText.getOrdre(FormatText.java:26)
        //   In order to prevent getOrdre(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getOrdre(String).
        //   See https://diff.blue/R013 to resolve this issue.

        FormatText.getOrdre("CodeCodeCode");
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre64() {
        assertEquals(42, FormatText.getOrdre("CodeCode42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre65() {
        assertEquals(42, FormatText.getOrdre("Code42U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre66() {
        assertEquals(4209, FormatText.getOrdre("Code42[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre67() {
        assertEquals(42, FormatText.getOrdre("Code42Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre68() {
        assertEquals(4242, FormatText.getOrdre("Code4242"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre69() {
        assertEquals(42, FormatText.getOrdre("42UU"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre70() {
        assertEquals(4209, FormatText.getOrdre("42U[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre71() {
        assertEquals(42, FormatText.getOrdre("42UCode"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre72() {
        assertEquals(4242, FormatText.getOrdre("42U42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre73() {
        assertEquals(4209, FormatText.getOrdre("42[^0-9]U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre74() {
        assertEquals(420909, FormatText.getOrdre("42[^0-9][^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre75() {
        assertEquals(4209, FormatText.getOrdre("42[^0-9]Code"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre76() {
        assertEquals(420942, FormatText.getOrdre("42[^0-9]42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre77() {
        assertEquals(42, FormatText.getOrdre("42CodeU"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre78() {
        assertEquals(4209, FormatText.getOrdre("42Code[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre79() {
        assertEquals(42, FormatText.getOrdre("42CodeCode"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre80() {
        assertEquals(4242, FormatText.getOrdre("42Code42"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre81() {
        assertEquals(4242, FormatText.getOrdre("4242U"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre82() {
        assertEquals(424209, FormatText.getOrdre("4242[^0-9]"));
    }

    /**
     * Method under test: {@link FormatText#getOrdre(String)}
     */
    @Test
    void testGetOrdre83() {
        assertEquals(4242, FormatText.getOrdre("4242Code"));
    }
}

