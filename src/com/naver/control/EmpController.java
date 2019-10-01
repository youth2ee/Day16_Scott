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

		System.out.println("1. 사원전체정보");
		System.out.println("2. 사원검색출력");
		System.out.println("3. 종료");
		int num = sc.nextInt();

		EmpDAO empDAO = new EmpDAO();
		EmpInput empInput = new EmpInput();
		EmpView empView = new EmpView();

		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();


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
			empView.view(e);
			break;

		case 3:
			break;	
		}




	}
}
