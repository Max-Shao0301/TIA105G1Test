package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberJDBCDAO implements MemberDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/pet_db?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT = "INSERT INTO member(email, password, name, phone, address, captcha_code) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE member set email=?,password=?, name=?, phone=?, address=?, points=?, status=?, captcha_code=? where member_id = ?";
	private static final String UPDATE_ACCOUNT = "UPDATE member set email=?, name=?, phone=?, address=? where member_id = ?";
	private static final String UPDATE_PASSWORD = "UPDATE member set password=? where member_id = ?";
	private static final String UPDATE_POINTS = "UPDATE member set points=? where member_id = ?";
	private static final String UPDATE_CODE = "UPDATE member set captcha_code=? where member_id = ?";
	private static final String GET_ONE_STMT = "SELECT * from member WHERE member_id = ?";
	private static final String GET_ALL = "SELECT * from member order by member_id";
	private static final String DELETE = "UPDATE member set status=0, last_update_time = NOW() where member_id=?";

	
	@Override
	public void delete(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, memberVO.getMember_id());
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
	public void insert(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getPhone());
			pstmt.setString(5, memberVO.getAddress());
			pstmt.setString(6, memberVO.getCaptcha_code());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getPhone());
			pstmt.setString(5, memberVO.getAddress());
			pstmt.setInt(6, memberVO.getPoints());
			pstmt.setInt(7, memberVO.getStatus());
			pstmt.setString(8, memberVO.getCaptcha_code());
			pstmt.setInt(9, memberVO.getMember_id());
			System.out.println(pstmt);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update_account(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ACCOUNT);

			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getPhone());
			pstmt.setString(4, memberVO.getAddress());
			pstmt.setInt(5, memberVO.getMember_id());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update_password(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_PASSWORD);

			pstmt.setString(1, memberVO.getPassword());
			pstmt.setInt(2, memberVO.getMember_id());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update_captcha_code(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_CODE);

			pstmt.setString(1, memberVO.getCaptcha_code());
			pstmt.setInt(2, memberVO.getMember_id());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void update_points(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_POINTS);

			pstmt.setInt(1, memberVO.getPoints());
			pstmt.setInt(2, memberVO.getMember_id());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public MemberVO findbyPrimaryKey(Integer member_id) {
		MemberVO membervo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, member_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				membervo = new MemberVO();
				membervo.setMember_id(rs.getInt("member_id"));
				membervo.setEmail(rs.getString("email"));
				membervo.setPassword(rs.getString("password"));
				membervo.setName(rs.getString("name"));
				membervo.setPhone(rs.getString("phone"));
				membervo.setAddress(rs.getString("address"));
				membervo.setPoints(rs.getInt("points"));
				membervo.setCaptcha_code(rs.getString("captcha_code"));
				membervo.setStatus(rs.getInt("status"));
				membervo.setRegistration_time(rs.getTimestamp("registration_time"));
				membervo.setLast_update_time(rs.getTimestamp("last_update_time"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException se) {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return membervo;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO membervo = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					membervo = new MemberVO();
					membervo = new MemberVO();
					membervo.setMember_id(rs.getInt("member_id"));
					membervo.setEmail(rs.getString("email"));
					membervo.setPassword(rs.getString("password"));
					membervo.setName(rs.getString("name"));
					membervo.setPhone(rs.getString("phone"));
					membervo.setAddress(rs.getString("address"));
					membervo.setPoints(rs.getInt("points"));
					membervo.setCaptcha_code(rs.getString("captcha_code"));
					membervo.setStatus(rs.getInt("status"));
					membervo.setRegistration_time(rs.getTimestamp("registration_time"));
					membervo.setLast_update_time(rs.getTimestamp("last_update_time"));
					
					list.add(membervo);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return list;
	}
}
