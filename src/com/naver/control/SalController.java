package com.naver.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.naver.input.SalInput;
import com.naver.salgrade.SalDAO;
import com.naver.salgrade.SalDTO;
import com.naver.view.SalView;



public class SalController {
	private Scanner sc;
	private SalDAO salDAO;
	private SalDTO salDTO;
	private SalInput salInput;
	private SalView salView;
	private List<SalDTO> ar;



	public SalController() {
		sc = new Scanner(System.in);
		salDAO = new SalDAO();
		salDTO = new SalDTO();
		salInput = new SalInput();
		salView = new SalView();
		ar = new ArrayList<SalDTO>();
	}


	public void start() {
		boolean check = true;

		while (check) {
			System.out.println();
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. Grade로 검색");
			System.out.println("3. 등급 정보 추가");
			System.out.println("4. 등급 정보 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				ar = salDAO.getSelectList();
				salView.view(ar);
				break;

			case 2:
				select = salInput.gradeInput();
				salDTO = salDAO.getSelectOne(select);
				if (salDTO != null) {
					salView.view(salDTO);
				}else {
					salView.view("찾으시는 정보가 없습니다.");
				}
				break;

			case 3:
				salDTO = salInput.salInsert();
				select = salDAO.insert(salDTO);
				if (select > 0)
					System.out.println("정보 입력 완료.");
				else
					System.out.println("정보 입력 실패");

				break;

			case 4:
				select = salInput.gradeInput();
				select = salDAO.delete(select);
				//if (select == 1)
				if (select > 0)
					System.out.println("삭제 완료");
				else
					System.out.println("삭제 실패");

				break;

			default:
				System.out.println("프로그램 종료");
				check = !check;

			}

		}

	}



}