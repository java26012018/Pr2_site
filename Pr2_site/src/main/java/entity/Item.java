package entity;

import java.util.Objects;

public class Item {
    private int id;
    private String model;
    private int price;
    private String about;
    private String cat;
    private String pic;

    public Item() {
    }

    public Item(int id, String model, int price, String about, String cat, String pic) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.about = about;
        this.cat = cat;
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", model=" + model + ", price=" + price + ", about=" + about + ", cat=" + cat + ", pic=" + pic + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.model);
        hash = 37 * hash + this.price;
        hash = 37 * hash + Objects.hashCode(this.about);
        hash = 37 * hash + Objects.hashCode(this.cat);
        hash = 37 * hash + Objects.hashCode(this.pic);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.about, other.about)) {
            return false;
        }
        if (!Objects.equals(this.cat, other.cat)) {
            return false;
        }
        if (!Objects.equals(this.pic, other.pic)) {
            return false;
        }
        return true;
    }
    
}
