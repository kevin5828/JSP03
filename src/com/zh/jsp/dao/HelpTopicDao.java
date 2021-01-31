package com.zh.jsp.dao;

import com.zh.jsp.entity.HelpTopic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL帮助主题数据访问层
 */
public class HelpTopicDao extends BaseDao {
    /**
     * 查询所有MySQL数据库帮助主题
     *
     * @return
     */
    public List<HelpTopic> selectList() {
        List<HelpTopic> topicList = new ArrayList<>();
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            conn = getMysqlConnection();
            s = conn.createStatement();
            String sql = "select t.help_topic_id,t.name,t.description ,t.example,t.url from help_topic as t";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                //获取查询数据
                Integer helpTopicId = rs.getInt("help_topic_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String example = rs.getString("example");
                String url = rs.getString("url");
                HelpTopic topic = new HelpTopic();
                topic.setHelpTopicId(helpTopicId);
                topic.setName(name);
                topic.setDescription(description);
                topic.setExample(example);
                topic.setUrl(url);
                topicList.add(topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
            topicList = null;
        } finally {
            //关闭资源
            closeAll(conn, s, rs);
        }
        return topicList;
    }

    /**
     * 根据关键字查询MySQL帮助主题,当关键字为空字符串、null、空格,查询所有的帮助主题
     * @param keyword
     * @return
     */
    public List<HelpTopic> selectList(String keyword){
        if(keyword==null){
            return selectList();
        }
        //处理空格,即将空格处理成空字符串""
        keyword=keyword.replace(" ","");
        if("".equals(keyword))
        {
           return selectList();
        }
        //根据关键字查询
        List<HelpTopic> topicList = new ArrayList<>();
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            conn = getMysqlConnection();
            s = conn.createStatement();
            String sql = "select t.help_topic_id,t.name,t.description ,t.example,t.url from help_topic as t where name like '%"+keyword+"%' or description like '%"+keyword+"%' or example like '%"+keyword+"%'";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                //获取查询数据
                Integer helpTopicId = rs.getInt("help_topic_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String example = rs.getString("example");
                String url = rs.getString("url");
                HelpTopic topic = new HelpTopic();
                topic.setHelpTopicId(helpTopicId);
                topic.setName(name);
                topic.setDescription(description);
                topic.setExample(example);
                topic.setUrl(url);
                topicList.add(topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
            topicList = null;
        } finally {
            //关闭资源
            closeAll(conn, s, rs);
        }
        return topicList;
    }
}
