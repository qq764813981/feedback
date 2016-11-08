package dao;

import Utils.PageBean;
import entry.User;

import java.util.List;

/**
 * Created by hp123 on 2016/11/8.
 */
public interface IContact {
        void Insert(User user);
        void getAll(PageBean<User> user);
        int getTotalCount();
        List<User> getAll();

    }
