package com.naver.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.emp.EmpDAO;
import com.naver.emp.EmpDTO;
import com.naver.input.EmpInput;
import com.naver.view.EmpView;

public class EmpController {
	private Scanner sc;

	public EmpController() {
		sc=new Scanner(System.in);
		// TODO Auto-generated constructor stub
	}

	public void start() { //실행되면
		/*
		 * 1. 사원전체정보
		 * 2. 사원검색출력
		 * 3. 종료
		 */
		EmpDAO empDAO = new EmpDAO();
		EmpInput empInput = new EmpInput();
		EmpView empView = new EmpView();
		
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();

		boolean check = true;
		while(check) {
			System.out.println("1. 사원전체정보");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 사원정보추가");
			System.out.println("4. 사원정보삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();
			
			
			
			switch(num){
			case 1:
				ar = empDAO.getSelectAll();
				if(ar.size() !=0) {
					empView.view(ar);
				} else {
					break;
				}
				
				break;
				
			case 2:
				int empno = empInput.empnoInput();
				EmpDTO e = empDAO.getSelectOne(empno);
				if(e!=null) {
					empView.view(e);					
				} else {
					empView.view("없는 사원입니다.");
				}
				break;
				
			case 3:
				EmpDTO empDTO = empInput.insert();
				int result = empDAO.empInsert(empDTO);
				String s = "추가 실패";
				
				if(result>0) {
					s = "추가 성공";
					empView.view(empDTO);
				}
				
				empView.view(s);
				
				break;	
				
			case 4:
				empno = empInput.empnoInput();
				result = empDAO.delete(empno);
				s = "삭제 실패";
				if(result>0) {
					s="삭제성공";
				}
				empView.view(s);
				
				break;
				
			default :
				check=!check;
				
				
			}
			
		}




	}
}
