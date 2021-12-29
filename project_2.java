package project_2;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * @author tyler
 *Project 2
 *11/18/21
 *This is the main class that creates the array and the file selector in order to read the input of the selected file and calls methods of
 *other classes to determine its sorting and if it is valid input.
 */
public class project_2 {

	// ArrayList made here
	private static List<Poly> numberList = new ArrayList<>();

	// Main method, calls method to do calling of other methods and print output.
	public static void main(String[] args) {
		driver();
	}

	// Main Method and create file chooser object
	public static ArrayList<String> InputFile() {
		ArrayList<String> fileList = new ArrayList<>();
		JFileChooser reader = new JFileChooser();
		reader.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		reader.setCurrentDirectory(null);
		int input = reader.showOpenDialog(null);
		if (input == JFileChooser.APPROVE_OPTION) {
			File file = reader.getSelectedFile();
			try {
				// Scans document, populates arraylist
				Scanner scan = new Scanner(file);
				if (file.isFile()) {
					while (scan.hasNextLine()) {
						java.lang.String input1 = scan.nextLine();
						fileList.add(input1);
					}
				}
				scan.close();
			}
			// checks for exceptions. Syntax and file location.
			catch (NoSuchElementException nse) {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "wrong syntax");
			} catch (FileNotFoundException fne) {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "wrong file");
			}
		}
		return fileList;
	}

	// Checks array to see if elements are in weak order, returns true unless found
	// false. Also my attempt at Lambda. I saw in the askProff
	// to take two polys as input, but I had issues so I just created another
	// instance by subtracting to the last element. Hope that is ok.
	public static boolean Weak(List<Poly> inList) {
		boolean WeakOrd = true;

		Poly last = inList.get(inList.size() - 1);
		for (int i = inList.size() - 2; i > 0; i--) {
			if (last.Expon(inList.get(i)) < 0) {
				WeakOrd = false;
			}
		}

		return WeakOrd;
	}

	// Creates object from Poly class, checks for exceptions, ordering, displays
	// output.
	public static void driver() {
		try {
			System.out.printf("Polynomials:" + "\n");
			ArrayList<String> a = InputFile();
			for (String ind : a) {
				Poly p = new Poly(ind);
				System.out.println(p);
				numberList.add(p);
			}
			System.out.printf("\n" + "Strong ordering: " + orderedList.checkSorted(numberList) + "\n"
					+ "Weak ordering: " + Weak(numberList));
		} catch (invalidPoly ex) {
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage());

		}

	}
}
