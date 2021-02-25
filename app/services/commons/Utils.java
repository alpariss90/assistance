package commons;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class Utils {

    static public boolean isNullOrEmpty(String obj) {
        if (null == obj || obj.trim().isEmpty()) return true;
        return false;
    }



        //LocalDate

        public static String localDateAsString(LocalDate date) {
            return localDateAsString(date, "dd/MM/yyyy");
        }

        public static String localDateAsString(LocalDate localDate, String pattern) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return formatter.format(localDate);
        }

        public static LocalDate stringAsLocalDate(String dateAsString) {
            if (null == dateAsString) {
                return null;
            }
            String lDateAsString = dateAsString.trim();
            lDateAsString = lDateAsString
                    .replace("-", "/")
                    .replace(".", "/")
                    .replace(" ", "/");
            if (lDateAsString.length() > 10) {
                lDateAsString = lDateAsString.substring(0, 10);
            }
            return stringAsLocalDate(lDateAsString, "dd/MM/yyyy");
        }


        public static LocalDate stringAsLocalDate(String dateAsString, String pattern) {
            if (null == dateAsString && null == pattern) {
                return null;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(dateAsString, formatter);
        }


        //LocalDateTime

        public static LocalDateTime shortStringAsLocalDateTime(String dateAsString) {
            if (null == dateAsString) {
                return null;
            }
            LocalDate localDate = stringAsLocalDate(dateAsString);
            return LocalDateTime.of(localDate, LocalTime.of(0, 0));
        }

        public static String localDateTimeAsShortString(LocalDateTime localDateTime) {
            if (null == localDateTime) {
                return null;
            }
            return localDateAsString(localDateTime.toLocalDate(), "dd/MM/yyyy");
        }

        public static LocalDateTime stringAsLocalDateTime(String dateAsString, String pattern) {
            if (null == dateAsString && null == pattern) {
                return null;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDateTime.parse(dateAsString, formatter);
        }

        /**
         * Check this before use
         *
         * @param localDateTime
         * @return
         */
        public static String localDateTimeAsLongString(LocalDateTime localDateTime) {
            if (null == localDateTime) {
                return null;
            }
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return localDateTime.toString();
        }


    public static String changerFormate(String dateAsString) {
        if (null == dateAsString) {
            return null;
        }
        String lDateAsString = dateAsString.trim();
        lDateAsString = lDateAsString.substring(6,10)+"-"+lDateAsString.substring(3,5)+"-"+lDateAsString.substring(0,2);
        if (lDateAsString.length() > 10) {
            lDateAsString = lDateAsString.substring(0, 10);
        }
        return lDateAsString;
    }


}
