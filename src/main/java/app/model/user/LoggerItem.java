package app.model.user;

import app.logging.EventType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vasil
 */
@Entity
@Data
@Table(name = "t_log")
@NoArgsConstructor
@AllArgsConstructor
public class LoggerItem implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "event_date", unique = true, nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date eventDate;
    @Enumerated(EnumType.ORDINAL)
    EventType type;
    @Column(name = "user_id")
    String userId;
    @Column(name = "json_details")
    String jsonDetails;
    @Column(name = "session_id")
    String sessionId;
    @Column(name = "error")
    String error;
    
}
