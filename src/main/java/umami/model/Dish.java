package umami.model;


import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @NotNull @Range(min=0)
    private double price;

//    @NotNull @NotEmpty
    private String dishType;

    public Dish() {}

    public Dish(Long id, String name, String description, double price, String dishType) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setType(dishType);
    }

    private void setType(String dishType) {
        this.dishType = dishType;
    }
    public String getType() {
        return this.dishType;
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
