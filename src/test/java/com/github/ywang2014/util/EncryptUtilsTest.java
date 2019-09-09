package com.github.ywang2014.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangyong.1991
 * @version 创建时间：2019/9/9 下午2:15
 */
public class EncryptUtilsTest {

    @Test
    public void md5Hex() throws Exception {
        String md5 = EncryptUtils.md5Hex("");
        Assert.assertEquals(md5, "d41d8cd98f00b204e9800998ecf8427e");
        md5 = EncryptUtils.md5Hex("test");
        Assert.assertEquals(md5, "098f6bcd4621d373cade4e832627b4f6");
        md5 = EncryptUtils.md5Hex("098f6bcd4621d373cade4e832627b4f6");
        Assert.assertEquals(md5, "fb469d7ef430b0baf0cab6c436e70375");
        md5 = EncryptUtils.md5Hex("fb469d7ef430b0baf0cab6c436e70375fb469d7ef430b0baf0cab6c436e70375");
        Assert.assertEquals(md5, "255c3d1dae7e7e964464dc8a5c2e33df");
    }

    @Test
    public void shaHex() throws Exception {
        String sha = EncryptUtils.shaHex("");
        Assert.assertEquals(sha, "da39a3ee5e6b4b0d3255bfef95601890afd80709");
        sha = EncryptUtils.shaHex("test");
        Assert.assertEquals(sha, "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3");
        sha = EncryptUtils.shaHex("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3");
        Assert.assertEquals(sha, "c4033bff94b567a190e33faa551f411caef444f2");
        sha = EncryptUtils.shaHex("c4033bff94b567a190e33faa551f411caef444f2c4033bff94b567a190e33faa551f411caef444f2");
        Assert.assertEquals(sha, "6693bec4d99ba6d86a5a2c6258f957b5a5ec33ea");
    }
}