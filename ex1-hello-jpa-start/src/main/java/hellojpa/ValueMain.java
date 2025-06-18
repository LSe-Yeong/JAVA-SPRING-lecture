package hellojpa;

import jakarta.persistence.criteria.CriteriaBuilder;

public class ValueMain {
    public static void main(String[] args) {
        Address address = new Address("city", "street", "zipcode");
        Address address2 = new Address("city", "street", "zipcode");

        System.out.println("(address==address2) = " + (address==address2));
        System.out.println("(address==address2) = " + (address.equals(address2)));
    }
}
