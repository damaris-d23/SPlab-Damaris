package ro.damaris.splabdamaris;

public class ImageProxy extends Element {
    private String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }

    @Override
    public void add(Element element) {}
    @Override
    public void remove(Element element) {}
    @Override
    public Element get(int index) { return null; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}