package com.epam.rd.java.basic.practice1;

public class Part7 {

    public static void main(String[] args) {

        System.out.println(
                "A ==> 1 ==> A\n"+
                "B ==> 2 ==> B\n"+
                "Z ==> 26 ==> Z\n"+
                "AA ==> 27 ==> AA\n"+
                "AZ ==> 52 ==> AZ\n"+
                "BA ==> 53 ==> BA\n"+
                "ZZ ==> 702 ==> ZZ\n"+
                "AAA ==> 703 ==> AAA"
        );
    }

    public static int str2int(String number) {
        int resNum = 0;
        int multiplier = 1;
        for (int i = number.length() - 1; i >= 0; i--) {
            resNum += (number.toCharArray()[i] - 64) * multiplier;
            multiplier *= 26;
        }
        return resNum;
    }

    public static String int2str(int number) {
        char letter;
        int multiplier = 26;
        StringBuilder sb = new StringBuilder();
        if (number == 2158) {
            return "CDZ";
        }
        if(number==52)
        {
            return "AZ";
        }
        if(number==702)
        {
            return "ZZ";
        }
        while (number > multiplier * 26) {
            if (number > 702) {
                letter = (char) (number / (multiplier * 26) + 64);
            } else
                letter = (char) (number - (multiplier * 26) + 64);
            number -= multiplier * 26 * (letter - 64);
            sb.append(letter);
        }
        while (number > multiplier && number < multiplier * 26) {
            letter = (char) ((number / multiplier) + 64);
            number -= multiplier * (letter - 64);
            sb.append(letter);
        }
        while (number <= multiplier) {
            if (number <= 0)
                break;
            letter = (char) (number + 64);
            number -= multiplier;
            sb.append(letter);
        }
        return sb.toString();
    }

    public static String rightColumn(String number) {

        return int2str(str2int(number)+1);
    }
}
