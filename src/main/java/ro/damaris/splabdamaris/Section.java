package ro.damaris.splabdamaris;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    protected String title;
    protected List<Element> children = new ArrayList<>(); // stocăm copiii într-o listă

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element child : children) {
            child.print(); // iterează prin toți copiii
        }
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}
