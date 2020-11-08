package app.credentionls;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Пароль
 *
 * @author vasil
 */
@Getter
@Setter
@AllArgsConstructor
public class PasswordCredentional implements CredentionalInterface {

    private CredentionalType type;

    @Override
    public boolean isValid(String password, String inputCredentional) {
        return password.equals(inputCredentional);
    }

}
