package Exceptions;

public class VideoDejaExistanteException extends RuntimeException {
    public VideoDejaExistanteException(String message) {
        super(message);
    }
}
