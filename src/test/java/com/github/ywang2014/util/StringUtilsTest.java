package com.github.ywang2014.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangyong.1991
 * @version 创建时间：2019/9/9 下午2:15
 */
public class StringUtilsTest {

    @Test
    public void regexMatch() {
    }

    @Test
    public void validMobile() {
        Assert.assertTrue(StringUtils.validMobile("13600000000"));
        Assert.assertFalse(StringUtils.validMobile("12600000000"));
        Assert.assertFalse(StringUtils.validMobile("10000000000"));
        Assert.assertFalse(StringUtils.validMobile("1000000000000"));
        Assert.assertFalse(StringUtils.validMobile("10000000"));
    }

    @Test
    public void validEmail() {
        Assert.assertTrue(StringUtils.validEmail("test@163.com"));
        Assert.assertFalse(StringUtils.validEmail("163@100.com"));
        Assert.assertFalse(StringUtils.validEmail("163@163@163.com"));
    }

    @Test
    public void validDigit() {
        Assert.assertTrue(StringUtils.validDigit("1234567"));
        Assert.assertFalse(StringUtils.validDigit("01234567"));
        Assert.assertFalse(StringUtils.validDigit("00"));
        Assert.assertTrue(StringUtils.validDigit("0"));
    }
}