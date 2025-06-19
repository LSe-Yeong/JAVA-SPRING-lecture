package hellojpa.jpql;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERS")
public class OrderJ {

    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private AddressJ address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductJ product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public AddressJ getAddress() {
        return address;
    }

    public void setAddress(AddressJ address) {
        this.address = address;
    }

    public ProductJ getProduct() {
        return product;
    }

    public void setProduct(ProductJ product) {
        this.product = product;
    }
}
