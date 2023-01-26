package supplies.sales;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sale {
    private Date saleDate;
    private List<Product> items;
    private String location;
    private Boolean couponUsed;
    private String purchasedMethod;
    private Customer customer;
    //private Double total;

}
