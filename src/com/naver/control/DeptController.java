package com.naver.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.dept.DeptDAO;
import com.naver.dept.DeptDTO;
import com.naver.input.DeptInput;
import com.naver.view.DeptView;

public class DeptController {
	
	private Scanner sc;
	
	public DeptController() {
		sc = new Scanner(System.in);
	}

	public void start() {
		
		System.out.println("1. 부서별 전체출력");
		System.out.println("2. 부서별 출력");
		System.out.println("3. 종료");
		int num = sc.nextInt();
		
		DeptDTO deptDTO = new DeptDTO();
		DeptDAO deptDAO = new DeptDAO();
		DeptInput deptInput = new DeptInput();
		DeptView deptView = new DeptView();
		
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		
		switch(num) {
		
		case 1:
			ar = deptDAO.getSelectAll();
			if(ar.size() !=0) {
				deptView.view(ar);
			} else {
				break;
			}
			
			break;
			
		case 2:
			int deptno = deptInput.deptnoInput();
			DeptDTO e = deptDAO.getSelectOne(deptno);
			deptView.view(e);
			break;
			
		case 3:
			
		
		}
		
		
	}
	
}
