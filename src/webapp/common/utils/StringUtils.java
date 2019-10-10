package webapp.common.utils;


/**
 * This class illustrated how we could create some Utils into the project
 * Note : Does the same work than Apache commons-lang3 or Guava libs
 * Date : 10/10/2019
 * Time : 01:10
 */
public class StringUtils {

    /** Empty checks
     * It no longer trims the CharSequence.
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is empty or null
     */
    public static boolean isNullOrEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
