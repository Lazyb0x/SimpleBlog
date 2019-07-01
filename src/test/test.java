package test;

import com.goods.dao.UserDao;
import com.goods.model.Article;
import com.goods.model.User;
import org.junit.Test;
import java.util.List;

public class test {
    @Test
    public void listTest(){
        UserDao dao = new UserDao();
        List list = dao.listArticle();
        System.out.print(list.toString());
    }

    @Test
    public void addArticleTest(){
        Article article = new Article();
        article.setTitle("测试标题");
        article.setAuthor("测试作者");
        article.setContent("这是一段测试内容，如果成功执行，该项目将会\n出现在数据库中。");

        UserDao dao = new UserDao();
        dao.addArticle(article);
    }

    @Test
    public void stringTest(){
        String a = "哈哈哈\n呵呵呵";
        String b = "哈哈哈\\呵呵呵";
        a = a.replaceAll("\n","\\\\\\n");
        b = b.replaceAll("\\\\","\\\\\\\\");
        System.out.println(a);
        System.out.println(b);
        System.out.println("\\\\\\n");
    }

    @Test
    public void displayArticleTest(){
        int pageID = 3;
        Article article = null;
        UserDao userDao = new UserDao();
        article = userDao.displayArticle(pageID);
        if (article!=null){
            System.out.println(article.toString());
        }
        else {
            System.out.println("没有结果。");
        }
    }

    @Test
    public void addUserTesr(){
        User user = new User();
        user.setName("xiaoming");
        user.setPassword("xm123");
        user.setAdmin(false);

        UserDao userDao = new UserDao();
        userDao.addUser(user);
    }

    @Test
    public void getUserTest(){
        String name = "ggg";

        UserDao dao = new UserDao();
        User user = dao.getUser(name);
        System.out.println(user.toString());
    }

    @Test
    public void deleteTest(){
        UserDao dao = new UserDao();
        System.out.println(dao.deleteArticle(4));
    }

    @Test
    public void editArticleTest(){
        UserDao dao = new UserDao();
        Article article = new Article();
        article.setTitle("测试标题");
        article.setAuthor("测试作者");
        article.setContent("这是一段测试2内容，如果成功执行，该项目将会\n出现在数据库中。");

        dao.editArticle(article,3);
    }
}
