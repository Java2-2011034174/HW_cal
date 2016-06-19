package Calframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//소스만 입력하고 Ctrl+Shift+O를 누른다. 
//======= 성민 구현 부분 - GUI
public class Frame extends JFrame implements ActionListener {

	private JPanel panel;
	private JTextField field;
	private JButton[] button;
	private String[] labels = { "7","8","9","C","4","5","6","*","1","2","3","-" ,"0","/","+","=",};
//======= 성민 구현 부분 - GUI
	
	
//=======준보 구현 부분 - 기능
	private double result = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	//=======준보 구현 부분 - 기능
	
	//======= 성민 구현 부분 - GUI
	public Frame() {
		field = new JTextField(35);
		panel = new JPanel();
		field.setText("0.0");


		panel.setLayout(new GridLayout(0, 4, 3, 3));
		button = new JButton[25];
		int i = 0;
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				button[i] = new JButton(labels[i]);
	
				panel.add(button[i]);
				button[i].addActionListener(this);
				i++;
			}
		}
		add(field, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}
	//======= 성민 구현 부분 - GUI	
	
//======준모 구현 부분 - 기능
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.charAt(0) == 'C') {
			startOfNumber = true;
			result = 0;
			operator = "=";
			field.setText("0.0");
		} else if (command.charAt(0) >= '0' && command.charAt(0) <= '9') 
		{
			if (startOfNumber == true)
				field.setText(command);
			else
				field.setText(field.getText() + command);
			startOfNumber = false;
		} else {
			if (startOfNumber) {
				if (command.equals("-")) {
					field.setText(command);
					startOfNumber = false;
				} else
					operator = command;
			} else {
				double x = Double.parseDouble(field.getText());
				calculate(x);
				operator = command;
				startOfNumber = true;
			}
		}
	}
	//======준모 구현 부분 - 기능
	
	//======= 성민 구현 부분 - 계산
	private void calculate(double n) {
		if (operator.equals("+"))
			result += n;
		else if (operator.equals("-"))
			result -= n;
		else if (operator.equals("*"))
			result *= n;
		else if (operator.equals("/"))
			result /= n;
		else if (operator.equals("="))
			result = n;
		field.setText("" + result);
	}
	//======= 성민 구현 부분 - 계산
	public static void main(String args[]) {
		Frame s = new Frame();
	}
}
