package umami.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Dish {
    private int id;

    // check values inputted in form
    @NotNull
    @NotEmpty
    @Size(min=2, max=20)
    private String name;

    // check values inputted in form
    @NotNull
    @NotEmpty
    @Size(min=5, max=50)
    private String description;

    @NotNull
    private double price;

    public Dish() {}

    public Dish(int id, String name, String description, double price) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String feedback) {
        this.description = feedback;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
