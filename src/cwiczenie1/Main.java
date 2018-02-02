package cwiczenie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		// scanFile("res/cwiczenie1/poem.txt","Dale");
		// readFile("res/cwiczenie1/poem.txt", "Dale", "pale","away");
		readChars("res/cwiczenie1/poem.txt");
	}

	private static void scanFile(String filename, String keyword) throws Exception {
		File poemFile = new File(filename);
		Scanner scanner = new Scanner(poemFile);
		int count = 0;

		while (scanner.hasNext()) {
			if (scanner.next().contains(keyword)) {
				// System.out.println(keyword);
				count = count + 1;
			}

		}
		System.out.println("Found tokens " + count);
		System.out.println("File path: " + System.getProperty("user.dir"));
		double discFreeSpace = poemFile.getFreeSpace();
		System.out.println("Free space: " + discFreeSpace / (1024 * 1024) + " NB");
		System.out.println("Free space: " + discFreeSpace / (1024 * 1024 * 1024) + " GB");
		scanner.close();
	}

	public static void readFile(String file, String... keyword) {
		File poemFile = new File(file);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			String line = null;
			int count = 0;
			int countLines = 0;
			while ((line = reader.readLine()) != null) {
				count += 1;
				for (String word : keyword) {
					if (line.contains(word)) {
						countLines += 1;
						System.out.println("Line content: " + line + " Linenumber: " + count);
						break; // zeby nie wczytywal drugi raz lini kotra
								// zawiera wiecej niz jeden keyword
					}
				}

			}
			System.out.println("Total number of printed lines: " + countLines);
		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}

	}

	public static void readChars(String filename) {
		File poemFile = new File(filename);
		int count = 0;
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			// String line=null;
			while (reader.read() != -1) {
				count += 1;
			}

		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}

		System.out.println(count);

	}

}
