package com.widen.util;

import java.io.*;

public class InternalUtils
{

    static void checkNotNull(Object o, String var)
    {
        if (o == null)
        {
            throw new IllegalArgumentException(var + " cannot be null.");
        }
    }

    static void checkNotBlank(String s, String var)
    {
        if (StringUtilsInternal.isBlank(s))
        {
            throw new IllegalArgumentException(var + " cannot be null or empty.");
        }
    }

    public static byte[] toByteArray(InputStream input) throws IOException
    {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(input, output);
        return output.toByteArray();
    }

    public static long copy(InputStream input, OutputStream output) throws IOException
    {
        int EOF = -1;
        long count = 0;
        int n = 0;
        byte[] buffer = new byte[1024];

        while (EOF != (n = input.read(buffer)))
        {
            output.write(buffer, 0, n);
            count += n;
        }

        return count;
    }

}
