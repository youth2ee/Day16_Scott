package com.naver.input;

import java.sql.Date;
import java.util.Scanner;

import com.naver.emp.EmpDTO;

public class EmpInput {
	//입력전문
	private Scanner sc; 

	
	public EmpInput() {
	sc = new Scanner(System.in);
	}
	
	public String enameInput() {
		//한글자 받아서 찾기
		System.out.println("찾으려는 글자를 입력하세요");
		String str = sc.next().toUpperCase();
		
		return str;
		
	}
	
	public int empnoInput() {
		//사원번호입력헤서 메인으로 보내기
		
		System.out.println("사원번호를 입력하세요");
		int empno = sc.nextInt();
		
		return empno;
		
	}
	
	public EmpDTO insert() {
		EmpDTO empDTO = new EmpDTO();
		
		System.out.println("사원번호 입력");
		empDTO.setEmpno(sc.nextInt());
		System.out.println("사원이름 입력");
		empDTO.setEname(sc.next().toUpperCase());
		System.out.println("사원직업 입력");
		empDTO.setJob(sc.next().toUpperCase());
		System.out.println("관리자번호 입력");
		empDTO.setMgr(sc.nextInt());
		System.out.println("월급 입력");
		empDTO.setSal(sc.nextInt());
		System.out.println("커미션 입력");
		empDTO.setComm(sc.nextInt());
		System.out.println("부서번호 입력");
		empDTO.setDeptno(sc.nextInt());
		
		return empDTO;
		
	}

}
