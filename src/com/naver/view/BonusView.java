package com.naver.view;

import java.util.List;
import com.naver.bonus.BonusDTO;

public class BonusView {

	public void view(BonusDTO bonusDTO) {
		System.out.println("ENAME : " + bonusDTO.getEname());
		System.out.println("JOB : " + bonusDTO.getJob());
		System.out.println("SAL : " + bonusDTO.getSal());
		System.out.println("COMM : " + bonusDTO.getComm());
	}


	public void view(List<BonusDTO> ar) {
		for (BonusDTO bonusDTO : ar)
			this.view(bonusDTO);
	}

}