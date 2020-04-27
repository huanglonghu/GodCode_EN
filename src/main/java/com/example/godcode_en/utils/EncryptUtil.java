package com.example.godcode_en.utils;

import android.util.Base64;

import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class EncryptUtil {

    private static String key="87a4d115c0956912b495d6bb8b7c0013";

    public static String aesEncrypt(String str, String key) throws Exception {
        if (str == null || key == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));

        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public static String aesDecrypt(String str){
        String text=null;
        if (str == null) return null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
            byte[] bytes = Base64.decode(str, Base64.DEFAULT);
            bytes = cipher.doFinal(bytes);
            text = new String(bytes, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    public static String decryptDES(String decryptString, String decryptKey) throws Exception {
        byte[] byteMi = Base64.decode(decryptString.getBytes(), Base64.DEFAULT);
        IvParameterSpec zeroIv = new IvParameterSpec(decryptKey.getBytes());
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);
        return new String(decryptedData);
    }


    public static String encryptByPublic(String content, String key) {
        PublicKey publicKey = RsaHelper.decodePublicKeyFromXml(key);
        String mw = RsaHelper.encryptDataFromStr(content, publicKey);
        return mw;
    }


}