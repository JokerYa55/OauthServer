package app.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author vasil
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SessionContext {
    private String userId;
    private Date sessionStart;
}
