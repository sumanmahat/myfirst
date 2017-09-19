package classworkshop.com.workshop1.model;

import java.io.Serializable;

/**
 * Created by Admin on 9/6/2017.
 */

public class Data2 implements Serializable {
    private String model;
    private String price;
    private String location;
    private  String description;

    public static final long serialVersionUID =12345678L;

    public Data2(String model, String price, String location, String description) {
        this.model = model;
        this.price = price;
        this.location = location;
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


