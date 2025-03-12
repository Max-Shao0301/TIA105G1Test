package com.staff.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StaffJDBCDAO implements StaffDAO_interface {
//	========連接資料庫資訊========
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/pet_db?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";
//	========連接資料庫資訊========

//	========SQL指令========
	public static final String INSERT_STAFF = "insert into staff(apply_id, email, password, name, phone, gender, plate_number, introduction) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_ONE = "select * from staff where staff_id = ?";
	public static final String UPDATA_STAFF = "update staff set  email = ?, password = ?, name = ?, phone = ?,  plate_number = ?, introduction = ? where staff_id = ? ";
	public static final String GET_ALL = "select * from staff order by staff_id ";
	public static final String DELETE = "UPDATE staff set status=0, last_update_time = NOW() where staff_id=?";
//	========SQL指令========

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(StaffVO staff) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STAFF);
			System.out.println("連線成功");
			pstmt.setInt(1, staff.getApply_id());
			pstmt.setString(2, staff.getEmail());
			pstmt.setString(3, staff.getPassword());
			pstmt.setString(4, staff.getName());
			pstmt.setString(5, staff.getPhone());
			pstmt.setInt(6, staff.getGender());
			pstmt.setString(7, staff.getPlate_number());
			pstmt.setString(8, staff.getIntroduction());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(StaffVO staff) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATA_STAFF);
			pstmt.setString(1, staff.getEmail());
			pstmt.setString(2, staff.getPassword());
			pstmt.setString(3, staff.getName());
			pstmt.setString(4, staff.getPhone());
			pstmt.setString(5, staff.getPlate_number());
			pstmt.setString(6, staff.getIntroduction());
			pstmt.setInt(7, staff.getStaff_id());

			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void delete(StaffVO staffVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, staffVO.getStaff_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public StaffVO findByPK(Integer staffId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StaffVO staff = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE);
			pstmt.setInt(1, staffId);
			rs = pstmt.executeQuery();
			System.out.println("連線成功");
			while (rs.next()) {
//				查出來的資料存成變數
				Integer staff_id = rs.getInt("staff_id");
				Integer apply_id = rs.getInt("apply_id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				Integer gender = rs.getInt("gender");
				String plate_number = rs.getString("plate_number");
				String introduction = rs.getString("introduction");
				String captcha_code = rs.getString("captcha_code");
				Integer status = rs.getInt("status");
				Timestamp create_time = rs.getTimestamp("create_time");
				Timestamp last_update_time = rs.getTimestamp("last_update_time");

				staff = new StaffVO(staff_id, apply_id, email, password, name, phone, gender, plate_number,
						introduction, captcha_code, status, create_time, last_update_time);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return staff;
	}

	@Override
	public List<StaffVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<StaffVO> staffList = new ArrayList<>();

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			System.out.println("連線成功");
			while (rs.next()) {
//				把查詢出來的資料儲存成變數
				Integer staff_id = rs.getInt("staff_id");
				Integer apply_id = rs.getInt("apply_id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				Integer gender = rs.getInt("gender");
				String plate_number = rs.getString("plate_number");
				String introduction = rs.getString("introduction");
				String captcha_code = rs.getString("captcha_code");
				Integer status = rs.getInt("status");
				Timestamp create_time = rs.getTimestamp("create_time");
				Timestamp last_update_time = rs.getTimestamp("last_update_time");
//				包裝查詢出來的資料
				StaffVO staff = new StaffVO(staff_id, apply_id, email, password, name, phone, gender, plate_number,
						introduction, captcha_code, status, create_time, last_update_time);
//				將包裝好的物件，用集合收集起來
				staffList.add(staff);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return staffList;
	}
}
