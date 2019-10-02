package com.naver.Scott;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.naver.control.DeptController;
import com.naver.control.EmpController;
import com.naver.control.FrontController;
import com.naver.dept.DeptDAO;
import com.naver.dept.DeptDTO;
import com.naver.emp.EmpDAO;
import com.naver.emp.EmpDTO;
import com.naver.input.EmpInput;
import com.naver.util.DBConnector;
import com.naver.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {

		//EmpDAO empDAO = new EmpDAO();
		//EmpInput empInput = new EmpInput();
		//EmpView empView = new EmpView();
		
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
		//DeptDAO dao = new DeptDAO();
		//List<DeptDTO> ar = dao.getSelectAll();
		//list를 쓰는 이유 : 분업하기 위해서 필요. 
		//DeptDTO만드는애가 어떤 list쓸지 모르므로
		//list들의 부모형인  부모형클래스 List로 받는다. 
		//받기만 list로 받아도 된다.??
		
		
		//for(int i=0;i<ar.size();i++) {
		//	DeptDTO deptDTO = ar.get(i);
		//}
		
		
		//DeptController dc = new DeptController();
		//dc.start();
		
		FrontController fc = new FrontController();
		fc.start();
		
		/*
		DeptDAO deptDAO = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDeptno(12);
		deptDTO.setDname("BOOK");
		deptDTO.setLoc("PAJU");
		int result = deptDAO.deptInsert(deptDTO);
		if(result>0) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
		*/
		
		
		
		
	}
}
