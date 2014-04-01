package common;

/**
 * A generic request object for use by the Client.
 * Stores a session ID for state and a payload. The payload
 * could be either a PK or a Hash, we don't care.
 * @author scottflo
 *
 */
public class Request {
	private String uuid;
	private String payload;
	
	public Request(String uuid, String payload) {
		this.uuid = uuid;
		this.payload = payload;
	}
	
	public String getUUID() {
		return uuid;
	}
	
	public String getPayload() {
		return payload;
	}

}
