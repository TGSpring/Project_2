package project_2;

import java.util.*;
import javax.swing.*;
import java.io.*;

public class project_2 {
	
	//ArrayList made here
	private static List<Poly>numList = new ArrayList<>();
	
	//Main Method and create file chooser object
	public static void main(String[] args) {
		JFileChooser reader = new JFileChooser();
		reader.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	reader.setCurrentDirectory(null);
	int input = reader.showOpenDialog(null);
	
	if(input == JFileChooser.APPROVE_OPTION)
	{
		//if (reader.getSelectedFile().isDirectory()) {
			System.out.println("This shit sucks" + reader.getSelectedFile());
		}
	}
}

