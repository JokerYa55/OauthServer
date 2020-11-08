package app.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author vasil
 */
@Getter
@Setter
@ToString
public class AuthContext {
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("redirect_uri")
    private String redirectUri;
    @JsonIgnore
    private SessionContext sessionContext = new SessionContext();
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("user_agent")
    private String userAgent;
    
}
