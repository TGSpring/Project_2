package project_2;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class project_2 {
	
	//ArrayList made here
	private static List<Poly>numList = new ArrayList<>();
	
	//Main Method and create file chooser object
	public static void main(String[] args) {
		JFileChooser reader = new JFileChooser();
		reader.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	reader.setCurrentDirectory(null);
	int input = reader.showOpenDialog(null);
	
	//Populates array here
	for (int i = 0; i < ;i++ )
	{
		
	}
	if(input == JFileChooser.APPROVE_OPTION)
	{
			System.out.println("This shit sucks" + reader.getSelectedFile());
		}
	}
}
