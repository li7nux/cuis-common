package me.olddriver.cuis.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author <a href="mailto:Li7nux@gmail.com">Li7nux</a>
 * Date: 2018-01-03 14:51
 * Description: MD5 工具类
 */
public class MD5Util {

    /**
     * MD5 加密，默认返回32位大写结果
     *
     * @param sourceStr 待加密字符串
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException 算法不可用
     */
    public static String encrypt(String sourceStr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(StandardCharsets.UTF_8.encode(sourceStr));
        byte[] md = messageDigest.digest();
        return String.format("%032x", new java.math.BigInteger(1, md)).toUpperCase();
    }

}
