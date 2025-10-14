package utilz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LoadSaveFiles {

	// the function creates a new file with layer data
	public static void CreateLayerFile(String name, int[][] level) {
		File newLayer = new File("res/" + name + ".txt");

		if (newLayer.exists()) {
			System.out.println("File " + newLayer + " already exists");
			return;
		} else {
			try {
				newLayer.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Write2DArrToFile(newLayer, level);
		}
	}

	// writing the data to a file
	private static void Write2DArrToFile(File newLayer, int[][] level) {

		try {
			PrintWriter pw = new PrintWriter(newLayer);
			for (int i = 0; i < level.length; i++) {
				for (int j = 0; j < level[i].length; j++) {
					pw.print(level[i][j] + " ");
				}
				pw.println();
			}

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// converting the file data to an array
	public static int[][] GetLayerData(String name, int[][] sizeLevel) {

		File layerFile = new File("res/" + name + ".txt");

		if (layerFile.exists()) {
			return ReadFromFile(layerFile, sizeLevel.length, sizeLevel[0].length);
		} else {
			System.out.println("File " + name + " doesn't exist");
			return null;
		}
	}

	// reading the layer data from the file
	private static int[][] ReadFromFile(File layerFile, int ySize, int xSize) {

		int[][] result = new int[ySize][xSize];

		try {
			Scanner sc = new Scanner(layerFile);

			for (int i = 0; i < result.length; i++)
				for (int j = 0; j < result[i].length; j++) {
					result[i][j] = sc.nextInt();
				}

			sc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// saving the layer data in a file
	private static void SaveLayer(String name, int[][] level) {
		
		File layer = new File("res/" + name + ".txt");
		
		if(layer.exists()) {
			Write2DArrToFile(layer, level);
		}else {
			System.out.println("File " + name + " doesn't exist");
			return;
		}
	}
}
