package com.pragma.foodcourt.infrastructure.feign.pojos;

public class RestaurantModel {

    private Long id;
    private String name;
    private int nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long idOwner;

    public RestaurantModel() {
    }

    public RestaurantModel(Long id, String name, int nit, String address, String phone,
                           String urlLogo, Long idOwner) {
        this.id = id;
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.urlLogo = urlLogo;
        this.idOwner = idOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

}
