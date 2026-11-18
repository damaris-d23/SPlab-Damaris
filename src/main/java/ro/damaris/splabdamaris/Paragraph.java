package ro.damaris.splabdamaris;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Entity
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paragraph extends Element {
    private String text;

    public Paragraph() {} // Constructor gol obligatoriu JPA

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
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