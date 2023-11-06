package entity;

public class Variant {
    private int id;
    private String color;
    private int size;

    public Variant() {
    }

    public Variant(int id, String color, int size) {
        this.id = id;
        this.color = color;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
