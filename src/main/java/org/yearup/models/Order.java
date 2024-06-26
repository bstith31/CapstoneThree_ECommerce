package org.yearup.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {

    private int orderId;
    private int userId;
    private LocalDate date;
    private String address;
    private String city;
    private String state;
    private int zip;



}

class OrderLineItem{

    private int orderLineItemId;
    private int orderId;
    private int productId;
    private BigDecimal salesPrice;
    private int quantity;
    private BigDecimal discount;

}
