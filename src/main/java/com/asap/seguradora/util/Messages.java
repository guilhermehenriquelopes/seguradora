package com.asap.seguradora.util;

import java.text.MessageFormat;

public final class Messages {

    public static final String NOT_FOUND_RESULT = "Nenhum registro encontrado";
    public static final String OK = "Requisição bem sucedida";

    public static String formatMessage(String messageString, Object arg0) {
        MessageFormat mf = new MessageFormat(messageString);
        Object[] args = new Object[1];
        args[0] = arg0;

        return mf.format(args);
    }
}
