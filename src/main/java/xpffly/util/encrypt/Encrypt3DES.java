package xpffly.util.encrypt;


import com.sun.org.apache.xml.internal.security.utils.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: xpengfei
 * @Date: 2019/7/3 9:21
 * @Description：3des加密解密
 */
public class Encrypt3DES {
    /**
     * 定义 加密算法,可用 DES,DESede,Blowfish
     */
    private static final String Algorithm = "DESede";
    /**
     * 算法/模式/补码方式
     */
    public static final String ALGORITHM_DES = "DESede/CBC/PKCS5Padding";
    // 加解密统一使用的编码方式
    private final static String ENCODING = "utf-8";
    public static void main(String[] args) {
        String Algorithm = "DESede"; // 定义 加密算法,可用 DES,DESede,Blowfish
        String hexString = "0123456789ABCDEF";
        try {
//            System.out.println(encrypt("cc", "abcdefgh6jklmnopqrstuvwx", "01234567"));
//            System.out.println(decrypt("X8TMPYBYbO8=", "abcdefgh6jklmnopqrstuvwx", "01234567"));
//            //412726198009201217|张三|412726200512011318|李四
//            String test = "350424197305051461|刘连香|35042420070307644X|陈晓媛";//350424197305051461|刘连香|35042420070307644X|陈晓媛
            String test = "432322196911040024|侯迈利|430921200407180013|侯俊杰";
            String [] a = test.split("\\|");
            System.out.println(a.length);
            String key = "sPsC6pcZmNX9lMvIzv1XTzTgZ3wNm3V5";
            System.out.println("ECB加密解密");
            byte[] str3 = des3EncodeECB(key.getBytes(),test.getBytes() );
            byte[] str4 = des3DecodeECB(key.getBytes(),str3);
            System.out.println(new BASE64Encoder(

            ).encode(str3));
            System.out.println(new String(str4, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //加密，参数依次为明文-秘钥-向量
    public static String encrypt(String data, String keystr, String iv) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(keystr.getBytes(ENCODING));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Algorithm);
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(data.getBytes());
        return Base64.encode(encryptData);
    }
    //解密，参数依次为-密文-秘钥-向量
    public static String decrypt(String data, String keystr, String iv) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(keystr.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(Algorithm);
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] decryptData = cipher.doFinal(Base64.decode(data));
        return new String(decryptData, ENCODING);
    }

    public static byte[] des3EncodeECB(byte[] key, byte[] data)
            throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] bOut = cipher.doFinal(data);
        return bOut;
    }

    public static byte[] des3DecodeECB(byte[] key, byte[] data)
            throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        byte[] bOut = cipher.doFinal(data);
        return bOut;
    }

    private static String get3DesKey(){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("DESede");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyGenerator.init(168);
        Key key = keyGenerator.generateKey();
        String encrypt = new String(Base64.encode(key.getEncoded()));
        System.out.println("java生成的3des秘钥为：" + encrypt);
        System.out.println("java生成的3des秘钥长度：" + encrypt.length());
        return encrypt;
    }
}
