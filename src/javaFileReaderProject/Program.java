package javaFileReaderProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String path = "c:\\Program1\\in.txt";
		String pathOut = "c:\\Program1\\out.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();

			}
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage());

		}

		String[] lines = new String[] { "Good Morning", "Good afternoon", "Good Night" };
																	//adicionar parametro True para não recriar o arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
