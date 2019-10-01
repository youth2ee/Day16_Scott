package com.naver.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.util.DBConnector;

public class EmpDAO {

	public EmpDTO getSelectOne(int empno) { //매개변수 사원번호 //출력은 view //
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		EmpDTO empDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from emp where empno=? ";
			st=con.prepareStatement(sql);
			st.setInt(1, empno);
			rs = st.executeQuery();
			
			if(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setMgr(rs.getInt(4));
				empDTO.setHiredate(rs.getDate(5));
				empDTO.setSal(rs.getInt(6));
				empDTO.setComm(rs.getInt(7));
				empDTO.setDeptno(rs.getInt(8));
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
		
		return empDTO;
		
	} //getSelectOne 메서드 
	
	public ArrayList<EmpDTO> getSelectAll() { //최신입사일순으로 
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		EmpDTO empDTO =null;
		
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select empno,ename,job,mgr,hiredate,sal,nvl(comm,0) comm,deptno "
			+"from emp order by hiredate desc";
			//nvl(comm,0) comm
			st=con.prepareStatement(sql);
			rs = st.executeQuery();
			
			
			while(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setMgr(rs.getInt(4));
				empDTO.setHiredate(rs.getDate(5));
				empDTO.setSal(rs.getInt(6));
				empDTO.setComm(rs.getInt(7));
				empDTO.setDeptno(rs.getInt(8));
				
				ar.add(empDTO);
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
	
	}//getselectall
	
}
