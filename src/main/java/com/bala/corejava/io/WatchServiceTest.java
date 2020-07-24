package com.bala.corejava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.bala.corejava.common.Utils;

public class WatchServiceTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WatchServiceTest watchServiceTest = new WatchServiceTest();
		
		watchServiceTest.testWatchServiceDirectoryUpdate();

	}

	private void testWatchServiceDirectoryUpdate() throws IOException, InterruptedException {
		Utils.printLineSeperator();
		System.out.println("Watch sevice If any modification done in that directory");
		
		
		Path path = Paths.get(".");
		WatchService watchService = path.getFileSystem().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		//registerDirectory(watchService, path);
		Files.write(Paths.get(".","output1.txt"), "Hello world !!!".getBytes());
		
		
		IntStream.range(0, 5).forEach(
				index -> {
					createFileForEveryOneMinute(index);
				}
			);
		
			/* WatchKey adding reference */
		WatchKey watchKey = null;
		while (true) {
		    watchKey = watchService.poll(2, TimeUnit.SECONDS);
		    if(watchKey != null) {
		        watchKey.pollEvents().stream().forEach(event -> System.out.println(event.context()));
		        // Will monitor the directory and watch any modification done or not If yes.. display file name (event object is file)
		    }
		    watchKey.reset();
		}
		
		
	}
	
	private void createFileForEveryOneMinute(int counter) {
		Thread th = new Thread(() -> 
		{
			try {
				createNewFile(counter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		th.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createNewFile(int index) throws IOException {
		System.out.println("File creating with index:: "+ index);
		String fileName = "output-"+index+"-"+LocalDateTime.now().toString()+".txt";
		String content = "Hello world !!!";
		Files.write(Paths.get(".",fileName), content.getBytes());
		System.out.println("File Created ...\n\n");
	}

}
