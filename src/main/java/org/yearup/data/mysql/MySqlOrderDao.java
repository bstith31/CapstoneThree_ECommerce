package org.yearup.data.mysql;


import org.springframework.stereotype.Component;
import org.yearup.data.OrderDao;
import org.yearup.models.Order;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

@Component
public class MySqlOrderDao extends MySqlDaoBase implements OrderDao {


    public MySqlOrderDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Order create() {

        String sqlOrder = "INSERT INTO orders (user_id, date, address, city, " +
                "state, zip, shipping_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        String sqlOrderLineItem = "INSERT INTO order_line_items (order_id, product_id, " +
                "sales_price, quantity, discount) " +
                "VALUES (?, ?, ?, ?, ?)";

        LocalDate date = LocalDate.now();

//        try (Connection connection = getConnection()) {
//            PreparedStatement orderPreparedStatement = connection.prepareStatement(sqlOrder);
//            orderPreparedStatement.setInt(1, userId);
//            orderPreparedStatement.setDate(2, Date.valueOf(date));
//            orderPreparedStatement.setString(3, order.getAddress());
//            orderPreparedStatement.setString(4, order.getCity());
//            orderPreparedStatement.setString(5, order.getState());
//            orderPreparedStatement.setInt(6, order.getZip());
//            orderPreparedStatement.setBigDecimal(7, order.getShippingAmount());
//
//            orderPreparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
       return null;
   }

    private Order mapRow(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt("order_id");
        int userId = resultSet.getInt("user_id");
        LocalDate date = resultSet.getDate("date").toLocalDate();
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String state = resultSet.getString("state");
        String zip = resultSet.getString("zip");
        BigDecimal shippingAmount = resultSet.getBigDecimal("shipping_amount");


        return new Order();
    }
}
