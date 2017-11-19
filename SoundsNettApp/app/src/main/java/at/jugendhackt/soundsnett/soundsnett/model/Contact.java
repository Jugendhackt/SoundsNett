package at.jugendhackt.soundsnett.soundsnett.model;

/**
 * Created by chris on 18.11.2017.
 */

public class Contact {
    String name;
    int imgSrc;

    public Contact(String name, int imgSrc) {
        this.name = name;
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public int getImgSrc() {
        return imgSrc;
    }
}
