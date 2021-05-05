package com.epam.rd.java.basic.practice6.part1;


import java.util.*;

public class WordContainer {
	public static void main(String[] args) {
		readWord();
	}

	static void readWord()
	{
		HashMap<String,Integer> words = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String word;
		while (sc.hasNext()){
			word = sc.next();
			if("stop".equals(word))
				break;
			if (!words.containsKey(word))
				words.put(word,1);
			else
				words.put(word, words.get(word)+1);
		}

		words.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(s -> System.out.println(s.getKey()+" : "+s.getValue()));
	}
}
