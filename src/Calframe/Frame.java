package Calframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Frame extends JFrame/* implements ActionListener*/   {
	
	protected JButton[] button;
	protected JTextField Field;
	protected JPanel panel;
	protected JPanel Textpanel;
	protected String[] labels = {"7","8","9","C","4","5","6","*","1","2","3","-" ,"0","/","+","=","enter"," "," "," "," " };
	
	protected double result = 0;
	protected String operator = "=";
	protected boolean startOfNumber = true;
	//======성민 : 기본 GUI	
	public Frame()
	{
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculator");
		//TextBlistener
		
		JTextField Field = new JTextField(35);
		Field.setText("0");
		Field.setEnabled(false);
	
	
		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,4,3,3));
		button = new JButton[25];
		
		int i =0;
		for (int r= 0; r<4; r++)
		{
			for (int c = 0; c<5; c++)
			{
				button[i] = new JButton(labels[i]);
				panel.add(button[i]);
				//button[i].addActionListener();
				i++;
			}
			
			
		}
		
				
		add(Field,BorderLayout.NORTH);   
		add(panel,BorderLayout.CENTER);
		
		
		
		setVisible(true);
		pack();
		
	}
  //===까지 GUI
	//======성민 : 더하기 나누기
	private void calculate(double n)
	{
		if(operator.equals("+") )
			result += n;
		else if (operator.equals("-"))
			result -= n;
		else if (operator.equals("*"))
			result /= n;
		else if (operator.equals("*"))
			result = n;
	
		Field.setText(" " + result);
	}
	
//====까지 사칙연산 구현
	public static void main(String args[]){
		
		Frame s = new Frame();
	}

	
}
