package com.epam.rd.java.basic.practice6.part6;

public class Part6 {


    public static void main(String[] args) {
        if ("frequency".equals(args[3])) Part61.main(new String[]{args[1]});
        else if("frequency".equals(args[1])) Part61.main(new String[]{args[3]});
        else if ("length".equals(args[3])) Part62.main(new String[]{args[1]});
        else if("length".equals(args[1])) Part62.main(new String[]{args[3]});
        else if ("duplicates".equals(args[3])) Part63.main(new String[]{args[1]});
        else if("duplicates".equals(args[1])) Part63.main(new String[]{args[3]});
    }

}
