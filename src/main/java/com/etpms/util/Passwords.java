package com.etpms.util;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
public final class Passwords {
 private Passwords(){}
 public static String salt(){byte[] b=new byte[16];new SecureRandom().nextBytes(b);return Base64.getEncoder().encodeToString(b);}
 public static String hash(String p,String s){try{PBEKeySpec spec=new PBEKeySpec(p.toCharArray(),Base64.getDecoder().decode(s),210000,256);byte[] h=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();spec.clearPassword();return Base64.getEncoder().encodeToString(h);}catch(Exception e){throw new IllegalStateException("Password hashing failed",e);}}
 public static boolean verify(String p,String salt,String expected){return java.security.MessageDigest.isEqual(hash(p,salt).getBytes(java.nio.charset.StandardCharsets.UTF_8),expected.getBytes(java.nio.charset.StandardCharsets.UTF_8));}
}
