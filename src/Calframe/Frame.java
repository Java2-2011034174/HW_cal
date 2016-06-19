package Calframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener  {
	
	protected JButton[] button;
	protected JTextField field;
	protected JPanel panel;
	protected String[] labels = {"7","8","9","C","4","5","6","*","1","2","3","-" ,"0","/","+","=" };
	
	// ===================기능구현부분 준모3==================
	private double result = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	// ===================기능구현부분 준모3==================
	
	public Frame()
	{

		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculator");
		
		// ===================기능구현부분 준모3==================
		JTextField field = new JTextField(35);
		field.setText("0.0");
		field.setEnabled(false);
		// ===================기능구현부분 준모3==================
		
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,4,3,3));
		button = new JButton[25];
		
		int i =0;
		for (int r= 0; r<4; r++)
		{
			for (int c = 0; c<4; c++)
			{
				button[i] = new JButton(labels[i]);
				panel.add(button[i]);
				i++;
			}
			
			
		}
		
		add(field,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setVisible(true);
		pack();
		
	}
	
	// ======================기능 구현 부분 ===============
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(command.charAt(0) == 'C'){
			startOfNumber = true;
			result = 0;
			operator = "=";
			field.setText(0);
		}
		else if (command.charAt(0) >= '0' && command.charAt(0) <= '9'||
				command.equals(".")){
			if(startOfNumber == true)
				field.setText(command);
			else
				field.setText(field.getText() + command);
			startOfNumber = false;
		}
		else{
			if(startOfNumber){
				if(command.equals("-")){
					field.setText(command);
					startOfNumber = false;
				}
				else
					operator = command;
			}
			else{
				double x = Double.parseDouble(field.getText());
				Calculate(x);
				operator = command;
				startOfNumber = true;
			
			}
		}
		
	}
	// ================기능구현부분==================================
	
	public static void main(String args[])
	{
		Frame s = new Frame();
	}
	
}
