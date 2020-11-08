package app.logging;

import app.model.user.LoggerItem;
import java.util.Date;
import java.util.Map;
import lombok.Getter;
import org.json.simple.JSONObject;

/**
 *
 * @author vasil
 */
@Getter
public class LoggerBuilder {

    private final LoggerItem logItem;

    public LoggerBuilder() {
        this.logItem = new LoggerItem();
    }

    public LoggerBuilder setDate(Date date) {
        this.logItem.setEventDate(date);
        return this;
    }

    public LoggerBuilder setType(EventType type) {
        this.logItem.setType(type);
        return this;
    }

    public LoggerBuilder setId(Long id) {
        this.logItem.setId(id);
        return this;
    }

    public LoggerBuilder setJsonDetails(Map<String, Object> details) {
        this.logItem.setJsonDetails((new JSONObject(details)).toJSONString());
        return this;
    }

    public LoggerBuilder setUserId(String userId) {
        this.logItem.setUserId(userId);
        return this;
    }

    public LoggerBuilder setSeesionId(String sessionId) {
        this.logItem.setSessionId(sessionId);
        return this;
    }

    public LoggerBuilder setErrror(String error) {
        this.logItem.setError(error);
        return this;
    }

}
