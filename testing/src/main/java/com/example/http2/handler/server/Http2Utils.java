package com.example.http2.handler.server;

public class Http2Utils {
    protected static String[] getInterfaceIdAndMethod(String uri) {
        String[] result;
        int i = uri.indexOf('?');
        if (i > 0) {
            uri = uri.substring(0, i);
        }
        String[] end = uri.split("/");
        if (end.length < 3) {
            System.out.println("URL 不对");
        }
        int resultLength = 2;
        result = new String[resultLength];
        //从第二个元素开始copy 第一个是空字符串
        System.arraycopy(end, 1, result, 0, resultLength);
        return result;
    }
}
