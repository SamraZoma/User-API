package com.api.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Util {
    private static final String SALT = "450d0b0db2bcf4adde5032eca1a7c416e560cf44";

	public static String encryptID(String emailAddress) {

		String input = emailAddress + SALT;

        try {
            // Create a MessageDigest instance for SHA-1
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

            // Get the hashed bytes
            byte[] hashedBytes = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the bytes to a hexadecimal string
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }

            return hexStringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating ID", e);
        }
	}

}
