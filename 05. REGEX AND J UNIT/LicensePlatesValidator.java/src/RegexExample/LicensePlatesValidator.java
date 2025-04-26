package RegexExample;

import java.util.regex.*;
public class LicensePlatesValidator {
	    public static void main(String[] args) {
	        String[] plates = {
	            "AB1234",   // valid
	            "A12345",   // invalid - only 1 letter
	            "AB123",    // invalid - only 3 digits
	            "ab1234",   // invalid - lowercase letters
	            "XY9876"    // valid
	        };

	        Pattern pattern = Pattern.compile("^[A-Z]{2}\\d{4}$");

	        for (String plate : plates) {
	            if (pattern.matcher(plate).matches()) {
	                System.out.println("✅ \"" + plate + "\" is valid");
	            } else {
	                System.out.println("❌ \"" + plate + "\" is invalid");
	            }
	        }
	    }

}
