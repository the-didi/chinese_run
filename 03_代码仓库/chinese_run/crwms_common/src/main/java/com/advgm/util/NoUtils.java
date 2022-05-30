package com.advgm.util;

import java.util.Date;

public class NoUtils {
    public static String getNo(String columnName){
        return columnName+new Date().getTime();
    }
}
