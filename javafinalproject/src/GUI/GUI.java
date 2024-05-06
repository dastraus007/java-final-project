package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import main.*;
import main.Package;
import main.main;

@SuppressWarnings("unused")
public class GUI extends JFrame{
	
	/**
	 */
	 
	private static final long serialVersionUID = 1L;
	//the text fills
	private JTextField nameFile;
	private JTextField Angel;
	private JTextField inetsity;
	private JTextField R;
	private JTextField G;
	private JTextField B;
	private JTextField name;
	
	//the button
	private JButton shadowTest;
	private JButton RicursiveTest;
	private JButton HorseTest;
	private JButton EXIT;
	
	//the plans
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel titel;
	
	//the check box
	private JRadioButton directionalLight;
	private JRadioButton pointLight;
	private JRadioButton spotlLight;
	//the check box
	ButtonGroup group;
	
	//Package exPackage;

	//private JMenuBar meuuBar;
	//private Menu menu;
	/*************************************************
	 * FUNCTION
	 * GUI
	 * PARAMETERS
	 * ---
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the app
	 * SEE ALSO
	 * 
	 **************************************************/
	public GUI() {
		super("GUI");//func that create the app
		sendDisplay();
		sendButtond();
		sendLebel();
		sendCheckBox();
		sendI(this);
	}

	

	/*************************************************
	 * FUNCTION
	 * sendCheckBox
	 * PARAMETERS
	 *---
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the check box
	 * SEE ALSO
	 * 
	 **************************************************/
	private void sendCheckBox() {
	//create and add the check box
		directionalLight = new JRadioButton("Directional Light");
		directionalLight.setBounds(30, 120, 200 ,  21);
		directionalLight.setFont(new Font("arial" , Font.BOLD , 20));
		directionalLight.setSelected(true);
		
		add(directionalLight);
		
		//create and add the check box
		pointLight = new JRadioButton("Point Light");
		pointLight.setBounds(30, 170, 150 ,  21);
		pointLight.setFont(new Font("arial" , Font.BOLD , 20));
		
		add(pointLight);
		//create and add the check box
		spotlLight = new JRadioButton("Spot Light");
		spotlLight.setBounds(30, 220, 150 ,  21);
		spotlLight.setFont(new Font("arial" , Font.BOLD , 20));
		
		add(spotlLight);
		group=new ButtonGroup();
		group.add(directionalLight);
		group.add(pointLight);
		group.add(spotlLight);
		
	}
	/*************************************************
	 * FUNCTION
	 * sendLebel
	 * PARAMETERS
	 *---
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the labels
	 * SEE ALSO
	 * 
	 **************************************************/
	private void sendLebel() {
		//create and add the labels
		label1 = new JLabel("Name File");
		label1.setBounds(320, 340 , 180, 20);
		label1.setFont(new Font("arial" , Font.BOLD , 20));
		
		add(label1);
		//create and add the labels
		label2 = new JLabel("R");
		label2.setBounds(250, 245, 40, 20);
		label2.setFont(new Font("arial" , Font.BOLD , 20));
		

		label2.setText("R");
		add(label2);
		//create and add the labels
		label3 = new JLabel("G");
		label3.setBounds(305, 245, 40, 20);
		
		label3.setFont(new Font("arial" , Font.BOLD , 20));

		add(label3);
		//create and add the labels
		label4 = new JLabel("B");
		label4.setBounds(365, 245, 40, 20);
		label4.setFont(new Font("arial" , Font.BOLD , 20));
		add(label4);
		//create and add the labels
		label5 = new JLabel("Angle (0 - 180)");
		label5.setBounds(250, 120, 150, 20);
		label5.setFont(new Font("arial" , Font.BOLD , 20));
		add(label5);
		//create and add the labels
		label6 = new JLabel("Itensity (0-100)");
		label6.setBounds(250, 170, 150, 20);
		label6.setFont(new Font("arial" , Font.BOLD , 20));
		add(label6);
		//create and add the labels
		titel = new JLabel("Picture Builder");
		titel.setBounds(180, 30, 300, 80);
		titel.setFont(new  Font("arial" , Font.BOLD , 35));

		add(titel);

	}
	/*************************************************
	 * FUNCTION
	 * sendButtond
	 * PARAMETERS
	 *---
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the Buttons
	 * SEE ALSO
	 * 
	 **************************************************/
	private void sendButtond() {
		//create and add the labels
		shadowTest = new JButton("Shadow Test");
		shadowTest.setBounds(20, 270, 140, 70);
		shadowTest.setBackground(Color.LIGHT_GRAY);
		shadowTest.addActionListener(new ActionListener(){//if some push the button
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//do the action
				try {
					int type = 0;
					int angel;
					int inesity = 0;
					int r , g , b;
					new Color(0 , 0 , 0);
					if (directionalLight.isSelected()) type = 0;//get the choose
					else if(pointLight.isSelected()) type = 1;
					else if(spotlLight.isSelected()) type = 2;
					
					angel = Integer.parseInt( Angel.getText());//get the value
					inesity =  Integer.parseInt( inetsity.getText());
					
					
					r = Integer.parseInt(R.getText());//get the color
					g = Integer.parseInt(G.getText()); 
					b = Integer.parseInt(B.getText());
					if(type < 0 || type > 2 || angel > 180 || angel < 0 || inesity < 0 || inesity > 100 || r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255)
						throw  new Exception("illegal value/s  entered!");
					
					//send to the main to create the scene
				main. createPicture(type, angel, inesity,new Color(r , g , b), nameFile.getText());
					
				} catch (Exception e2) {
					//custom title, error icon
					JOptionPane.showMessageDialog(new Frame(),//create error msege
					    "illegal value/s  entered!",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		add(shadowTest);
		
		RicursiveTest = new JButton("Ricursive Test");
		RicursiveTest.setBounds(20, 360, 140, 70);
		RicursiveTest.setBackground(Color.LIGHT_GRAY);
		RicursiveTest.addActionListener(new ActionListener(){//if some push the button
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//do the action
				try {
					int type = 0;
					int angel;
					int inesity = 0;
					int r , g , b;
					new Color(0 , 0 , 0);
					//String nameFile = "Default";
					if (directionalLight.isSelected()) type = 0;//get the choose
					else if(pointLight.isSelected()) type = 1;
					else if(spotlLight.isSelected()) type = 2;
					
					angel = Integer.parseInt( Angel.getText());//get the value
					inesity =  Integer.parseInt( inetsity.getText());
					
					
					r = Integer.parseInt(R.getText());//get the color
					g = Integer.parseInt(G.getText()); 
					b = Integer.parseInt(B.getText());
					if(type < 0 || type > 2 || angel > 180 || angel < 0 || inesity < 0 || inesity > 100 || r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255)
						throw  new Exception("illegal value/s  entered!");
					
					//send to the main to create the scene
				main. RecursiveTest(type, angel, inesity,new Color(r , g , b), nameFile.getText());
				//System.exit(0);
					
				} catch (Exception e2) {
					//custom title, error icon
					JOptionPane.showMessageDialog(new Frame(),//create error msege
					    "illegal value/s  entered!",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
	add(RicursiveTest);
		HorseTest = new JButton("Horse Test");
		HorseTest.setBackground(Color.LIGHT_GRAY);
		HorseTest.setBounds(20, 450 , 140, 70);
		HorseTest.setFont( new Font("arial" , Font.BOLD , 12));
		HorseTest.addActionListener(new ActionListener(){//if some push the button
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//do the action
					main. Horse();
					
							
			}
			
		});
		add(HorseTest);
		//create and add the exit button
		EXIT = new JButton("EXIT");
		//Border tb = BorderFactory.createLineBorder(Color.YELLOW , 50);
		EXIT.setBackground(Color.LIGHT_GRAY);
		EXIT.setBounds(380, 440 , 130, 65);
		EXIT.setFont( new Font("arial" , Font.BOLD , 12));
		EXIT.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//do the action
				System.exit(0);
			}
		});
		add(EXIT);
		
	}
	/*************************************************
	 * FUNCTION
	 * sendDisplay
	 * PARAMETERS
	 *---
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the Display
	 * SEE ALSO
	 * 
	 **************************************************/
	private void sendDisplay() {
		
		nameFile = new JTextField("Enter Name");//create and add the exit Display
		nameFile.setBounds(290, 370 , 170, 20);
		//nameFile.setComponentOrientation(/*ComponentOrientation.RIGHT_TO_LEFT);*/
		nameFile.setFont(new Font("arial" , Font.PLAIN , 12));
		
		add(nameFile);
		//create and add the exit Display
		Angel = new JTextField("0");
		Angel.setBounds(400, 122, 150, 20);
		//nameFile.setEnabled(false);
		Angel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Angel.setFont(new Font("arial" , Font.PLAIN , 12));
		
		add(Angel);
		//create and add the exit Display
		inetsity = new JTextField("0");
		inetsity.setBounds(400, 172, 150, 20);
		//nameFile.setEnabled(false);
		inetsity.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		inetsity.setFont(new Font("arial" , Font.PLAIN , 12));
		
		add(inetsity);
		//create and add the exit Display
		R = new JTextField("0");
		
		R.setBounds(230, 220, 50, 20);
		//nameFile.setEnabled(false);
		R.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		R.setFont(new Font("arial" , Font.PLAIN , 12));
		
		add(R);
		//create and add the exit Display
		G = new JTextField("0");
		G.setBounds(290, 220, 50, 20);
		//nameFile.setEnabled(false);
		G.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		G.setFont(new Font("arial" , Font.PLAIN , 12));
		
		add(G);
		//create and add the exit Display
		B = new JTextField("0");
		B.setBounds(350, 220, 50, 20);
		//nameFile.setEnabled(false);
		B.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		B.setFont(new Font("arial" , Font.PLAIN , 12));
		
		add(B);
	}
	/*************************************************
	 * FUNCTION
	 * sendI
	 * PARAMETERS
	 *---
	 * RETURN VALUE
	 * ---. 
	 * MEANING
	 * create the check box
	 * SEE ALSO
	 * 
	 **************************************************/
	private void sendI(GUI gui) {
		//create the app
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closing with close
		gui.setSize(570, 570);
		gui.setResizable(false);
		gui.setLayout(null);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
		setBackground(new Color(211, 211, 211));
		
		
	}

}



