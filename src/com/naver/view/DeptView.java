package com.naver.view;

import java.util.ArrayList;
import java.util.List;

import com.naver.dept.DeptDTO;
import com.naver.emp.EmpDTO;

public class DeptView {

	public void view(String str) {
		System.out.println(str);
		
	}
	
	
	public void view(DeptDTO deptDTO) {
		System.out.println("DeptNo:"+deptDTO.getDeptno());
		System.out.println("Dname:"+deptDTO.getDname());
		System.out.println("Loc:"+deptDTO.getLoc());
		System.out.println("==================");
	}
	
	

	//public void view(ArrayList<DeptDTO> ar) {
	public void view(List<DeptDTO> ar) {
		
		for(DeptDTO nDept : ar) {
			this.view(nDept);
		}
			
		/*
		for(int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i).getDeptno());
			System.out.println(ar.get(i).getDname());
			System.out.println(ar.get(i).getLoc());
			System.out.println("===================");
		}
		*/
		
	}

	
	
}
