package at.jugendhackt.soundsnett.soundsnett.model;

/**
 * Created by chris on 18.11.2017.
 */

public class Message {
    int soundId;
    String sender;
    String receiver;
    String msg;

    public Message(int soundId, String sender, String receiver, String msg) {
        this.soundId = soundId;
        this.sender = sender;
        this.receiver = receiver;
        this.msg = msg;
    }
    public String getMessage() {
        return msg;
    }
    public int getSound() { return soundId;}

    public String getSender() {
        return sender;
    }
}
