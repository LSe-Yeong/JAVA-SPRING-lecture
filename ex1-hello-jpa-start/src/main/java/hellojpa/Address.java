package hellojpa;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

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
        return Objects.hash(city,street,zipcode);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return Objects.equals(city, address.city) &&
                Objects.equals(street,address.street) &&
                Objects.equals(zipcode,address.zipcode);
    }
}
