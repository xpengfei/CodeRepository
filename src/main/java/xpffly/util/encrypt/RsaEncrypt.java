package xpffly.util.encrypt;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xpengfei
 * @Date: 2019/11/5 16:44
 * @Description：RSA非对称加解密实现公私钥加解密
 */
public class RsaEncrypt {
    private static Map<Integer,String> keyMap = new HashMap<>();//存储生成的公私钥
    public static void main(String[] args) throws NoSuchAlgorithmException {
        genKeyPair();
    }

    //生成公私钥对
    public static void genKeyPair() throws NoSuchAlgorithmException {
        /*创建非对称加密的公钥和私钥示例 将生成的公钥和私钥用Base64编码后打印出来*/
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); //一般加密位数为1024 对安全要求较高的情况下可以使用2048
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 将公钥和私钥保存到Map
        keyMap.put(0,Base64.encodeBase64String(publicKey.getEncoded()));  //0表示公钥
        keyMap.put(1,Base64.encodeBase64String(privateKey.getEncoded()));  //1表示私钥
        System.out.println("Base64编码后的公钥："+Base64.encodeBase64String(publicKey.getEncoded()));
        System.out.println("公钥："+publicKey);
        System.out.println("Base64编码后的私钥："+Base64.encodeBase64String(privateKey.getEncoded()));
        System.out.println("私钥："+privateKey);
    }
}
