package ro.damaris.splabdamaris;

import jakarta.persistence.*;

@Entity
public class Image extends Element {
    private String url;

    public Image() {} // Constructor gol obligatoriu JPA

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}