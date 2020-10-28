package IplLeagueProblem;

import OpenCSV.CSVException.ExceptionType;

public class IPLLeagueException extends Exception {
	public enum ExceptionType {
        FILE_PROBLEM
    }

    public ExceptionType type;

    public IPLLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLLeagueException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
    
    public IPLLeagueException(String message, String name) {
		super(message);
		this.type = ExceptionType.valueOf(name);
	}
}
