package Calframe;

import java.util.Scanner;

public class Content1 {

	public static void main(String[] args) {
		String s = new String();
		double a, b;
		double result = 0;
		
		Scanner scan = new Scanner(System.in);
		Scanner string = new Scanner(System.in);
		/*�� String type�� int type�� Scanner�� ���� ������? */
		
	/*	�� ���ڸ� �Է¹޴´�		*/
		System.out.print("ù��° ���� :");
		a = scan.nextDouble();
		System.out.print("���� :");
		s = string.next();
		System.out.print("�ι�° ���� :");
		b = scan.nextDouble();

	/* if-else ������ ������ ������ �˻��Ѵ�	*/
		if(s.equals("+"))		//	��ġ�� ���� �� �ƴ϶� ������ ���� ���� ������� �ؾ� �ϱ� ������ ==�� �ƴ� equals�� ��.
			result = a+b;
		else if(s.equals("-"))
			result = (a+(-b));
		else if(s.equals("*"))
			result = (a*b);
		else if(s.equals("/"))	{
			if(b == 0)		//�и� 0�� ���
				System.out.println("[ERROR] �и� 0�� �˴ϴ�.");
			else
				result = (a / b);
		}
		System.out.println("=" + result);
	}

}