package at.jugendhackt.soundsnett.soundsnett.model;

/**
 * Created by chris on 18.11.2017.
 */

public class Contact {
    String name;
    String imgSrc;

    public Contact(String name, String imgSrc) {
        this.name = name;
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return imgSrc;
    }
}
