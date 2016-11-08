package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by hp123 on 2016/11/1.
 */
public class JdbcUtils {
   private static ComboPooledDataSource dataSource;
   static {
      dataSource = new ComboPooledDataSource(  );
   }
   public static ComboPooledDataSource getDataSource(){
      return dataSource;
   }
   public static QueryRunner getQueryRunner() {
      return new QueryRunner(dataSource);
   }

}
