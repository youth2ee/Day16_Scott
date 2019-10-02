package com.naver.view;

import java.util.List;

import com.naver.salgrade.SalDTO;

public class SalView {

	public void view(String str) {
		System.out.println(str);		
	}//view(String)

	public void view(SalDTO salDTO) {
		System.out.println("=================");
		System.out.println("Grade : "+salDTO.getGrade());
		System.out.println("Losal : "+salDTO.getLosal());
		System.out.println("Hisal : "+salDTO.getHisal());
	}//view(SalDTO)

	public void view(List<SalDTO> ar) {
		for(SalDTO nSal : ar) {
			this.view(nSal);
		}
	}//view(List)

}
