/*
 * DuyDuc94
 */
package Function;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author duy20
 */
public class HandleLanguage {
    public String getWord(Locale locale, String keyWord){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Resources." + locale, locale);
        return resourceBundle.getString(keyWord);
    }
}
