package io.grundner.wifiqr;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class QrService {
    
    private static final char SEPARATOR_VALUE = ':';
    private static final char SEPARATOR_FIELD = ';';

    private static final String QR_WIFI = "WIFI";
    private static final String QR_WIFI_AUTHENTICATION_TYP = "T";
    private static final String QR_WIFI_SSID = "S";
    private static final String QR_WIFI_PASSWORD = "P";
    private static final String QR_WIFI_HIDDEN = "H";


    public String generateUrl(String ssid, String password, boolean hidden) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(QR_WIFI).append(SEPARATOR_VALUE)
                     .append(QR_WIFI_AUTHENTICATION_TYP).append(SEPARATOR_VALUE).append("WPA").append(SEPARATOR_FIELD)
                     .append(QR_WIFI_SSID).append(SEPARATOR_VALUE).append(ssid).append(SEPARATOR_FIELD)
                     .append(QR_WIFI_PASSWORD).append(SEPARATOR_VALUE).append(StringUtils.hasText(password) ? password : "").append(SEPARATOR_FIELD)
                     .append(QR_WIFI_HIDDEN).append(SEPARATOR_VALUE).append(hidden).append(SEPARATOR_FIELD);
        return stringBuilder.toString();
    }
}
