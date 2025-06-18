package hellojpa.jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class AddressT {

    private String city;
    private String street;
    private String zipcode;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(),getStreet(),getZipcode());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AddressT address = (AddressT) obj;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(),address.getStreet()) &&
                Objects.equals(getZipcode(),address.getZipcode());
    }
}
