package lab13practice.managmentSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Connection {

	String filename = "data.txt";

	public void WriteToFile(String record) throws IOException {
		FileWriter file = new FileWriter(filename, true);
		BufferedWriter writer = new BufferedWriter(file);

		writer.write(record);
		writer.newLine();
		writer.close();
	}

	public String[][] readFile() throws IOException {
		FileReader file = new FileReader(filename);
		BufferedReader buffer = new BufferedReader(file);

		String line = null;
		int i = 0;
		String[] records = new String[6];
		String data[][] = new String[2][];

		while ((line = buffer.readLine()) != null) {
			records = line.split(",");
			data[i] = records;
			i++;
		}

		return data;
	}
}
