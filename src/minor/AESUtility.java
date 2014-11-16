/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minor;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author brij
 */
public class AESUtility {
    
    private static SecretKeySpec secretKey ;
    private static byte[] key ;
    private static String decryptedString;
    private static String encryptedString;
    public static void setKey(String myKey){
    
    MessageDigest sha;
        try {
            key = myKey.getBytes("UTF-8");
            System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            System.out.println(key.length);
            System.out.println(new String(key,"UTF-8"));
            secretKey = new SecretKeySpec(key, "AESUtility");
        
        
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    
         
    
}
public static String getDecryptedString() {
        return decryptedString;
    }
    public static void setDecryptedString(String decryptedString) {
        AESUtility.decryptedString = decryptedString;
    }
public static String getEncryptedString() {
        return encryptedString;
    }
    public static void setEncryptedString(String encryptedString) {
        AESUtility.encryptedString = encryptedString;
    }
    public static String encrypt(String strToEncrypt)
{
try
{
Cipher cipher = Cipher.getInstance("AESUtility/ECB/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
}
catch (UnsupportedEncodingException e)
{
System.out.println("Error while encrypting: "+e.toString());
}       catch (InvalidKeyException e) {
    System.out.println("Error while encrypting: "+e.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error while encrypting: "+e.toString());
        } catch (BadPaddingException e) {
            System.out.println("Error while encrypting: "+e.toString());
        } catch (IllegalBlockSizeException e) {
            System.out.println("Error while encrypting: "+e.toString());
        } catch (NoSuchPaddingException e) {
            System.out.println("Error while encrypting: "+e.toString());
        }
return null;
}
public static String decrypt(String strToDecrypt)
{
try
{
Cipher cipher = Cipher.getInstance("AESUtility/ECB/PKCS5PADDING");
cipher.init(Cipher.DECRYPT_MODE, secretKey);
setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
}
catch (InvalidKeyException e)
{
System.out.println("Error while decrypting: "+e.toString());
}       catch (NoSuchAlgorithmException e) {
    System.out.println("Error while decrypting: "+e.toString());
        } catch (NoSuchPaddingException e) {
            System.out.println("Error while decrypting: "+e.toString());
        }
return null;
}
public static void main(String args[])
{
final String strToEncrypt = "My text to encrypt";
final String strPssword = "encryptor key";
AESUtility.setKey(strPssword);
AESUtility.encrypt(strToEncrypt.trim());
System.out.println("String to Encrypt: " + strToEncrypt);
System.out.println("Encrypted: " + AESUtility.getEncryptedString());
final String strToDecrypt = AESUtility.getEncryptedString();
AESUtility.decrypt(strToDecrypt.trim());
System.out.println("String To Decrypt : " + strToDecrypt);
System.out.println("Decrypted : " + AESUtility.getDecryptedString());
}
    
}
