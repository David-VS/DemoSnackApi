package be.ehb.snackapi.model;

//POJO -> Plain Old Java Object
//Default constructor, getters & setters
public class Snack {

    private int id;
    private String naam;
    private double prijs;

    public Snack() {
    }

    public Snack(int id, String naam, double prijs) {
        this.id = id;
        this.naam = naam;
        this.prijs = prijs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
