package app.credentionls;

/**
 *
 * @author vasil
 */
public interface CredentionalInterface {

    /**
     *
     * @param password - пароль сохраненный у пользователя
     * @param inputCredentional - пароль введенный пользователем
     * @return
     */
    public boolean isValid(String password, String inputCredentional);
}
