package myboot.app2.services;

public class BadCounter extends Exception {

    private static final long serialVersionUID = 1L;

    public BadCounter() {
        super("bad counter");
    }

}