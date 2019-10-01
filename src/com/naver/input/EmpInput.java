package com.naver.input;

import java.util.Scanner;

public class EmpInput {
	//입력전문
	
	private Scanner sc; 
	
	public EmpInput() {
	sc = new Scanner(System.in);
	}
	
	public int empnoInput() {
		//사원번호입력헤서 메인으로 보내기
		
		System.out.println("사원번호를 입력하세요");
		int empno = sc.nextInt();
		
		return empno;
		
	}

}
