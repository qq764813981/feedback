package dao;

import Utils.PageBean;
import entry.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import Utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hp123 on 2016/11/1.
 */

public class Contact implements IContact {
    /**根据
     * 主键查询**/
    private QueryRunner qr = JdbcUtils.getQueryRunner();
    public void getAll(PageBean<User> pb) {
        //2.查询总记录数；设置到pb对象中
        int totalCount = this.getTotalCount();
        pb.setTotalCount(totalCount);

		/*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
        //判断
        if(pb.getCurrentPage()<=0)
        {
            pb.setCurrentPage(1);
        }
        else if(pb.getCurrentPage()>pb.getTotalPage())
        {
            pb.setCurrentPage(pb.getTotalPage());
        }

        //1.获取当前页：计算起始行、返回的行数
        int currentPage=pb.getCurrentPage();
        int index=(currentPage-1)*pb.getPageCount();//查询的起始行
        int count=pb.getPageCount();//一次查询的行数

        //3.分页查询数据；把查询到的数据封装到pb中
        String sql="select * from user limit ?,?";

        //连接数据库
        //得到queryrunner
        try {

            //根据当前页，查询当前页数据(一页数据)
            List<User> pageData= qr.query(sql, new BeanListHandler<User>(User.class), index,count);
            //设置到pb对象中
            pb.setPageData(pageData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalCount() {
        String sql="SELECT COUNT(*)FROM User";
        //创建qr对象
        try {

            //执行查询，返回结果的第一行第一列
            Long count=qr.query(sql, new ScalarHandler<Long>());
            return count.intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //增加方法,service层加时间
    public void Insert(User user) {
        String sql =" INSERT user(message,date) VALUES(?,?);";
        try {
            qr.update(sql, user.getMessage(),user.getDate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public List<User> getAll() {
        try {
            String sql ="SELECT * FROM user";

            List<User>list=qr.query(sql, new BeanListHandler<User>(User.class));
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
