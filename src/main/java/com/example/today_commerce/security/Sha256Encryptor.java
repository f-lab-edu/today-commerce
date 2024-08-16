package com.example.today_commerce.security;

import java.security.MessageDigest;
import org.springframework.stereotype.Component;

@Component
public class Sha256Encryptor implements Encryptor {

    private static final String SHA_256 = "SHA-256";

    @Override
    public String encrypt(String target) {
        try {
            MessageDigest md = MessageDigest.getInstance(SHA_256);
            byte[] targetBytes = target.getBytes();
            md.reset();
            byte[] digested = md.digest(targetBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b :digested) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("암호화 수행 중 문제가 발생하였습니다.", e);
        }
    }
}
