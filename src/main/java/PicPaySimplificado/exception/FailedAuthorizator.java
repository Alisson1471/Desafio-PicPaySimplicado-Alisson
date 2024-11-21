package PicPaySimplificado.exception;

public class FailedAuthorizator extends RuntimeException {

    public FailedAuthorizator(String message) {
        super(message);
    }

}
