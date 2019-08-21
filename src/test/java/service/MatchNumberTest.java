package service;

import pojo.Number;

import static org.junit.Assert.*;

public class MatchNumberTest {

    @org.junit.Test
    public void matchRedNumber() {
    }

    @org.junit.Test
    public void matchNumber() {
        Number number = new Number();
        number.setRed1(5);
        number.setRed2(7);
        number.setRed3(8);
        number.setRed4(9);
        number.setRed5(20);
        number.setRed6(22);
        number.setBlue1(1);
        assertFalse(new MatchNumber().matchNumber(number));
    }

    @org.junit.Test
    public void matchDoubleRedNumber() {
        Number number = new Number();
        number.setRed1(5);
        number.setRed2(7);
        number.setRed3(8);
        number.setRed4(9);
        number.setRed5(20);
        number.setRed6(22);
        number.setBlue1(1);
        System.out.println(new MatchNumber().matchDoubleRedNumber(number));
    }

    @org.junit.Test
    public void matchTripleRedNumber() {
    }

    @org.junit.Test
    public void matchUltraRedNumber() {
    }

    @org.junit.Test
    public void matchRampageRedNumber() {
    }
}