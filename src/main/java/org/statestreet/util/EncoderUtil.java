package org.statestreet.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncoderUtil {

    private static final String ENCODER_KEY="IdeathonXKey";


    public static String getEncodedString(String dataToEncode){
        return Base64.getEncoder().encodeToString((dataToEncode + ENCODER_KEY).getBytes());
    }

    public static void main(String args[]){
        System.out.println(getEncodedString("password"));
        System.out.println(getDecodedString("cGFzc3dvcmRJZGVhdGhvblhLZXk="));

    }

    public static String getDecodedString(String dataToDecode){
        byte[] decodedBytes = Base64.getDecoder().decode(dataToDecode);
        String decoded = new String(decodedBytes);
        return decoded.substring(0,decoded.indexOf(ENCODER_KEY));
    }
}
