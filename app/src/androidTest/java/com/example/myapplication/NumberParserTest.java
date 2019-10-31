package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class NumberParserTest {

    private Map<String, Integer> countryCodes;
    private Map<String, String> prefixes;

    @Before
    public void setUp(){

        countryCodes  = new HashMap<>();
        prefixes = new HashMap<>();

        countryCodes.put("GB", 44); prefixes.put("GB", "0");

        countryCodes.put("US", 1);prefixes.put("US", "1");

        countryCodes.put("DE",49);prefixes.put("DE","2");

        countryCodes.put("FR", 33);prefixes.put("FR", "3");

    }
    @Test
    public void numbersReturnInternationalFormat() {

        NumberParser parser = new NumberParser(countryCodes, prefixes);
        assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
        assertEquals("+442079460056", parser.parse("+442079460056", "+441614960148"));
        assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
        assertEquals("+33722226361", parser.parse("3722226361", "+3344562726"));
        assertEquals("+49722226361", parser.parse("2722226361", "+4944562726"));


    }
}
