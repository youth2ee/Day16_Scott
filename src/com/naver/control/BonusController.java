package com.naver.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.bonus.BonusDAO;
import com.naver.bonus.BonusDTO;
import com.naver.input.BonusInput;
import com.naver.input.DeptInput;
import com.naver.view.BonusView;

public class BonusController {
	private Scanner sc;
	private BonusDAO bonusDAO;
	private BonusView bonusView;
	private BonusInput bonusInput;

	public BonusController() {
		sc = new Scanner(System.in);
		bonusDAO = new BonusDAO();
		bonusView = new BonusView();
		bonusInput = new BonusInput();
	}

	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("1. 보너스 전체출력");
			System.out.println("2. 보너스 이름별출력");
			System.out.println("3. 보너스정보 추가");
			System.out.println("4. 보너스정보 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();

			switch(num) {
			case 1:
				List<BonusDTO> ar = bonusDAO.getSelectAll();
				if(ar.size()!=0) {
					bonusView.view(ar);
				} else {
					System.out.println("데이터가 없습니다.");
				}
				break;

			case 2:
				String ename = bonusInput.enameInput();
				BonusDTO bonusDTO = bonusDAO.getSelectOne(ename);
				if(bonusDTO!=null) {
					bonusView.view(bonusDTO);
				} else {
					//bonusView.view("없는 이름입니다.");
				}
				break;

			case 3:
				BonusDTO bonusDTO2 = bonusInput.salInsert();
				int result = bonusDAO.insert(bonusDTO2);

				if(result>0) {
					System.out.println("추가성공");
					bonusView.view(bonusDTO2);
				} else {
					System.out.println("추가실패");
				}
				break;

			case 4:
				ename = bonusInput.enameInput();
				result = bonusDAO.delete(ename);

				if(result>0) {
					System.out.println("삭제성공");
				} else {
					System.out.println("삭제실패");
				}

				break;

			default:
				check=!check;
			}//switch문 끝
		}//while문 끝
	}//start 메서드 끝

}
