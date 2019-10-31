package com.example.myapplication;

import java.util.Map;

public class NumberParser {
    private static final String PLUS = "+";
    private static final int OFFSET = 1;

    private Map<String, Integer> callingCodes;
    private Map<String, String> prefixes;

    public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {
        this.callingCodes = callingCodes;
        this.prefixes = prefixes;
    }

    public String parse(String dialledNumber, String userNumber) {
        //dialledNumber is already in international format
        if (isNumberInternational(dialledNumber)) {
            return dialledNumber;
        } else {
            //Check the dialledNumber prefixKey, and associated callingCode
            for (String key : prefixes.keySet()) {
                if (userNumber.startsWith(callingCodes.get(key).toString(), OFFSET)) {
                    dialledNumber = PLUS + callingCodes.get(key)
                            + dialledNumber.substring(prefixes.get(key).length());
                    break;
                }

            }
            return dialledNumber;
        }

    }

    // number is international
    private boolean isNumberInternational(String number) {
        return number.startsWith(PLUS);
    }


}
