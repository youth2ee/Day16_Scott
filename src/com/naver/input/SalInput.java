package com.naver.input;

import java.util.Scanner;

import com.naver.bonus.BonusDTO;
import com.naver.salgrade.SalDTO;

import oracle.net.aso.r;

public class SalInput {
	private Scanner sc;

	public SalInput() {
		sc = new Scanner(System.in);
	}

	public int gradeInput() {
		System.out.println("등급을 입력하세요");
		int grade = sc.nextInt();

		return grade;
	} //enameInput


	public SalDTO salInsert() {
		SalDTO salDTO = new SalDTO();

		System.out.println("등급 입력(grade)");
		salDTO.setGrade(sc.nextInt());
		System.out.println("최저임금 입력 (losal)");
		salDTO.setLosal(sc.nextInt());
		System.out.println("최고임금 입력 (hisal)");
		salDTO.setHisal(sc.nextInt());

		return salDTO;
	}//salInput
}
