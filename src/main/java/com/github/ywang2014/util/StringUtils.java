package com.github.ywang2014.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author wangyong.1991
 * @version 创建时间：2019/9/9 上午10:30
 */
public class StringUtils {
    private StringUtils() {
        // default constructor
    }

    /**
     * 正则表达式匹配
     *
     * @param str 验证的字符串
     * @param pattern 匹配规则：正则表达式
     * @return true or false
     */
    public static boolean regexMatch(String str, String pattern) {
        return str != null && pattern != null && Pattern.matches(pattern, str);
    }

    /**
     * 验证手机号合法性
     *  11位数字
     *  1开头，第二位必须是3-9，其他无限制
     *
     * @param mobile 手机号
     * @return true or false
     */
    public static boolean validMobile(String mobile) {
        return regexMatch(mobile, "^(1[3-9][0-9])\\d{8}$");
    }

    /**
     * 邮箱校验
     *  域名白名单增加校验
     *
     * @param email 邮箱
     * @return true or false
     */
    public static boolean validEmail(String email) {
        String pattern = "/^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/";
        boolean checkFormat = regexMatch(email, pattern);
        List<String> domainWhiteList = Arrays.asList("qq.com", "163.com", "vip.163.com", "263.net", "yeah.net", "126.com", "sohu.com", "sina.cn", "sina.com", "eyou.com", "gmail.com", "hotmail.com", "42du.cn");
        if (checkFormat) {
            String domain = email.substring(email.indexOf("@") + 1);
            return domainWhiteList.contains(domain);
        }
        return false;
    }

    /**
     * 正整数识别
     *  无符号、非小数、非零开头
     *
     * @param number 数字
     * @return true or false
     */
    public static boolean validDigit(String number) {
        return regexMatch(number, "^([1-9][0-9]*)$");
    }
}
