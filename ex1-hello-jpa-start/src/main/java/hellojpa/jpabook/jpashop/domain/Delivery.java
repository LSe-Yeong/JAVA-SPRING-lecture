package hellojpa.jpabook.jpashop.domain;

import hellojpa.BaseEntityT;
import jakarta.persistence.*;

@Entity
public class Delivery extends BaseEntityT {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
