package umami.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min=2, max=50)
    private String name;

    @Size(min=4, max=100)
    private String description;

    @Range(min=0)
    private double price;

    private DishType dishType;

    public Dish() {}
    public Dish(@Size(min = 2, max = 50) String name, @Size(min = 4, max = 100) String description, @Range(min = 0) double price, DishType dishType) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setType(dishType);
    }

    public void setType(DishType dishType) {
        this.dishType = dishType;
    }
    public DishType getType() {
        return this.dishType;
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
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
