package com.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hftang
 * @date 2019-01-03 10:36
 * @desc
 */
public class StringtoDate implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        if (s == null) {
            throw new RuntimeException("请传入参数");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
