package org.aptech.t2004e.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@SuperBuilder
public class CartItemDto {
    // khoá chính được nên từ 2 trường là shoppingCartId và productId
    private int shoppingCartId; // thuộc xe hàng nào, khoá ngoại từ shoppingCart.
    private int productId; // sản phẩm nào trong xe hàng, khoá ngoại từ bảng products.
    private String productName;
    private double unitPrice; // giá tại thời điểm bán, không phải giá sản phẩm thời điểm hiện tại.
    private int quantity;
}
