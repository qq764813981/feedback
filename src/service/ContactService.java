package service;

import Utils.PageBean;
import dao.Contact;
import entry.User;

import java.sql.Connection;
import java.util.List;

/**
     * Created by hp123 on 2016/11/1.
     */
    public interface ContactService {
   public void getAll(PageBean<User>user);  //查询所有
    public void Insert (User user);//添加
    List<User>getAll();
}
