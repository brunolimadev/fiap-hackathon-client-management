package br.com.fiap.client_management.client_management.domain;

public class Address {

    private String street;

    private String city;

    private String province;

    private String zipCode;

    private String country;

    public Address() {
    }

    private Address(String street, String city, String province, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.country = country;
    }

    public static Address of(String street, String city, String province, String zipCode, String country) {
        return new Address(street, city, province, zipCode, country);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
