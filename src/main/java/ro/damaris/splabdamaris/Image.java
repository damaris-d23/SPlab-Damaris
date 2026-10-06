package ro.damaris.splabdamaris;

public class Image implements Element {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url); // Formatul cerut la punctul 17[cite: 12]
    }

    @Override
    public void add(Element element) {}

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }
}
