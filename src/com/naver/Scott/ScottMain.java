package com.naver.Scott;

import java.sql.Connection;

import com.naver.util.DBConnector;

public class ScottMain {

	public static void main(String[] args) {
		try {
			Connection con = DBConnector.getConnect();
			System.out.println(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
