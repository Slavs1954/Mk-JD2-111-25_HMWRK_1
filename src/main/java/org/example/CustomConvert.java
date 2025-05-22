package org.example;

public class CustomConvert {


    private static final String[] UNITS = {
        "", "один", "два", "три", "четыре", "пять",
        "шесть", "семь", "восемь", "девять", "десять",
        "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
        "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] TENS = {
        "", "десять", "двадцать", "тридцать", "сорок",
        "пятьдесят", "шестьдесят", "семьдесят",
        "восемьдесят", "девяносто"
    };

    private static final String[] HUNDREDS = {
        "", "сто", "двести", "триста", "четыреста",
        "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

    private static final String[] UNITS_FEM = {
        "", "одна", "две", "три", "четыре", "пять",
        "шесть", "семь", "восемь", "девять", "десять",
        "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
        "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };


    public  String toString(int number) {
        StringBuilder retStringBuilder = new StringBuilder();

        int mil = number / 1_000_000;
        if (mil > 0) {
            retStringBuilder.append(threeNumToString(mil, false))
                    .append(" ")
                    .append(decline(mil, "миллион", "миллиона", "миллионов"))
                    .append(" ");
        }

        int thousand = (number / 1_000) % 1_000;
        if (thousand > 0) {
            retStringBuilder.append(threeNumToString(thousand, true))
                    .append(" ")
                    .append(decline(thousand, "тысяча", "тысячи", "тысяч"))
                    .append(" ");
        }

        int last = number % 1_000;
        if (last > 0) {
            retStringBuilder.append(threeNumToString(last, false));
        }


        return retStringBuilder.toString().trim();
    }

    private  String threeNumToString(int number, boolean isFeminine) {
        String[] unitsArr = isFeminine ? UNITS_FEM : UNITS;


        StringBuilder retStringBuilder = new StringBuilder();
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;

        if (hundreds > 0) {
            retStringBuilder.append(HUNDREDS[hundreds]).append(" ");
        }

        if (tens > 1) {
            retStringBuilder.append(TENS[tens]).append(" ");
            if (units > 0) {
                retStringBuilder.append(unitsArr[units]).append(" ");
            }
        }
        else if (tens == 1) {
            retStringBuilder.append(unitsArr[10 + units]).append(" ");
        }
        else {
            if (units > 0) {
                retStringBuilder.append(unitsArr[units]).append(" ");
            }
        }


        return retStringBuilder.toString().trim();

    }

    private  String decline(int number, String firstForm, String secondForm, String thirdForm) {
        int n = number % 100;
        if (n >= 11 && n <= 19) {
            return thirdForm;
        }
        int lastDigit = n % 10;
        switch (lastDigit) {
            case 1:
                return firstForm;
            case 2:
            case 3:
            case 4:
                return secondForm;
            default:
                return thirdForm;
        }

    }

    private  String decline(long number, String firstForm, String secondForm, String thirdForm) {
        int n = (int) number % 100;
        if (n >= 11 && n <= 19) {
            return thirdForm;
        }
        int lastDigit = n % 10;
        switch (lastDigit) {
            case 1:
                return firstForm;
            case 2:
            case 3:
            case 4:
                return secondForm;
            default:
                return thirdForm;
        }

    }



    public  String toString(double number) {
        int integer = (int) number;
        int decimal = (int) (number * 100) % 100;

        StringBuilder retStringBuilder = new StringBuilder();

        if (integer % 10 == 1) {
            retStringBuilder.append("одна")
                    .append(" ")
                    .append("целая")
                    .append(" ");
        }
        else {
            retStringBuilder.append(toString(integer))
                    .append(" ")
                    .append("целых")
                    .append(" ");
        }

        if (decimal % 10 == 1) {
            retStringBuilder.append(threeNumToString(decimal, true))
                    .append(" ")
                    .append(decline(decimal, "сотая", "сотых", "сотых"))
                    .append(" ");
        }
        else {
            retStringBuilder.append(threeNumToString(decimal, false))
                    .append(" ")
                    .append(decline(decimal, "сотая", "сотых", "сотых"))
                    .append(" ");
        }

        return retStringBuilder.toString().trim();

    }

    public  String toWeek(int day) {
        int week = day / 7;
        StringBuilder retStringBuilder = new StringBuilder();

        retStringBuilder.append(week)
                .append(" ")
                .append(decline(week, "неделя", "недели", "недель"))
                .append(" ");

        return  retStringBuilder.toString().trim();
    }

    String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat) {
        long hours = millisecond / 3_600_000;
        millisecond -= hours * 3_600_000;

        long minutes = millisecond / 60_000;
        millisecond -= minutes * 60_000;


        long seconds = millisecond / 1_000;
        millisecond -= seconds * 1_000;


        if (!shortFormat) {

            StringBuilder retStringBuilder = new StringBuilder();

            retStringBuilder.append(hours)
                    .append(" ")
                    .append(decline(hours, "час", "часа", "часов"))
                    .append(" ");

            retStringBuilder.append(minutes)
                    .append(" ")
                    .append(decline(minutes, "минута", "минуты", "минут"))
                    .append(" ");
            retStringBuilder.append(seconds)
                    .append(" ")
                    .append(decline(seconds, "секунда", "секунды", "секунд"))
                    .append(" ");
            retStringBuilder.append(millisecond)
                    .append(" ")
                    .append(decline(millisecond, "миллисекунда", "миллисекунды", "миллисекунд"))
                    .append(" ");

            return retStringBuilder.toString().trim();
        }
        else {
            String retString = "%02d:%02d:%02d.%03d";
            return String.format(retString, hours, minutes, seconds, millisecond).trim();
        }
    }
}
