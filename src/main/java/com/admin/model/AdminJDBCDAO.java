package com.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminJDBCDAO implements AdminDAO_Interface {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/pet_db?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PWD = "123456";
	private static final String INSERT_STMT = "INSERT INTO admin(account, password) VALUES (?, ?)";
	private static final String UPDATE_STMT = "UPDATE admin SET account = ?, password = ? WHERE admin_id = ?";
	private static final String DELETE_STMT = "DELETE FROM admin WHERE admin_id = ?";
	private static final String FIND_BY_PK = "SELECT * FROM admin WHERE admin_id = ?";
	private static final String GET_ALL = "SELECT * FROM admin";
	private static final String FIND_BY_ACCOUNT = "SELECT * FROM admin WHERE account = ?";

	
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}
	}
	

	@Override
	public void insert(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, adminVO.getAccount());
			pstmt.setString(2, adminVO.getPassword());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void update(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setString(1, adminVO.getAccount());
			pstmt.setString(2, adminVO.getPassword());
			pstmt.setInt(3, adminVO.getAdminId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(Integer adminId) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, adminId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public AdminVO findByPrimaryKey(Integer adminId) {
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVO adminVO = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, adminId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String account = rs.getString(2);
				String password = rs.getString(3);
				adminVO = new AdminVO(adminId, account, password);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return adminVO;
	}

	
	
	@Override
	public AdminVO findByAccount(String account) {
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVO adminVO = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(FIND_BY_ACCOUNT);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Integer adminId = rs.getInt(1);
				String password = rs.getString(3);
				adminVO = new AdminVO(adminId, account, password);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return adminVO;
	}

	@Override
	public List<AdminVO> getAll() {
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVO adminVO = null;
		List<AdminVO> list = new ArrayList<AdminVO>();
		
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				adminVO = new AdminVO();
				adminVO.setAdminId(rs.getInt("admin_id"));
				adminVO.setAccount(rs.getString("account"));
				adminVO.setPassword(rs.getString("password"));
				list.add(adminVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	
}
