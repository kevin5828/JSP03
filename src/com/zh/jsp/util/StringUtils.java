package com.zh.jsp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 字符串处理工具类
 */
public final class StringUtils {
    /**
     * 将关键字处理成高亮显示
     * @param text  待处理的文本
     * @param keyword 关键字
     * @param color  颜色代码
     * @return
     */
    public final static String  handleHighlightKeyword(String text,String keyword,String color){
        Pattern p = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            String kd = matcher.group();
            text=text.replaceFirst(kd,"<span style='background-color:"+color+"'>"+kd+"</span>");
        }
        return text;
    }

    /**
     * 判断字符串是否为空字符串、null、空格字符串
     * @param str
     * @return
     */
    public final static boolean isEmpty(String str){
         if(str==null){
             return true;
         }
         str=str.replace(" ","");
         return "".equals(str);
    }
}
