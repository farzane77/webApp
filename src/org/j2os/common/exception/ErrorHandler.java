package org.j2os.common.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {
    public static Map<String, String> getError(Exception e) {
        e.printStackTrace();
        Map<String, String> map = new HashMap<>();
        if (e instanceof ArithmeticException) {
            map.put("code", "101");
            map.put("message", "KHATAYE SEFR");
        } else if (e instanceof ValidationException) {
            map.put("code", "102");
            map.put("message", "KHATAYE VORODI");
        } else if (e instanceof SQLException) {
            map.put("code", "103");
            map.put("message", "KHATAYE DATABASE");
        } else {
            map.put("code", "500");
            map.put("message", "KHATAYE NASHENAKHTE");
        }
        return map;
    }
}
