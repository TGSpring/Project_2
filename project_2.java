package project_2;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class project_2 {
	
	//ArrayList made here
	private static List<Poly>numberList = new ArrayList<>();
	
	//Main Method and create file chooser object
	public static ArrayList<String> main(String[] args) 
	{
		ArrayList<String>polyList = new ArrayList<>();
		JFileChooser reader = new JFileChooser();
		reader.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	reader.setCurrentDirectory(null);
	int input = reader.showOpenDialog(null);
	if (input == JFileChooser.APPROVE_OPTION)
	{
	File file = reader.getSelectedFile();
	try
	{
		Scanner scan = new Scanner(file);
		if(file.isFile())
		{
			while (scan.hasNextLine())
			{
				String input1 = scan.nextLine();
				polyList.add(input1);
			}
			}
		}
		catch (NoSuchElementException nse)
		{
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "wrong");
		}
	catch(FileNotFoundException fne)
	{
		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "idiot");
	}
	}
	

	return polyList;
	
	}
	}