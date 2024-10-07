package com.example.bankingsystem.repositories;

import com.example.bankingsystem.enums.CardType;
import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.models.Card;
import com.example.bankingsystem.models.Customer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CardRepository extends GenericRepository<Card> {

      @Override
    protected String getTableName() {
        return "Card";
    }

    @Override
    protected Card mapResultSetToEntity(ResultSet rs) throws SQLException {
      return new Card(
                rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getString("card_number"),
                CardType.valueOf(rs.getString("card_type")),
                rs.getDate("expiration_date"),
                rs.getDouble("card_limit"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
        );
    }

    @Override
    public void add(Card card) {
        String sql = "INSERT INTO Card(id, customer_id, card_number, card_type, expiration_date, created_at, updated_at) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,card.getId());
            pstmt.setInt(2,card.getCustomerId());
            pstmt.setString(3, card.getCardNo());
            pstmt.setString(4, card.getCardType().toString());
            pstmt.setDate(5, card.getExpirationDate() );
            pstmt.setTimestamp(6,card.getCreatedAt());
            pstmt.setTimestamp(7,card.getUpdatedAt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Card card) {
        String sql = " UPDATE Customer " +
                     " SET expiration_date=?, updated_at=? " +
                     " WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, card.getExpirationDate());
            pstmt.setTimestamp(2,card.getUpdatedAt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Custom method to find a card by its card number
    public Card findByCardNo(String cardNo) throws SQLException {
        String sql = "SELECT id, customer_id, card_number, card_type, expiration_date, card_limit, created_at, updated_at " +
                     " FROM Card " +
                     " WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(3, cardNo);
            ResultSet rs = pstmt.executeQuery();
            return new Card(
                    rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getString("card_number"),
                    CardType.valueOf(rs.getString("card_type")),
                    rs.getDate("expiration_date"),
                    rs.getDouble("card_limit"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

