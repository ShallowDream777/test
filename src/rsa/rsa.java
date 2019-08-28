package rsa;

import com.icbc.api.internal.util.codec.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class rsa {
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥

//    protected static final String MY_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCyXA5t2IatLbMbT9MJya6myxMpkEt2IduY6Ydoqk9Gk/vOqgWz7W9akt6rTzh6YEtXMzFsTsOoAlH1pfo/+xixr7JefVgOiwT4UKmTueSs8XZ5yQG8pmMCBeuYsVxJP/mtumyQZWHR5WGrb8gEL56DY8iHESK5UQJERusSXq/E87EE8CSyOmrgN3jxKl33eNTq/+CyleLjTveyo8JQ84tXRIlkfeTFm2O4RJPG41u/IHQLkCoYJVZyvlTZv6j/TCfmbAAuqXrKYQqRH05dLFJeoLTsVDKeDoieSYVnq0VNHNUuxd337df7ukJemzQw0YewVWLKSmMhBdNKqvXkI7YBAgMBAAECggEAGxTtP/KTqHH68xewxJiyAzNsinAVdS9454P2AodxmBbaMiwQx5wyvz7zvnE98x7x8aCdTYO8I6OOjE0SbWqT+k7iN4SyvSqQq5+b0Al21menhKBnuhxNhj4d4sZza8/h+mYHG/m426UHqn9DkJcma27YQOHyMs9BF9ro0JY9/Bp+7GdRpkDP35+Wrge8H1PCEzMmTZE1QCmxubBqKkSoGbhHMVUXKtPyWHNEOWAhLu8kBCKhGMoAMIUgb5N1GD+1ezoUSJOrdOaH63TrRM79r3/EI2qaZoDWWNtrpr/gxihzEQD3kUi0dcfSMrW5PFNWoP09oOqOIN/vZH6Fhx5orQKBgQD1xwPhCCYtMRKHX+7B2O950NechGr4T+M9oelMsTnajHKYxCxI7TTprfEMrDdDTWdkr39lHNXxmQJe8vQI30iwLTSMlaVUmpjEBwX5E6GLAl77F5uHaxyKK2UVDG3rxKNeJzC9ratysjZw99tfdPqTJPOcqNc5VXZJU2ErBWt8+wKBgQC5xzDf1SHzHmxgiJqcvDBb7S6vVi8qcbIDZoVqhLezQJWQKd5lBnJvU/1uVtYeE5vPjUngFhAOk+E9HnGRKPik2UHBK66BmjYazjMx5S2WFRY7guS3aoh+xzp0KNQkdZX2skYofX+n7k8N6854c/9sa2HPO9B4dFJuwzH4NWRwMwKBgQD01wB3Qc3+QR+LOrc35yuRt8nDA2so2TSwZkZqfzb6D+XtZ6gSMjP/Aqfajwkyg76XX/lSOiqrVlk1S2RuHjlkQHRUBJPCN4wt5C1AFx1bxM3n53mpqruwrVAyasJqF+cDWZlFq+fbB8wSN+gTLQ6eXTZOfyiA1jFTFLv8xpZw1wKBgQCDpMrVUcpE5QIXRbWJ6zC5c1DpnkC96uMh1bwkxvcFZnaVOZYGMJNWoEWtsor3tR1r7cqzp+6o5dFt5ezD2CyZY/pcT//Qht5gEE3mxWeQOlEOyqoX7r3aWILrXSM20rv5nEpq1sNm1E/gpYAhitEsmsssdk47jPH82wTFxc/uUQKBgQDYCWvXIULD9jv/mIFP9dVaO23YyJ+wp0StthCas6XrTfgVigvhzJX52ETQAfVF1pkQyjXQlRKWXDhdP1qQk5/dJxE/CauboZEjlvi3zbx8iF7ueZ4f+ecKIcJhZO4TomQF+Dvd0niszM63UlvoNwr6uRewR/iSrcWISFwCpT/2Mg==";
//
//    protected static final String MY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAslwObdiGrS2zG0/TCcmupssTKZBLdiHbmOmHaKpPRpP7zqoFs+1vWpLeq084emBLVzMxbE7DqAJR9aX6P/sYsa+yXn1YDosE+FCpk7nkrPF2eckBvKZjAgXrmLFcST/5rbpskGVh0eVhq2/IBC+eg2PIhxEiuVECREbrEl6vxPOxBPAksjpq4Dd48Spd93jU6v/gspXi4073sqPCUPOLV0SJZH3kxZtjuESTxuNbvyB0C5AqGCVWcr5U2b+o/0wn5mwALql6ymEKkR9OXSxSXqC07FQyng6InkmFZ6tFTRzVLsXd9+3X+7pCXps0MNGHsFViykpjIQXTSqr15CO2AQIDAQAB";


    protected static final String MY_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHXDyVfz8KdLtGoKpve09s2G2j71H2ukg0cvqShVsqUWtrvt8+xtekWfj6R7CBydeHuoj9EXUCX40rVeqgw/2n4btGsSmreCxojTvujo3p8rrZ8H8o5qq8cJvqo6TmaxujCxMOma4NSqLuG+/bT9vwmpBFKKayiAJAWrUE24cRxFEDanG4y7ALAovl1lYIyvtbkwPznSOBwktBpstXfWOygoS/St4RecHM6PFYykokM2Yw+W7FwDXvncNkKKnMs1NLGCPvb2InHgyh8U/QopRYvGIjZQd0hZwPMQUuIrm9g7qCImMQ9J1KGKMQ5Yr+NZlNkrqZYf3FCsKKXUI0e1oBAgMBAAECggEAKmaRL78xTyQrub8ARHWa9pyBE7YWtbO6hHtz1Evjt8jTXmfm5HJDAF+Sp0unlbBVTFX5LVS3k2u8+9Mo8P0Tyu/hyw4Z4HV/a6y6FksfVyZKs5QrMPO4jdi0bnaeY/MvMA57BLrNE6rKiM3Ff6xvV9oC0TcfqJMEKYaAZ6ogkEa6jVnv070eYBXxKg6BDNd92G9yYpb6SOz6T0xc0H3imXXeiIvPlcPWeKKHOrfAzv5xSJApdvtds51TYoPGP6OnOmuOrzD2NrE566a1K7mDMxdBLiYHPRAANEAL4bK3yP9Z5fYcGo+LFFuQY5Q0HK1P37G+OA6/L7R7CbpkHQl9FQKBgQDLEkBozOHZYlJaXUqgjZKvWekzulN4f2oUqHCjxIP2LIdH3C4/Qyi072okgqAh+mDwNAC1VB4pEvTrhSlCVCJuiwjGEjtNGxQRyVXBNC/zxGoJhO/fztjQBDZNoj06g39U5M6qMwgsJKUiZdJtC3nDZ+z/Iv+J55cqX5nnUum2gwKBgQCqpAe2+L7zwwJBq3dhlxiwXga0s6DGDuLkGtr/DENMyO2IgETcI7T+5Ip8g2AfBqDQTztQkWi6lYRUoxbJ58BOiKIAg/vcliDK6Y8p+LS7iEhEUzKVlT+xN2hNmmd+DtgBI3fvR0BCKPKAfezf9eImRGaFp/qV5yhQsquJ+cDmKwKBgAavzSsmQ/GSiT+sfr6WqtPXVBR9+C2plGalvT/HQskiYjn9iBBRN8/takNVgcxcoECIldVitbOIikQPGHK0roWRUnKjOwyo7ZpAVPCNtV6DgzJZDEUEXKNM4DTiOL3qgpDbD+sOzyAU/NMLI0iv7gx/KZClKGD0HUgp6blyQ3vdAoGAbX37BUjvHfKPTBv96jzNtr1eiCyKiQucQsmIpAb2WBrFb8T+alLvHG8A/Yw+7SmPnpp4cOYc0TyHQNe1E7EFEF9TtAj8XzplqE3dcw0Gyx5TYKQR3TF7QPdQkhr1NUnJCFH97ydE8C7eC9zBVaOsjOlu72wtumos0DsVHt+HCykCgYA6/aMl9c17MgnxZLygotk6aqdLYZsU7nKl7cIOcb9quX0YgyspiQ+CJbvtJap+gjrp2AkGA+YfeYp4VkOBud0WF61+KwI9bBzk2wXwYVINvpO4weGKhwyydxS7GpqifZEZvjckLRxEWCVD35W5K1JlUa5aY6f9o6ajKYEk2sqHVg==";

    protected static final String MY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh1w8lX8/CnS7RqCqb3tPbNhto+9R9rpINHL6koVbKlFra77fPsbXpFn4+kewgcnXh7qI/RF1Al+NK1XqoMP9p+G7RrEpq3gsaI077o6N6fK62fB/KOaqvHCb6qOk5msbowsTDpmuDUqi7hvv20/b8JqQRSimsogCQFq1BNuHEcRRA2pxuMuwCwKL5dZWCMr7W5MD850jgcJLQabLV31jsoKEv0reEXnBzOjxWMpKJDNmMPluxcA1753DZCipzLNTSxgj729iJx4MofFP0KKUWLxiI2UHdIWcDzEFLiK5vYO6giJjEPSdShijEOWK/jWZTZK6mWH9xQrCil1CNHtaAQIDAQAB";



    String SIGN = "dZ8Dyr28uIakTvjUrOfF1HdvMzYrBL8ocKZjAxQ1TuVIhEj+eNfgFUve2f4fbDNOs0kaD1zo7Q/IplZ6uawXmbn4qHjbB6jP3NodrGzuQq9kLpkwGElY+8qb3m8TomAE0OHp1p9718rS0Vu1Mr5nHGLMDsUefctAZeteBrhbq7s=";

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "df723820";
//        System.out.println("随机生成的公钥为:" + keyMap.get(0));
//        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message,MY_PUBLIC_KEY);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt("",MY_PRIVATE_KEY);
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0,publicKeyString);  //0表示公钥
        keyMap.put(1,privateKeyString);  //1表示私钥
    }
    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
