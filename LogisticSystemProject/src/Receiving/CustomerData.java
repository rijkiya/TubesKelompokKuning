package Receiving;

public class CustomerData {
    private String customerId;
    private String name;
    private String address;
    private String phone;

    public CustomerData(String customerId, String name, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void updateAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getContactInfo() {
        return "Customer: " + name + ", Phone: " + phone + ", Address: " + address;
    }
}