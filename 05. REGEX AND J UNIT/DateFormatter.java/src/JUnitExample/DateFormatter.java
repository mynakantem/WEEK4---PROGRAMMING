package JUnitExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false); // Strict date parsing

        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}
