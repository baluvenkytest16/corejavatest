package com.bala.corejava.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bala.corejava.common.Utils;

public class ReadFileTest {

	public static void main(String[] args) throws IOException {
		
		ReadFileTest readFileTest = new ReadFileTest();
		readFileTest.testReadFileLine();
		readFileTest.readLinesUsingFileReader();
	}

	private void testReadFileLine() throws IOException {
		Utils.printLineSeperator();
		System.out.println("testing reading file from the path....");
		Path filePath = Paths.get(".", "README.md");
		Files.lines(filePath).forEach(System.out::println);
		
		System.out.println("\nRead file and filter only some lines....");
		Files.lines(Paths.get(".", "pom.xml"))
			.filter(s -> s.contains("plugin"))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
	}
	private void readLinesUsingFileReader() throws IOException 
	{
		Utils.printLineSeperator();
		System.out.println("Reading file in Java7....");
	    File file = new File("./pom.xml");
	 
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	 
	    String line;
	    while((line = br.readLine()) != null)
	    {
	        if(line.contains("plugin")){
	            System.out.println(line);
	        }
	    }
	    br.close();
	    fr.close();
	}

}
