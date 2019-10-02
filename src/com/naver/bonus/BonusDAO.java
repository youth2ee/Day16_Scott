package com.naver.bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.emp.EmpDTO;
import com.naver.util.DBConnector;

public class BonusDAO {

	public BonusDTO getSelectOne(String ename) { 
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		BonusDTO bonusDTO=null;

		try {
			con=DBConnector.getConnect();
			
			String sql = "select * from bonus where ename=?";
			st=con.prepareStatement(sql);
			st.setString(1, ename);
			rs = st.executeQuery();

			if(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString(1));
				bonusDTO.setJob(rs.getString(2));
				bonusDTO.setSal(rs.getInt(3));
				bonusDTO.setComm(rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bonusDTO;
	} //getSelectOne


	public List<BonusDTO> getSelectAll() {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		BonusDTO bonusDTO = null;

		List<BonusDTO> ar=null;

		try {
			con=DBConnector.getConnect();
			
			String sql = "select * from bonus";
			st=con.prepareStatement(sql);
			rs = st.executeQuery();

			while(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString(1));
				bonusDTO.setJob(rs.getString(2));
				bonusDTO.setSal(rs.getInt(3));
				bonusDTO.setComm(rs.getInt(4));

				ar.add(bonusDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ar;
	}//getselectall

	public int insert(BonusDTO bonusDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con=DBConnector.getConnect();
			
			String sql = "insert into bonus values(?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setString(1, bonusDTO.getEname());
			st.setString(2, bonusDTO.getJob());
			st.setInt(3, bonusDTO.getSal());
			st.setInt(4, bonusDTO.getComm());

			result = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}//insert

	public int delete(String ename) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con=DBConnector.getConnect();
			
			String sql = "delete bonus where ename=?";
			st=con.prepareStatement(sql);
			st.setString(1, ename);

			result = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}//delete

}
