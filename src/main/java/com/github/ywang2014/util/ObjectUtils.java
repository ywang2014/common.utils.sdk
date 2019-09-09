package com.github.ywang2014.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyong.1991
 * @version 创建时间：2019/9/6 下午4:44
 */
public class ObjectUtils {
    private ObjectUtils() {
        // default constructor
    }

    /**
     * 判断对象是否为null
     *
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象是否非null
     *
     * @param obj
     * @return
     */
    public static boolean notNull(Object obj) {
        return obj != null;
    }

    /**
     * 判断集合是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Object[]) {
            return ((Object[])obj).length == 0;
        }
        if (obj instanceof boolean[]) {
            return ((boolean[])obj).length == 0;
        }
        if (obj instanceof byte[]) {
            return ((byte[])obj).length == 0;
        }
        if (obj instanceof char[]) {
            return ((char[])obj).length == 0;
        }
        if (obj instanceof short[]) {
            return ((short[])obj).length == 0;
        }
        if (obj instanceof int[]) {
            return ((int[])obj).length == 0;
        }
        if (obj instanceof long[]) {
            return ((long[])obj).length == 0;
        }
        if (obj instanceof float[]) {
            return ((float[])obj).length == 0;
        }
        if (obj instanceof double[]) {
            return ((double[])obj).length == 0;
        }
        if (obj instanceof String) {
            return ((String)obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map)obj).isEmpty();
        }

        // else
        return false;
    }

    /**
     * 对象转map
     *  对象的属性名称转成map的key，对象属性的值转成map的value
     *  null值/空对象，转成空map
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (isNull(obj)) {
            return map;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        if (isEmpty(fields)) {
            return map;
        }
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    /**
     * map填充对象
     *  key和对象属性名称相同的字段，进行填充
     *
     * @param obj
     * @param map
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> T copyObject(T obj, Map<String, Object> map) throws IllegalAccessException {
        if (isNull(obj) || isEmpty(map)) {
            return obj;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        if (isEmpty(fields)) {
            return obj;
        }
        for (Field field : fields) {
            if (map.containsKey(field.getName()) && ((field.getModifiers() & Modifier.FINAL) == 0)) {
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        }
        return obj;
    }

    /**
     * 对象间复制：将source对象的值，复制到target对象中
     *  同名的属性字段完成复制
     *
     * @param target
     * @param source
     * @param <T>
     * @param <U>
     * @return
     * @throws IllegalAccessException
     */
    public static <T, U> T copyObject(T target, U source) throws IllegalAccessException {
        Map<String, Object> map = objectToMap(source);
        return copyObject(target, map);
    }

    /**
     * 对象转long
     *
     * @param obj 数据源
     * @return long值
     */
    public static Long objectToLong(Object obj) {
        if (isNull(obj)) {
            return null;
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Integer) {
            return ((Integer)obj).longValue();
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (StringUtils.validDigit(str)) {
                return Long.valueOf(str);
            }
        }
        return null;
    }
}
