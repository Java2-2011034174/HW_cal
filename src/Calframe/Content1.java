package Calframe;

import java.util.Scanner;

public class Content1 {

	public static void main(String[] args) {
		String s = new String();
		double a, b;
		double result = 0;
		
		Scanner scan = new Scanner(System.in);
		Scanner string = new Scanner(System.in);
		/*왜 String type와 int type는 Scanner를 같이 못쓸까? */
		
	/*	세 문자를 입력받는다		*/
		System.out.print("첫번째 숫자 :");
		a = scan.nextDouble();
		System.out.print("문자 :");
		s = string.next();
		System.out.print("두번째 숫자 :");
		b = scan.nextDouble();

	/* if-else 문으로 문자의 종류를 검사한다	*/
		if(s.equals("+"))		//	위치가 같은 게 아니라 내용이 같은 것을 대상으로 해야 하기 때문에 ==가 아닌 equals를 씀.
			result = a+b;
		else if(s.equals("-"))
			result = (a+(-b));
		else if(s.equals("*"))
			result = (a*b);
		else if(s.equals("/"))	{
			if(b == 0)		//분모가 0일 경우
				System.out.println("[ERROR] 분모가 0이 됩니다.");
			else
				result = (a / b);
		}
		System.out.println("=" + result);
	}

}