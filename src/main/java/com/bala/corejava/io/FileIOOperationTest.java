package com.bala.corejava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bala.corejava.common.Utils;

public class FileIOOperationTest {

	public static void main(String[] args) {
		FileIOOperationTest fileIOTest = new FileIOOperationTest();
		
		try {
			fileIOTest.testIterateDirectory();
			fileIOTest.testOnlyFileList();
			fileIOTest.testGetSubDirectoriesUsingStream();
			fileIOTest.testGetSubDirectoriesOnlyUsingStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void testGetSubDirectoriesOnlyUsingStream() throws IOException {
		
		Utils.printLineSeperator();
		System.out.println("\nUsing newDirectoryStream getting only directoryies ....");
		Files.newDirectoryStream(Paths.get("."))
        .forEach(System.out::println);
		
		System.out.println("\nUsing newDirectoryStream getting only files files ....");
		Files.newDirectoryStream(Paths.get("."), path -> path.toFile().isFile())
        .forEach(System.out::println);
		
		System.out.println("\nUsing newDirectoryStream getting only specified extension files ....");
		Files.newDirectoryStream(Paths.get("."),
		        path -> path.toString().endsWith(".xml"))
		        .forEach(System.out::println);
		
		System.out.println("\nUsing newDirectoryStream getting only hidden files ....");
		
		Files.list(Paths.get(".")).filter(t -> {
			try {
				return Files.isHidden(t);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}).forEach(System.out::println);
		
	}

	private void testGetSubDirectoriesUsingStream() throws IOException {
		Utils.printLineSeperator();
		System.out.println("Get only sub directories ....");
		Files.newDirectoryStream(Paths.get("."))
        .forEach(System.out::println);
		
	}

	private void testIterateDirectory() throws IOException {
		Utils.printLineSeperator();
		System.out.println("Iterate file in directory ....");
		Files.list(Paths.get("."))
        .forEach(System.out::println);
		
	}

	private void testOnlyFileList() throws IOException {
		Utils.printLineSeperator();
		System.out.println("Get only files from directory ....");
		Files.list(Paths.get("."))
        .filter(Files::isRegularFile)
        .forEach(System.out::println);
		
	}

}
