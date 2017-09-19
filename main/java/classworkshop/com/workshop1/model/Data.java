package classworkshop.com.workshop1.model;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Admin on 9/6/2017.
 */

public class Data implements Serializable {
    private String title;
    private String data;
    private String amount;
    private String description;
    private String image;

    public static final long serialVersionUID = 98765432L;

    public Data(){

    }

    public Data(String title, String data, String amount, String description, String image) {
        this.title = title;
        this.data = data;
        this.amount = amount;
        this.description = description;
        this.image= image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Data(String mytitle, String mydata, String myamount, String mydesc){

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
