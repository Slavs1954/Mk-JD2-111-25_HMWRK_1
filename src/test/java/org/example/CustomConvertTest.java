package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomConvertTest {

    @Test
    void firstIntTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("сто один миллион сто двадцать две тысячи двести тридцать четыре", cCv.toString(101_122_234));
    }
    @Test
    void secondIntTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("двести двадцать три", cCv.toString(223));
    }

    @Test
    void firstDoubleTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("двести двадцать три целых пятнадцать сотых", cCv.toString(223.1_599_999));
    }

    @Test
    void firstTestToWeek() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("0 недель", cCv.toWeek(5));
    }
    @Test
    void secondTestToWeek() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("2 недели", cCv.toWeek(14));
    }
    @Test
    void thirdTestToWeek() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("25 недель", cCv.toWeek(177));
    }

    @Test
    void firstTestToHoursMinuteSecondMillisecond() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("02:09:49.001", cCv.toHoursMinuteSecondMillisecond(7789001, true));
    }
    @Test
    void secondTestToHoursMinuteSecondMillisecond() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("2 часа 9 минут 49 секунд 1 миллисекунда", cCv.toHoursMinuteSecondMillisecond(7789001, false));
    }

}