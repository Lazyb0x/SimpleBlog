package com.goods.dao;

import com.goods.model.Article;
import com.goods.model.User;
import com.goods.utils.DB;

import javax.smartcardio.CommandAPDU;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

public class UserDao {
    public List<Article> listArticle(){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        List<Article> list = new ArrayList<Article>();
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from article");
            while (rs.next()){
                Article article = new Article();
                article.setId(rs.getInt("a_id"));
                article.setTitle(rs.getString("a_title"));
                article.setAuthor(rs.getString("a_author"));
                article.setDate(rs.getDate("a_date"));
                article.setContent(rs.getString("a_content"));
                list.add(article);
            }
        }
        catch (Exception e){

        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
        return list;
    }

    public void addArticle(Article article){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "insert into article(a_title,a_author,a_date,a_content) VALUES (" +
                "\"" + article.getTitle() + "\"," +
                "\"" + article.getAuthor() + "\"," +
                "\"" + now() + "\"," +
                "\"" + article.getContent() + "\")";
        sql = sql.replaceAll("\n","\\\\\\n");  //存入数据库时候用“\n”(两个字符)代替换行符。
        System.out.println("执行SQL语句：" + sql);
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);        //executeUpdate() 返回int，改动的行数。
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
    }

    public void editArticle(Article article, int id){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "update article set a_title=" + "\"" + article.getTitle() + "\","
                + "a_content=" + "\"" + article.getContent() + "\""
                + " where a_id=" + id;

        sql = sql.replaceAll("\n","\\\\\\n");
        System.out.println("执行SQL语句：" + sql);
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
    }

    public int deleteArticle(int pageID){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "delete from jdblog.article where a_id=" + pageID;
        int result = 0;
        try{
            stat = conn.createStatement();
            result = stat.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
        return result;
    }

    public Article displayArticle(int pageID){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "select * from article where a_id=" + pageID;
        Article article = null;
        System.out.println("执行SQL语句：" + sql);
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()){
                article = new Article();
                article.setId(pageID);
                article.setTitle(rs.getString("a_title"));
                article.setAuthor(rs.getString("a_author"));
                article.setDate(rs.getDate("a_date"));
                article.setContent(rs.getString("a_content"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
        return article;
    }

    public void addUser(User user){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "insert into user(u_name,u_password,u_isadmin) VALUES (" +
                "\"" + user.getName() + "\"," +
                "\"" + user.getPassword() + "\"," +
                user.getAdmin() + ")";
        System.out.println("执行SQL语句：" + sql);
        try{
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
    }

    public User getUser(User cuser){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "select * from user where u_name=" + cuser.getName();
        User user = null;
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("u_id"));
                user.setName(rs.getString("u_name"));
                user.setPassword(rs.getString("u_password"));
                user.setAdmin(rs.getBoolean("u_isadmin"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
        return user;
    }

    public User getUser(String name){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "select * from user where u_name=" + "\"" + name + "\"";
        User user = null;
        System.out.println("执行SQL语句：" + sql);
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("u_id"));
                user.setName(rs.getString("u_name"));
                user.setPassword(rs.getString("u_password"));
                user.setAdmin(rs.getBoolean("u_isadmin"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
        return user;
    }

    public User getUser(int id){
        Connection conn = DB.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        String sql = "select * from user where u_id=" + id ;
        User user = null;
        System.out.println("执行SQL语句：" + sql);
        try{
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("u_id"));
                user.setName(rs.getString("u_name"));
                user.setPassword(rs.getString("u_password"));
                user.setAdmin(rs.getBoolean("u_isadmin"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DB.releaseConnection(conn,stat,rs);
        }
        return user;
    }
}
