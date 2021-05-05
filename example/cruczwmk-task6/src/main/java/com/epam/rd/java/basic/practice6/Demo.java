package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part1.Part1;
import com.epam.rd.java.basic.practice6.part2.Part2;
import com.epam.rd.java.basic.practice6.part3.Part3;
import com.epam.rd.java.basic.practice6.part4.Part4;
import com.epam.rd.java.basic.practice6.part5.Part5;
import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

	public static void main(String[] args) {
		String deliminator = "--------------------------------";
		Part1.main(args);
		System.out.println(deliminator);
		Part2.main(args);
		System.out.println(deliminator);
		Part3.main(args);
		System.out.println(deliminator);
		Part4.main(args);
		System.out.println(deliminator);
		Part5.main(args);
		System.out.println(deliminator);
		Part6.main(new String[]{"-p","part6.txt","--task","frequency"});
	}

}
