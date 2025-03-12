package com.apply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ApplyJDBCDAO implements ApplyDAO_interface {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/pet_db?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PWD = "123456";
	
	private static final String INSERT_STMT = "INSERT INTO apply(email, name, phone, gender, licence_photo, plate_number, introduction) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE apply SET results = ?, review_date = NOW() WHERE apply_id = ? AND review_date IS NULL";
	private static final String DELETE_STMT = "DELETE FROM apply WHERE apply_id = ?";
	private static final String FIND_BY_PK = "SELECT * FROM apply WHERE apply_id = ?";
	private static final String GET_ALL = "SELECT * FROM apply";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		}
	}

	@Override
	public void insert(ApplyVO applyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, applyVO.getEmail());
			pstmt.setString(2, applyVO.getName());
			pstmt.setString(3, applyVO.getPhone());
			pstmt.setInt(4, applyVO.getGender());
			pstmt.setBytes(5, applyVO.getLicencePhoto());
			pstmt.setString(6, applyVO.getPlateNumber());
			pstmt.setString(7, applyVO.getIntroduction());
			pstmt.executeUpdate();

		} catch (SQLException e) {
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
	public void update(ApplyVO applyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, applyVO.getResults());
			pstmt.setInt(2, applyVO.getApplyId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
	public void delete(Integer applyId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, applyId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
	public ApplyVO findByPrimaryKey(Integer applyId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ApplyVO applyVO = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, applyId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				Integer gender = rs.getInt(5);
				byte[] licence_photo = rs.getBytes(6);
				String plate_number = rs.getString(7);
				String introduction = rs.getString(8);
				Integer results = rs.getInt(9);
				Timestamp submissionDate = rs.getTimestamp(10);
				Timestamp reviewDate = rs.getTimestamp(11);
				applyVO = new ApplyVO(applyId, email, name, phone, gender, licence_photo, plate_number, introduction,
						results, submissionDate, reviewDate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		return applyVO;
	}

	@Override
	public List<ApplyVO> getAll() {
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ApplyVO applyVO = null;
		List<ApplyVO> list = new ArrayList<ApplyVO>();
		
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				applyVO = new ApplyVO();
				applyVO.setApplyId(rs.getInt("apply_id"));
				applyVO.setEmail(rs.getString("email"));
				applyVO.setName(rs.getString("name"));
				applyVO.setPhone(rs.getString("phone"));
				applyVO.setGender(rs.getInt("gender"));
				applyVO.setLicencePhoto(rs.getBytes("licence_photo"));
				applyVO.setPlateNumber(rs.getString("plate_number"));
				applyVO.setIntroduction(rs.getString("introduction"));
				applyVO.setResults(rs.getInt("results"));
				applyVO.setSubmissionDate(rs.getTimestamp("submission_date"));
				applyVO.setReviewDate(rs.getTimestamp("review_date"));
				list.add(applyVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		
		return list;
	}

}
