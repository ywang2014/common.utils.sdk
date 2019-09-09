package com.github.ywang2014.util;

import com.github.ywang2014.common.Charset;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangyong.1991
 * @version 创建时间：2019/9/6 下午4:37
 */
public class EncryptUtils {
    private EncryptUtils() {
        // default constructor
    }

    /**
     * md5加密
     *
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String md5Hex(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return toHex(md5.digest(value.getBytes(Charset.UTF8)));
    }

    /**
     * sha1加密
     *
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String shaHex(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(value.getBytes(Charset.UTF8));
        return toHex(md.digest());
    }

    /**
     * 十六进制编码
     * @param bytes
     * @return
     */
    private static String toHex(byte[] bytes){
        final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        StringBuilder buffer = new StringBuilder(bytes.length * 2);
        for (byte b : bytes){
            buffer.append(HEX_DIGITS[(b >> 4) & 0x0f]);
            buffer.append(HEX_DIGITS[b & 0x0f]);
        }
        return buffer.toString();
    }
}
