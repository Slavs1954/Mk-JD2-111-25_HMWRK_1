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
    void thirdIntTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("сто миллионов", cCv.toString(100_000_000));
    }
    @Test
    void fourthIntTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("сто двадцать", cCv.toString(120));
    }

    @Test
    void firstDoubleTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("двести двадцать три целых пятнадцать сотых", cCv.toString(223.1_599_999));
    }

    @Test
    void secondDoubleTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("одна целая двенадцать сотых", cCv.toString(1.123_142));
    }
    @Test
    void thirdDoubleTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("тринадцать целых одна сотая", cCv.toString(13.01));
    }
    @Test
    void fourthDoubleTestToString() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("тринадцать целых четырнадцать сотых", cCv.toString(13.14));
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
    @Test
    void thirdTestToHoursMinuteSecondMillisecond() {
        CustomConvert cCv = new CustomConvert();
        Assertions.assertEquals("12 часов 17 минут 15 секунд 30 миллисекунд", cCv.toHoursMinuteSecondMillisecond(44235030, false));
    }

}