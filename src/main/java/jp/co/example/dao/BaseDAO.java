package jp.co.example.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * DAOのベースDAO
 * @author t-nagayoshi
 * @version 1.0 2023/10/03
 * @since
 */
public class BaseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    *
    * @param <T>
    * @param prames
    * @param clazz
    * @param sqlKeys
    * @param orderSqlKeys
    * @return
    * @throws Exception
    */
   public <T> List<T> selectList(String sql, Class<T> clazz) throws Exception {

       // Bean定義からデータソースを取得する
//           @SuppressWarnings("resource")
//           ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//           DataSource dataSource = (DataSource) ac.getBean("dataSource");
//           QueryRunner queryRunner = new QueryRunner(dataSource);

       // jdbcTemplateからデータソースを取得する
       QueryRunner queryRunner = new QueryRunner(jdbcTemplate.getDataSource());

       try {
           // TodoItemクラスにマッピングするためのHandlerを作成
//           ResultSetHandler<List<T>> handler = new BeanListHandler<T>(clazz);

           // SQLクエリを実行し、結果を取得
           return queryRunner.query(sql, new BeanListHandler<T>(clazz));
       } catch (Exception e) {
           // エラーハンドリング
           e.printStackTrace();
           return null;
       }
   }

    /**
     *
     * @param <T>
     * @param prames
     * @param clazz
     * @param sqlKeys
     * @param orderSqlKeys
     * @return
     * @throws Exception
     */
    public <T> T selectRow(Object[] params, String sql, Class<T> clazz) throws Exception {

        // jdbcTemplateからデータソースを取得する
        QueryRunner queryRunner = new QueryRunner(jdbcTemplate.getDataSource());

        try {
            // TodoItemクラスにマッピングするためのHandlerを作成
            ResultSetHandler<T> resultHandler = new BeanHandler<>(clazz);

            // SQLクエリを実行し、結果を取得
            return queryRunner.query(sql, resultHandler, params);
        } catch (Exception e) {
            // エラーハンドリング
            e.printStackTrace();
            return null;
        }
    }

}
