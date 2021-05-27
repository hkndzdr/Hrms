package hakandizdar.hrms.core.utilities.concrete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	 
	public static boolean emailValidate(String email) {
	        final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
	        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }

}
