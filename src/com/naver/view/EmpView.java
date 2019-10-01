package com.naver.view;

import java.util.ArrayList;

import com.naver.emp.EmpDTO;

public class EmpView { //emp 테이블만 출력한다.
	
	public void view(EmpDTO empDTO) {
		System.out.println("empno:"+empDTO.getEmpno());
		System.out.println("ename:"+empDTO.getEname());
		System.out.println("job:"+empDTO.getJob());
		System.out.println("mgr:"+empDTO.getMgr());
		System.out.println("hiredate:"+empDTO.getHiredate());
		System.out.println("sal:"+empDTO.getSal());
		System.out.println("comm:"+empDTO.getComm());
		System.out.println("deptno:"+empDTO.getDeptno());
		
		//for(EmpDTO empDTO:ar) {
			//this.view(empDTO);
		//}

	}
	
	public void view(ArrayList<EmpDTO> ar) {
		for(int i=0;i<ar.size();i++) {
			System.out.println("EmpNo:"+ar.get(i).getEmpno());
			System.out.println("Ename:"+ar.get(i).getEname());
			System.out.println("Job:"+ar.get(i).getJob());
			System.out.println("Mgr:"+ar.get(i).getMgr());
			System.out.println("Hiredate:"+ar.get(i).getHiredate());
			System.out.println("Sal:"+ar.get(i).getSal());
			System.out.println("Comm:"+ar.get(i).getComm());
			System.out.println("Deptno:"+ar.get(i).getDeptno());
			System.out.println("=================================");
			
		}
		
		
	}
	


}
