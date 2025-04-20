package model;

public class Customer extends User {
    private Portofolio portofolio = new Portofolio();

    public Customer(String username, String password) {
        super(username, password);
    }

    public Portofolio getPortofolio() {
        return portofolio;
    }

    @Override
    public String getRole() {
        return "customer";
    }
}
