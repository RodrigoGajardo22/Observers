package domain.portsou;

public class ObservadorException extends RuntimeException {

	public ObservadorException(Exception e, String msg) {
		super(msg, e);
	}

	public ObservadorException(String msg) {
		super(msg);
	}

}
