package com.naver.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.dept.DeptDAO;
import com.naver.dept.DeptDTO;
import com.naver.input.DeptInput;
import com.naver.view.DeptView;

public class DeptController {

	private Scanner sc;
	private DeptDAO deptDAO;
	private DeptView deptView;
	private DeptInput deptInput;


	public DeptController() {
		sc = new Scanner(System.in);
		deptDAO = new DeptDAO();
		deptView = new DeptView();
		deptInput = new DeptInput();
	}

	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("1. 부서별 전체출력");
			System.out.println("2. 부서별 출력");
			System.out.println("3. 종료");
			int num = sc.nextInt();


			switch(num) {

			case 1:
				List<DeptDTO> ar = deptDAO.getSelectAll();
				if(ar.size()>0) {
					deptView.view(ar);
				} else {
					deptView.view("데이터가 없습니다.");
				}

				break;

			case 2:
				int deptno = deptInput.deptnoInput();
				DeptDTO e = deptDAO.getSelectOne(deptno);
				if(e!=null) {
					deptView.view(e);					
				} else {
					deptView.view("없는 부서번호 입니다.");
				}

				break;

			default :
				check=!check;

			}


		}


	}

}
