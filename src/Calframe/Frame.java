package Calframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame   {
	
	protected JButton[] button;
	protected JTextField NorhtField,CenterField;
	protected JPanel panel;
	protected JPanel Textpanel;
	protected String[] labels = {"7","8","9","C","4","5","6","*","1","2","3","-" ,"0","/","+","=","enter"," "," "," "," " };
	public Frame()
	{
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculator");
		//TextBlistener
		
		JTextField NorthField = new JTextField(35);
		NorthField.setText("0");
		NorthField.setEnabled(false);
		JTextField CenterField = new JTextField(35);
		CenterField.setText("0");
		CenterField.setEnabled(false);
	
		
		
		panel = new JPanel();
		Textpanel = new JPanel();
		panel.setLayout(new GridLayout(0,4,3,3));
		button = new JButton[25];
		
		int i =0;
		for (int r= 0; r<4; r++)
		{
			for (int c = 0; c<5; c++)
			{
				button[i] = new JButton(labels[i]);
				panel.add(button[i]);
				i++;
			}
			
			
		}
		
		Textpanel.setLayout(new BorderLayout());    		// 레이아웃 설정.
		Textpanel.add(BorderLayout.NORTH,NorthField);   // 패널에 텍스트필드를 두개 붙임.
		Textpanel.add(BorderLayout.CENTER,CenterField);
		
		add(BorderLayout.NORTH,Textpanel); 
		add(BorderLayout.CENTER,panel);
		
		
		
		setVisible(true);
		pack();
		
	}
	
	protected class Buttonlistener implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button)
		{
			
		}
	}
	}
	public static void main(String args[])
	{
		Frame s = new Frame();
	}
	
}
