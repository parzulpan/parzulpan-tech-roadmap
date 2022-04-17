package cn.parulpan.code.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 相关工具类
 *
 * @author parzulpan
 * @since 2022/4/17
 */
public class LcUtils {

    // --- convert ---

    public static <T>  Set<T> convert(T[] array) {

        return new HashSet<T>(Arrays.asList(array));
    }

    // --- convert ---


}
