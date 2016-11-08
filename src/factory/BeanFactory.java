package factory;

import java.util.ResourceBundle;

/**
 * Created by hp123 on 2016/11/8.
 */
public class BeanFactory {
    //加载配置文件
    private static ResourceBundle resourceBundle;
    static{
        resourceBundle=ResourceBundle.getBundle("instance");
    }
    /**
     * 根据指定的key，读取配置文件获取的全路径，创建对象
     * @return
     */
    public static <T> T  getInstance(String key,Class<T> clazz){
        String className=resourceBundle.getString(key);
        try {
            return (T) Class.forName(className).newInstance();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
