package com.yang.utils;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUtil {
    /**
     * 过滤特殊字符
     * @param string
     * @return
     * @throws PatternSyntaxException
     */
    public static String stringFilter(String string) throws PatternSyntaxException{
        //要过滤的字符
        String strEx="[=\\\\<>]";
        Pattern p=Pattern.compile(strEx);
        Matcher m=p.matcher(string);
        return m.replaceAll("").trim();
    }
}
