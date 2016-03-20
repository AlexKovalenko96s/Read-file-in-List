package ua.kas.readFile;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NotMain {

	JFrame f = new JFrame();
	File file = new File("file");
	JTextField t1 = new JTextField(7);
	JTextField t2 = new JTextField(7);
	JTextField t3 = new JTextField(7);
	JButton b = new JButton("GO!");
	String line1 = "";
	String line2 = "";
	String line3 = "";
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel(new FlowLayout());
	DefaultListModel dlm = new DefaultListModel();
	JList jl = new JList(dlm);
	JScrollPane sp = new JScrollPane(jl);
	String resultStr;

	NotMain() {
		
		f.setLayout(new FlowLayout());

//		p1.add(t1);
//		p1.add(t2);
//		p1.add(t3);
//		p1.add(b);
		
		p2.add(sp);
		p2.add(b);
		
//		f.add(p1);
		f.add(p2);
	}

	public void work() throws IOException{
		
		
		sp.setPreferredSize(new Dimension(300,150));
		file.createNewFile();
		
		b.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					while((resultStr = br.readLine()) != null){
						
					
						t1.setText(resultStr.substring(resultStr.indexOf('.') + 1,resultStr.indexOf(',')));
						t2.setText(resultStr.substring(resultStr.indexOf(',') + 1,resultStr.indexOf('!')));
						t3.setText(resultStr.substring(resultStr.indexOf('!') + 1,resultStr.indexOf('?')));
					
						dlm.addElement(t1.getText());
						dlm.addElement(t2.getText());
						dlm.addElement(t3.getText());
					
					}
					
					fr.close();
					br.close();
				
					
				} catch (IOException e1) {JOptionPane.showMessageDialog(null, "File not found");}	
			}
		});
	}
}
