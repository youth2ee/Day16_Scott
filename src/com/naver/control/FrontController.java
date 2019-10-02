package com.naver.control;

import java.util.Scanner;

public class FrontController {
	
	private Scanner sc;
	private EmpController empController;
	private DeptController deptController;
	private BonusController bonusController;
	private SalController salController;
	
	
	public FrontController() {
		sc = new Scanner(System.in);
		empController = new EmpController();
		deptController = new DeptController();
		bonusController = new BonusController();
		salController = new SalController();
	}
	
	public void start() {
		boolean check=true;
		int select=0;
		
		while(check) {
			System.out.println("1. 사원관리");
			System.out.println("2. 부서관리");
			System.out.println("3. 월급등급");
			System.out.println("4. 보너스");
			System.out.println("3. 종료");
			select = sc.nextInt();
			
			switch (select) {
			case 1:
				empController.start();
				break;
				
			case 2:
				deptController.start();
				break;
				
			case 3:
				salController.start();
				break;
				
			case 4:
				bonusController.start();
				break;
				
			default:
				check=!check;
			}
			
		}
		
		
		
	}

}
