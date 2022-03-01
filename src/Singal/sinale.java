package Singal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;


public class sinale {

    public static void main(String[] args) {
        String sha256Signature = getShaSignature("f8c66d3be25151dc2a089397c46bdc72ca1a5426d2d3910eb94d2419a637a8e9");
        System.out.println(sha256Signature);
    }

    private static String getShaSignature(String signature) {
        char[] list = signature.toCharArray();
        StringBuilder appString = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (list[i] >= 'a' && list[i] <= 'z') {
                list[i] -= 32;
            }
            appString.append(list[i]);
            if (i%2 == 1 && i != list.length - 1) {
                appString.append(":");
            }
        }
        return appString.toString();
    }
/*       private static String getShaSignature(byte[] array) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA256");
            // get public key
            byte[] publicKey = md.digest(array);
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(appendString);
                hexString.append(":");
            }
            hexString.deleteCharAt(hexString.length() - 1);
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }*/

}
