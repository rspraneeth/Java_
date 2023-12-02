package com.rsp.coreservlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

//time saver static methods
public class ServletUtilities extends HttpServlet {
    public static String headWithTitle(String title) {
        return "<!DOCTYPE html>\n" +
                "<html><head><title>" + title + "</title></head>\n";
    }

    public static int getIntParameter(HttpServletRequest request, String paramName, int defaultValue) {
        String paramString = request.getParameter(paramName);
        int paramValue;
        try {
            paramValue = Integer.parseInt(paramString);
        } catch (Exception e) {
            paramValue = defaultValue;
        }
        return paramValue;
    }

    public static double getDoubleParameter(HttpServletRequest request, String paramName, double defaultValue) {
        String paramString = request.getParameter(paramName);
        double paramValue;
        try {
            paramValue = Double.parseDouble(paramString);
        } catch (Exception e) {
            paramValue = defaultValue;
        }
        return paramValue;
    }

    public static String filter(String input) {
        if (!hasSpecialChars(input)) {
            return (input);
        }
        StringBuilder filtered = new StringBuilder(input.length());
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            switch (c) {
                case '<':
                    filtered.append("&lt;");
                    break;
                case '>':
                    filtered.append("&gt;");
                    break;
                case '"':
                    filtered.append("&quot;");
                    break;
                case '&':
                    filtered.append("&amp;");
                    break;
                default:
                    filtered.append(c);
            }
        }
        return (filtered.toString());
    }

    private static boolean hasSpecialChars(String input) {
        boolean flag = false;
        if ((input != null) && (!input.isEmpty())) {
            char c;
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                switch (c) {
                    case '<':
                    case '>':
                    case '"':
                    case '&':
                        flag = true; break;
                }
            }
        }
        return (flag);
    }
}
