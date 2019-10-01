package com.naver.Scott;

import java.sql.Connection;
import java.util.ArrayList;

import com.naver.control.DeptController;
import com.naver.control.EmpController;
import com.naver.dept.DeptDAO;
import com.naver.emp.EmpDAO;
import com.naver.emp.EmpDTO;
import com.naver.input.EmpInput;
import com.naver.util.DBConnector;
import com.naver.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {

		EmpDAO empDAO = new EmpDAO();
		EmpInput empInput = new EmpInput();
		EmpView empView = new EmpView();
		
		//1. 한명출력
		//int empno = empInput.empnoInput(); //사원번호 받기
		//EmpDTO empDTO = empDAO.getSelectOne(empno); //사원번호 보내서 테이블에서 값 찾기
		//empView.view(empDTO); //출력
		
		//2. 전체출력
		//ArrayList<EmpDTO> ar = empDAO.getSelectAll();
		//if(ar.size() !=0) {
		//	empView.view(ar);			
		//} else {
			
		//}

		//EmpController ec = new EmpController();
		//ec.start();
		
		//------------
		
		DeptController dc = new DeptController();
		dc.start();
		
		
		
		
		
	}
}
