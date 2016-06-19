package Calframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends Frame implements ActionListener {

public void actionPerformed(ActionEvent e){
	String str=e.getActionCommand();  		// 문자열로 이벤트불러옴
	String read;				// 텍스트필드에 있는 텍스트 읽기용도
	
	try{	
		//연산기호가 아닌 숫자이면 true 이다.
		if(str!="/" && str!= "*"&& str!= "-"&& str!= "+"&& str!= "C"&& str!= "="){	
			textField.setText(first);  		// 0을지우고 숫자누적하기위해 필요.
			textField.getText();  			// 누적 출력
			textfieldNorth.setText("");		// 연산자 텍스트 초기화
			textfieldNorth.getText(); 		// 출력
			
			read=textField.getText();  		// 텍스트에 있는값 불러옴.
			first=read+str;
			textField.setText(first);		// 누적 저장
			textField.getText(); 			// 누적 출력
		}// if
		
		
		
		//연산기호가 들어왔을때 true.
		if(str=="/" || str== "*"|| str== "-"|| str== "+"|| str== "="){
			textfieldNorth.setText(str); 				 // 연산자 기호 저장
			textfieldNorth.getText();  					// 연산자 기호 출력
			
			ee.add(Integer.parseInt(first));  // 연산하려는 값 하나씩 ArrayList에 저장
			first="";						// 다시 누적하도록 초기화
			
			store.add(str); 			   // 연산자 ArrayList에 저장		
		}// if
		
		
		
		//연산기호 "=" 결과값 눌렀을때.
		if(str=="="){		
			int sum=0;
			sum=ee.get(0); 		// 최초 시작값을 받고 시작 , 1(+2)(+3)(+4)=result 초기값만 알면 3번만 "()" 연산해주면 된다. 
			
			for(int a=0,h=1; a<ee.size(); a++,h++){   // ArrayList 크기만큼 반복
				int ve=store.size(); 				// 연산자 누적 횟수 저장
				if(ve>0){							// 연산자 누적 모두 사용할때까지 반복.
					ve--;			
					//if문 또는 switch문으로 가능.
					if(store.get(a)=="+"){			// 연산자 + 일때
						sum=sum+ee.get(h);  			// (+2) 두번째 숫자와 연산
					}else if(store.get(a)=="-"){	// 아래부터 반복..	
						sum=sum-ee.get(h);	
					}else if(store.get(a)=="*"){
						sum=sum*ee.get(h);
					}else if(store.get(a)=="/"){
						try{				
							sum=sum/ee.get(h);
						}catch(Exception exc){		// 나눗셈은 0으로 나눌때 예외발생한다.
							sum=0;  //에러발생시 0으로 출력.
						}
					}			
				}// if
			}// for
			result=sum+"";						//총 결과값
			textField.setText(result);  		// 결과값 저장
			textField.getText(); 				// 결과출력	
		}// if
		
		//모든 값 초기화 시키고 다시 연산.
		if(str=="C"){
			first="";
			textField.setText("0"); 			 // 텍스트창 내용 지우고 0출력
			textField.getText();  			
			textfieldNorth.setText(""); 	// 연산자 텍스트창 초기화
			textfieldNorth.getText(); 
			ee.clear();  					// 모든 요소들 제거
			store.clear();  				// 모든 요소들 제거
		}
		
	}catch(Exception ex){
		textField.setText("Error 다시입력 C클릭.");  // 텍스트창 내용 전부 지우기
		textField.getText(); 
	}

}// actionPerformed()

}
