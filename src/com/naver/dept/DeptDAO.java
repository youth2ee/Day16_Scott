package com.naver.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.emp.EmpDTO;
import com.naver.util.DBConnector;

public class DeptDAO {
	
	
	public int deptInsert(DeptDTO deptDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "insert into DEPT values(?,?,?)";
			st=con.prepareStatement(sql);
			
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
			result = st.executeUpdate();
			
			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}
				
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
	
	
	

	public DeptDTO getSelectOne(int deptno) {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;
		DeptDTO deptDTO =null;

		try {
			con=DBConnector.getConnect();
			String sql = "select * from dept where deptno=? ";
			st=con.prepareStatement(sql);
			st.setInt(1, deptno); //sql에 ?가 없으면 위에서 sql보내고 끝
			rs = st.executeQuery();

			if(rs.next()) {
				deptDTO = new DeptDTO();
				deptDTO.setDeptno(rs.getInt(1));
				deptDTO.setDname(rs.getString(2));
				deptDTO.setLoc(rs.getString(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close(); //db연결끊기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return deptDTO;
	}//getSelectOne 메서드 끝
	
	

	//public ArrayList<DeptDTO> getSelectAll() {
	 public List<DeptDTO> getSelectAll(){

	//public 부모타입으로 리턴받는다고 해도 된다.
	//일반적인 클래스의 부모는 object클래스 하지만 형변환해야되므로 귀찮다.
	//arraylist의 부모는 List클래스. List도 add,get 다 할 수 있다.
		
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		//얘의 객체는 한번만 생성해야  DeptrDTO애들을 모을 공간을 만드는 것
		
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs =null;

		try {
			con=DBConnector.getConnect();
			String sql = "select * from dept order by deptno asc";
			st=con.prepareStatement(sql);
			rs = st.executeQuery();

			while(rs.next()) {
				DeptDTO deptDTO = new DeptDTO();
				//얘는 여기서만 쓸거니까 여기서 선언해도 됨
				deptDTO.setDeptno(rs.getInt(1));
				deptDTO.setDname(rs.getString(2));
				deptDTO.setLoc(rs.getString(3));

				ar.add(deptDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close(); //db연결끊기
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return ar;
	}//getSelectAll 메서드 끝

}


