package com.naver.input;

import java.util.Scanner;

import com.naver.dept.DeptDAO;
import com.naver.dept.DeptDTO;

public class DeptInput {
	private Scanner sc;
	
	public DeptInput() {
		
		sc = new Scanner(System.in);
	}
	
	public int deptnoInput() {
		System.out.println("부서번호를 입력하세요.");
		int dentno = sc.nextInt();
		
		return dentno;
	}
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		
		System.out.println("부서번호입력");
		int deptno = sc.nextInt();
		deptDTO.setDeptno(deptno);
		System.out.println("부서이름입력");
		String dname = sc.next().toUpperCase();
		deptDTO.setDname(dname);
		System.out.println("부서지역이름");
		deptDTO.setLoc(sc.next().toUpperCase());
		
		return deptDTO;
	}

	
	
}
