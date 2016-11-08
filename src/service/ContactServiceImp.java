package service;

import Utils.PageBean;
import dao.Contact;
import entry.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by hp123 on 2016/11/1.
 */
public class ContactServiceImp implements ContactService {
    private Contact dao =  new Contact();
    /**
     * 根据主键查询
     */
    public void getAll(PageBean<User>user){
        try{
            dao.getAll(user);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void update (Connection conn){
        try{
          //  dao.update(conn);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void Insert (User user){
        try{
            dao.Insert(user);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }
}

