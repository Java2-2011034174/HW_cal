package Calframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends Frame implements ActionListener {

public void actionPerformed(ActionEvent e){
	String str=e.getActionCommand();  		// ���ڿ��� �̺�Ʈ�ҷ���
	String read;				// �ؽ�Ʈ�ʵ忡 �ִ� �ؽ�Ʈ �б�뵵
	
	try{	
		//�����ȣ�� �ƴ� �����̸� true �̴�.
		if(str!="/" && str!= "*"&& str!= "-"&& str!= "+"&& str!= "C"&& str!= "="){	
			textField.setText(first);  		// 0������� ���ڴ����ϱ����� �ʿ�.
			textField.getText();  			// ���� ���
			textfieldNorth.setText("");		// ������ �ؽ�Ʈ �ʱ�ȭ
			textfieldNorth.getText(); 		// ���
			
			read=textField.getText();  		// �ؽ�Ʈ�� �ִ°� �ҷ���.
			first=read+str;
			textField.setText(first);		// ���� ����
			textField.getText(); 			// ���� ���
		}// if
		
		
		
		//�����ȣ�� �������� true.
		if(str=="/" || str== "*"|| str== "-"|| str== "+"|| str== "="){
			textfieldNorth.setText(str); 				 // ������ ��ȣ ����
			textfieldNorth.getText();  					// ������ ��ȣ ���
			
			ee.add(Integer.parseInt(first));  // �����Ϸ��� �� �ϳ��� ArrayList�� ����
			first="";						// �ٽ� �����ϵ��� �ʱ�ȭ
			
			store.add(str); 			   // ������ ArrayList�� ����		
		}// if
		
		
		
		//�����ȣ "=" ����� ��������.
		if(str=="="){		
			int sum=0;
			sum=ee.get(0); 		// ���� ���۰��� �ް� ���� , 1(+2)(+3)(+4)=result �ʱⰪ�� �˸� 3���� "()" �������ָ� �ȴ�. 
			
			for(int a=0,h=1; a<ee.size(); a++,h++){   // ArrayList ũ�⸸ŭ �ݺ�
				int ve=store.size(); 				// ������ ���� Ƚ�� ����
				if(ve>0){							// ������ ���� ��� ����Ҷ����� �ݺ�.
					ve--;			
					//if�� �Ǵ� switch������ ����.
					if(store.get(a)=="+"){			// ������ + �϶�
						sum=sum+ee.get(h);  			// (+2) �ι�° ���ڿ� ����
					}else if(store.get(a)=="-"){	// �Ʒ����� �ݺ�..	
						sum=sum-ee.get(h);	
					}else if(store.get(a)=="*"){
						sum=sum*ee.get(h);
					}else if(store.get(a)=="/"){
						try{				
							sum=sum/ee.get(h);
						}catch(Exception exc){		// �������� 0���� ������ ���ܹ߻��Ѵ�.
							sum=0;  //�����߻��� 0���� ���.
						}
					}			
				}// if
			}// for
			result=sum+"";						//�� �����
			textField.setText(result);  		// ����� ����
			textField.getText(); 				// ������	
		}// if
		
		//��� �� �ʱ�ȭ ��Ű�� �ٽ� ����.
		if(str=="C"){
			first="";
			textField.setText("0"); 			 // �ؽ�Ʈâ ���� ����� 0���
			textField.getText();  			
			textfieldNorth.setText(""); 	// ������ �ؽ�Ʈâ �ʱ�ȭ
			textfieldNorth.getText(); 
			ee.clear();  					// ��� ��ҵ� ����
			store.clear();  				// ��� ��ҵ� ����
		}
		
	}catch(Exception ex){
		textField.setText("Error �ٽ��Է� CŬ��.");  // �ؽ�Ʈâ ���� ���� �����
		textField.getText(); 
	}

}// actionPerformed()

}
