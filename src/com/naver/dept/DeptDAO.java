package com.naver.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.emp.EmpDTO;
import com.naver.util.DBConnector;

public class DeptDAO {
	
	public DeptDTO getSelectOne(int deptno) {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		DeptDTO deptDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from dept where deptno=? ";
			st=con.prepareStatement(sql);
			st.setInt(1, deptno);
			rs = st.executeQuery();
			
			if(rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt(1));
				deptDTO.setDname(rs.getString(2));
				deptDTO.setLoc(rs.getString(3));

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
		
		
			return deptDTO;
			
			
		}
	
	public ArrayList<DeptDTO> getSelectAll() {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		DeptDTO deptDTO =null;
		
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from dept";
			st=con.prepareStatement(sql);
			rs = st.executeQuery();

			
			while(rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt(1));
				deptDTO.setDname(rs.getString(2));
				deptDTO.setLoc(rs.getString(3));
				
				ar.add(deptDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ar;
	}
	
	}


