package com.bruno.jdbiproject.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistryCreator {

    public static String getRegistryNumber(Date registrationDate){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String registry = formatter.format(registrationDate);

        return registry;
    }

}
