package com.naver.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.dept.DeptDTO;
import com.naver.util.DBConnector;

public class EmpDAO {

	public ArrayList<EmpDTO> find(String sql) {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		EmpDTO empDTO =null;

		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();

		try {
			con=DBConnector.getConnect();
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return ar;



	}

	public ArrayList<EmpDTO> search(String str) {

		String sql = "select * from EMP where ename like '%"+str+"%' ";
		ArrayList<EmpDTO> ar = this.find(sql);
		return ar;

	}

	public ArrayList<EmpDTO> getSelectAll() { //최신입사일순으로 

		String sql = "select empno,ename,job,mgr,hiredate,sal,nvl(comm,0) comm,deptno "
				+"from emp order by hiredate desc";
		//nvl(comm,0) comm

		ArrayList<EmpDTO> ar = this.find(sql);
		return ar;

	}//getselectall



	public int delete(int empno) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con=DBConnector.getConnect();
			String sql = "delete emp where empno=?";
			st=con.prepareStatement(sql);

			st.setInt(1, empno);

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
	}


	public int empInsert(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result =0;

		try {
			con=DBConnector.getConnect();
			String sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
			st=con.prepareStatement(sql);

			st.setInt(1, empDTO.getEmpno());
			st.setString(2, empDTO.getEname());
			st.setString(3, empDTO.getJob());
			st.setInt(4, empDTO.getMgr());
			//sysdate 현재시간
			st.setInt(5, empDTO.getSal());
			st.setInt(6, empDTO.getComm());
			st.setInt(7, empDTO.getDeptno());

			result = st.executeUpdate();

			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}

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

	}



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

}
