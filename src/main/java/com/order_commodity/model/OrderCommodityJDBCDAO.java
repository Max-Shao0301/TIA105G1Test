package com.order_commodity.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderCommodityJDBCDAO implements OrderCommodityDAO_interface {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/pet_db?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "123456";

    private static final String INSERT_STMT =
            "INSERT INTO order_commodity (order_id, commodity_id) VALUES (?, ?)";
    private static final String GET_ALL_STMT =
            "SELECT order_commodity_id, order_id, commodity_id FROM order_commodity ORDER BY order_commodity_id";
    private static final String GET_ONE_STMT =
            "SELECT order_commodity_id, order_id, commodity_id FROM order_commodity WHERE order_commodity_id = ?";
    private static final String DELETE =
            "DELETE FROM order_commodity WHERE order_commodity_id = ?";
    private static final String UPDATE =
            "UPDATE order_commodity SET order_id=?, commodity_id=? WHERE order_commodity_id = ?";

    @Override
    public void insert(OrderCommodityVO orderCommodityVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setInt(1, orderCommodityVO.getOrderId());
            pstmt.setInt(2, orderCommodityVO.getCommodityId());

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public void update(OrderCommodityVO orderCommodityVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setInt(1, orderCommodityVO.getOrderId());
            pstmt.setInt(2, orderCommodityVO.getCommodityId());
            pstmt.setInt(3, orderCommodityVO.getOrderCommodityId());

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public void delete(Integer orderCommodityId) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, orderCommodityId);

            pstmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public OrderCommodityVO findByPrimaryKey(Integer orderCommodityId) {
        OrderCommodityVO orderCommodityVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, orderCommodityId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                orderCommodityVO = new OrderCommodityVO();
                orderCommodityVO.setOrderCommodityId(rs.getInt("order_commodity_id"));
                orderCommodityVO.setOrderId(rs.getInt("order_id"));
                orderCommodityVO.setCommodityId(rs.getInt("commodity_id"));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return orderCommodityVO;
    }

    @Override
    public List<OrderCommodityVO> getAll() {
        List<OrderCommodityVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_STMT);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderCommodityVO orderCommodityVO = new OrderCommodityVO();
                orderCommodityVO.setOrderCommodityId(rs.getInt("order_commodity_id"));
                orderCommodityVO.setOrderId(rs.getInt("order_id"));
                orderCommodityVO.setCommodityId(rs.getInt("commodity_id"));
                list.add(orderCommodityVO);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
        } catch (SQLException se) {
            throw new RuntimeException("A database error occurred. " + se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return list;
    }
}