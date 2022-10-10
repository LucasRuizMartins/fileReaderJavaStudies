package javaFileReaderProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
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
		// adicionar parametro True para não recriar o arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Enter a folder Path");
		String strPath = sc.nextLine();
		File pathFolder = new File(strPath);
		// Função para Listar somente as pastas
		File[] folders = pathFolder.listFiles(File::isDirectory);
		System.out.println("Folders :");
		for (File folder : folders) {
			System.out.println(folder);

		}

		// Função para Listar somente os arquivos
		File[] files = pathFolder.listFiles(File::isFile);
		System.out.println("FILES :");
		for (File file:files) {
			System.out.println(file);
			
		}
		
		boolean sucess = new File(pathFolder + "\\newFolder").mkdir();
		
		sc.close();
	}
}
