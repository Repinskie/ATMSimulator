package org.repinskie.service.cryptorInterface;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Class for hashing PIN codes.
 */
public class PinCodeEncryptor {
    /**
     * Hashes a PIN code using the SHA-256 algorithm.
     *
     * @param pinCode PIN code to hash
     * @return  Hashed PIN code
     */
    public static String hashPinCode(String pinCode){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(pinCode.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashBytes){
                stringBuilder.append(String.format("%02x", b));
            }
            return  stringBuilder.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
}
