package ua.kharkiv.yeremenko.exCollections;

import ua.kharkiv.yeremenko.exCollections.part4.Part4;
import ua.kharkiv.yeremenko.exCollections.part6.Part6;
import ua.kharkiv.yeremenko.exCollections.part1.Part1;
import ua.kharkiv.yeremenko.exCollections.part2.Part2;
import ua.kharkiv.yeremenko.exCollections.part3.Part3;
import ua.kharkiv.yeremenko.exCollections.part5.Part5;
import ua.kharkiv.yeremenko.exCollections.part7.Part7;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Demo {
	private static final InputStream STD_IN = System.in;
	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws Exception {
		System.out.println("~~~~~~~~~~~~Part1");
		System.setIn(new ByteArrayInputStream("asd asdf asd asdf asdf 43 43 asdsf 43 434".getBytes(ENCODING)));
		Part1.main(args);
		System.setIn(STD_IN);

		System.out.println("~~~~~~~~~~~~Part2");
		Part2.main(args);

		System.out.println("~~~~~~~~~~~~Part3");
		Part3.main(args);
		
		System.out.println("~~~~~~~~~~~~Part4");
		Part4.main(args);
		
		System.out.println("~~~~~~~~~~~~Part5");
		Part5.main(args);		

		System.out.println("~~~~~~~~~~~~Part6");
		Part6.main(args);

		System.out.println("~~~~~~~~~~~~Part7");
		Part7.main(args);		
	}

}