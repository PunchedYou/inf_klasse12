package dstrukturen.huffman;

public class Wurzel {
    boolean node = false;
    char buchstabe;
    int haufigkeit;

    public Wurzel(int haufigkeit) {
        node = true;
        this.haufigkeit = haufigkeit;
    }

    public Wurzel(char buchstabe, int haufigkeit) {
        this.buchstabe = buchstabe;
        this.haufigkeit = haufigkeit;
    }

    public char getBuchstabe() {
        return buchstabe;
    }

    public int getHaufigkeit() {
        return haufigkeit;
    }
}
