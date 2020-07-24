package com.bala.corejava.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.bala.corejava.common.Utils;

public class WriteFileTest {

	public static void main(String[] args) throws IOException {
		WriteFileTest writeFileTest = new WriteFileTest();
		
		writeFileTest.testWriteFile();

	}

	private void testWriteFile() throws IOException {
		
		Utils.printLineSeperator();
		System.out.println("Using newBufferWriter writing in file");
		//Get the file reference
		Path path = Paths.get("output.txt");
		 
		//Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path)) 
		{
		    writer.write("Hello World !!");
		}
		
		Files.lines(path).forEach(System.out::println);
		
		String content = "Hello World from FilesWrite!!";
		 
		Files.write(path, content.getBytes()); // will override the existing content in the file
		
		Files.lines(path).forEach(System.out::println);
		
		//StandardOpenOption.APPEND
		
		String newcontent = "\nappend the new text";
		 
		Files.write(path, newcontent.getBytes(),StandardOpenOption.APPEND); // will override the existing content in the file
		
		Files.lines(path).forEach(System.out::println);
	}

}
