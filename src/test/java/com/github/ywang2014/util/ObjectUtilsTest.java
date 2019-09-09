package com.github.ywang2014.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyong.1991
 * @version 创建时间：2019/9/8 下午2:03
 */
public class ObjectUtilsTest {

    @Test
    public void isNull() {
        Object obj = null;
        Assert.assertTrue(ObjectUtils.isNull(obj));
        obj = new Object();
        Assert.assertFalse(ObjectUtils.isNull(obj));
        obj = new String();
        Assert.assertFalse(ObjectUtils.isNull(obj));
        obj = "";
        Assert.assertFalse(ObjectUtils.isNull(obj));
        obj = new ArrayList<>();
        Assert.assertFalse(ObjectUtils.isNull(obj));
        obj = new HashMap<>();
        Assert.assertFalse(ObjectUtils.isNull(obj));
    }

    @Test
    public void notNull() {
        Object obj = null;
        Assert.assertFalse(ObjectUtils.notNull(obj));
        obj = new Object();
        Assert.assertTrue(ObjectUtils.notNull(obj));
        obj = new String();
        Assert.assertTrue(ObjectUtils.notNull(obj));
        obj = "";
        Assert.assertTrue(ObjectUtils.notNull(obj));
        obj = new ArrayList<>();
        Assert.assertTrue(ObjectUtils.notNull(obj));
        obj = new HashMap<>();
        Assert.assertTrue(ObjectUtils.notNull(obj));
    }

    @Test
    public void isEmpty() {
        Object obj = null;
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new boolean[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new byte[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new char[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new short[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new int[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new long[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new float[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new double[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Boolean[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Byte[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Character[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Short[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Integer[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Long[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Float[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Double[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new String[0];
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new String();
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = "";
        Assert.assertTrue(ObjectUtils.isEmpty(obj));
        obj = new Object();
        Assert.assertFalse(ObjectUtils.isEmpty(obj));
    }

    @Test
    public void objectToMap() throws IllegalAccessException {
        Object obj = new Object();
        Map<String, Object> map = ObjectUtils.objectToMap(obj);
        obj = new String();
        map = ObjectUtils.objectToMap(obj);
        obj = new ArrayList<>();
        map = ObjectUtils.objectToMap(obj);
    }

    @Test
    public void copyObject() throws IllegalAccessException {
        Object a = new String("abc");
        Object b = new String();
        ObjectUtils.copyObject(b, a);
    }

    @Test
    public void objectToLong() {
        Long value = ObjectUtils.objectToLong(12345L);
        Assert.assertEquals(value, Long.valueOf(12345));
        value = ObjectUtils.objectToLong(Long.valueOf("124"));
        Assert.assertEquals(value, Long.valueOf(124));
        value = ObjectUtils.objectToLong(Integer.valueOf("124"));
        Assert.assertEquals(value, Long.valueOf(124));
        value = ObjectUtils.objectToLong(124);
        Assert.assertEquals(value, Long.valueOf(124));
        value = ObjectUtils.objectToLong("124");
        Assert.assertEquals(value, Long.valueOf(124));
        value = ObjectUtils.objectToLong("0124");
        Assert.assertNull(value);
    }
}
