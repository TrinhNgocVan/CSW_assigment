package org.aptech.t2004e.dto;

import java.util.HashMap;
import java.util.List;

public class ShoppingCartDto {
    private int id; // khoá chính
    private int userId; // của ai, để default hard code = 1, bởi chưa có bảng user.
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private double totalPrice; // đây là một biến tạm để show thông tin còn bản chất là tính tổng từ cartItems.
    private HashMap<Integer, CartItemDto> mapCartItems;
    private List<CartItemDto> cartItems;
}
