package ua.kas.readFile;

import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String [] args) throws IOException{
		
		NotMain nm = new NotMain();
		
		nm.work();
		
		nm.f.setSize(300, 300);
		nm.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nm.f.setResizable(false);
		nm.f.pack();
		nm.f.setLocationRelativeTo(null);
		nm.f.setVisible(true);
	}
}
