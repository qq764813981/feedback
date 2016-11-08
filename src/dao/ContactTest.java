package dao;

import entry.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by hp123 on 2016/11/8.
 */
public class ContactTest {
    public class MessageDaoTest {

        Contact dao=new Contact();
        @Test
        public void testGetAll() {
            for(int i=1;i<=40;i++){
                User user=new User();

                user.setMessage("����"+i);
                Date date = new Date();
                user.setMessageTime(date);

                dao.Insert(user);
            }
        }
        @Test
        public void testGet(){
            List<User> all = dao.getAll();
            System.out.println(all);
        }

    }

}
