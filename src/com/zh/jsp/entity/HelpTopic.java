package com.zh.jsp.entity;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MySQL数据库帮助主题
 */
@Data
public class HelpTopic {
    /**
     * 主题ID
     */
    private Integer helpTopicId;

    public Integer getHelpTopicId() {
        return helpTopicId;
    }

    public void setHelpTopicId(Integer helpTopicId) {
        this.helpTopicId = helpTopicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHelpCategoryId() {
        return helpCategoryId;
    }

    public void setHelpCategoryId(Integer helpCategoryId) {
        this.helpCategoryId = helpCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /***
     * 主题名称
     */
    private String name;
    /**
     * 帮助类型
     */
    private Integer helpCategoryId;
    /***
     * 帮助描述
     */
    private String description;
    /**
     * 帮助案例
     */
    private String example;

    /**
     * 帮助链接
     */
    private String url;

    @Override
    public String toString() {
        return "HelpTopic{" +
                "helpTopicId=" + helpTopicId +
                ", name='" + name + '\'' +
                ", helpCategoryId=" + helpCategoryId +
                ", description='" + description + '\'' +
                ", example='" + example + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String text = "ABC99aBc9abC77abc";
        Pattern p = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            String b = matcher.group();
            System.out.println(b);
            text=text.replaceFirst(b,"*");
        }
        System.out.println(text);
    }
}
