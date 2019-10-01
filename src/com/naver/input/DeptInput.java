package com.naver.input;

import java.util.Scanner;

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

}
