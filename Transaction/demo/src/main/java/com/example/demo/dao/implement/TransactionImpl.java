package com.example.demo.dao.implement;


import com.example.demo.dao.DataSource;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.data.entity.TagFinance;
import com.example.demo.data.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionImpl implements TransactionDAO {
    public static final String SELECT_ALL = "SELECT * FROM Transactions,TagFinance where tagId = id";
    public static final String INSERT_TRAN = "INSERT INTO Transactions (createdAt,title, description,amount,tagId) VALUES (?, ?,?,?,?)";
    public static final String UPDATE_TRANSACTION = "UPDATE Transactions SET createdAt =?,title=?, description =?,amount=?, WHERE tagId =?";
    public static final String SEARCH_BY_ID = "SELECT * FROM Transactions,TagFinance WHERE tagId = ?";
    public static final String DELETE_TRAN = "DELETE FROM Transactions WHERE id =?";

    @Override
    public List<Transaction> getAllTransactions() {
        Connection conn = null;
        List<Transaction> list = new ArrayList<>();
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String createAt = rs.getString("createdAt");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tagId = rs.getInt("tagId");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descriptionTag = rs.getString("description");
                Transaction transaction = new Transaction(createAt, title, description, amount, tagId, new TagFinance(id, name, descriptionTag));
                list.add(transaction);
            }

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return list;
    }

    @Override
    public Transaction insertTransaction(Transaction transaction) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(INSERT_TRAN);
            pstmt.setString(1, transaction.getCreatedAt());
            pstmt.setString(2, transaction.getTitle());
            pstmt.setString(3, transaction.getDescription());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setInt(5, transaction.getTagId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return transaction;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TRANSACTION);
            pstmt.setString(1, transaction.getCreatedAt());
            pstmt.setString(2, transaction.getTitle());
            pstmt.setString(3, transaction.getDescription());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return transaction;
    }

    @Override
    public void deleteTransaction(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(DELETE_TRAN);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException("Failed to delete");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }
}
