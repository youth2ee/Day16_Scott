package com.naver.view;

import java.util.ArrayList;

import com.naver.dept.DeptDTO;

public class DeptView {
	
	public void view(DeptDTO deptDTO) {
		System.out.println("deptno:"+deptDTO.getDeptno());
		System.out.println("dname:"+deptDTO.getDname());
		System.out.println("loc:"+deptDTO.getLoc());
	
	}
	
	public void view(ArrayList<DeptDTO> ar) {
		for(int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i).getDeptno());
			System.out.println(ar.get(i).getDname());
			System.out.println(ar.get(i).getLoc());
			System.out.println("===================");
			
		}
		
	}

}
