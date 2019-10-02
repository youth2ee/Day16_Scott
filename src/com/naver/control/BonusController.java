package com.naver.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.bonus.BonusDAO;
import com.naver.bonus.BonusDTO;
import com.naver.input.DeptInput;

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
				if(ar.size()>0) {
					empView.view(ar);
				} else {
					System.out.println("데이터가 없습니다.");
				}
				break;

			case 2:
				String ename = DeptInput.enameInput;
				BonusDTO bonusDTO = bonusDAO.getSelectOne(ename);
				if(bonusDTO!=null) {
					bonusView.view(bonusDTO);
				} else {
					bonusView.view("없는 이름입니다.");
				}
				break;

			case 3:
				BonusDTO bonusDTO2 = bonusInput.bonusInsert();
				int result = bonusDAO.insert(bonusDTO2);
				String s = "추가실패";

				if(result>0) {
					s = "추가성공";
					bonusView.view(bonusDTO);
				}
				bonusView.view(s);
				break;

			case 4:
				ename = bonusInput.enameInput();
				result = bonusDAO.delete(ename);
				s="삭제실패";
				if(result>0) {
					s="삭제성공";
				}
				bonusView.view(s);

				break;

			default:
				check=!check;
			}
		}




	}

}
