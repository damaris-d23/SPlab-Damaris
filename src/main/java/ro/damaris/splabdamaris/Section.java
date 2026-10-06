package ro.damaris.splabdamaris;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
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
        // Verificăm dacă elementul aparține deja altui părinte
        if (element.getParent() != null) {
            throw new IllegalArgumentException("Acest element apartine deja altei sectiuni!");
        }

        // Dacă nu are părinte, setăm secțiunea curentă ca părinte
        element.setParent(this);

        // Apoi îl adăugăm efectiv în listă
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        if (children.remove(element)) {
            element.setParent(null); // eliberăm elementul
        }
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}
