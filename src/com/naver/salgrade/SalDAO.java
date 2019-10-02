package com.naver.salgrade;



import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;



import com.naver.util.DBConnector;



public class SalDAO {

	Connection con = null;

	PreparedStatement st = null;

	ResultSet rs = null;

	DBConnector db = new DBConnector();



	public int delete(int grade) {

		int result = 0;

		try {

			con = db.getConnect();

			con.setAutoCommit(false); // 오토커밋해제

			String sql = "delete from salgrade where grade = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, grade);

			result = st.executeUpdate();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				rs.close();

				st.close();

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return result;



	}



	public int insert(SalDTO salDTO) {

		int result = 0;

		try {

			con = db.getConnect();

			String sql = "insert into salgrade values (?,?,?)";

			st = con.prepareStatement(sql);

			st.setInt(1, salDTO.getGrade());

			st.setInt(2, salDTO.getLosal());

			st.setInt(3, salDTO.getHisal());

			result = st.executeUpdate();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {


				st.close();

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return result;

	}



	public List<SalDTO> getSelectList() {

		List<SalDTO> ar = null;

		SalDTO salDTO = null;

		try {

			con = db.getConnect();

			String sql = "select * from salgrade";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {

				salDTO = new SalDTO();

				salDTO.setGrade(rs.getInt("grade"));

				salDTO.setLosal(rs.getInt("losal"));

				salDTO.setHisal(rs.getInt("hisal"));

				ar.add(salDTO);

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				rs.close();

				st.close();

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}



		}

		return ar;



	}



	public SalDTO getSelectOne(int grade) {



		SalDTO salDTO = new SalDTO();

		try {

			con = db.getConnect();

			String sql = "select * from salgrade where grade = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, grade);

			rs = st.executeQuery();

			if (rs.next()) {

				salDTO = new SalDTO();

				salDTO.setGrade(rs.getInt("grade"));

				salDTO.setLosal(rs.getInt("losal"));

				salDTO.setHisal(rs.getInt("hisal"));

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			try {

				rs.close();

				st.close();

				con.close();

			} catch (SQLException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return salDTO;



	}



}