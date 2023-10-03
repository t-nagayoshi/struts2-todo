package jp.co.example.dao;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jp.co.example.dto.TodoItemDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import jp.co.example.action.CustomDataSource;

/**
 * TODOリストアイテム取得DAO
 *
 * @author t-nagayoshi
 * @version 1.0 2023/09/25
 * @since
 */
@Repository("TodoItemDAO")
public class TodoItemDAO extends BaseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Todoリストアイテムの一覧を取得する
     * @return
     * @throws Exception
     */
    public List<TodoItemDTO> getAllTodoItems() throws Exception {
        String sql = "SELECT * FROM todoitem";
        return selectList(sql, TodoItemDTO.class);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public TodoItemDTO getRowTodoItems() throws Exception {

        //
//        @SuppressWarnings("resource")
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DataSource dataSource = (DataSource) ac.getBean("dataSource");
//        QueryRunner queryRunner = new QueryRunner(dataSource);
        QueryRunner queryRunner = new QueryRunner(jdbcTemplate.getDataSource());

        try {
            // TodoItemクラスにマッピングするためのHandlerを作成
            ResultSetHandler<TodoItemDTO> resultHandler = new BeanHandler<>(TodoItemDTO.class);

            // SQLクエリを実行し、結果を取得
            TodoItemDTO dto = queryRunner.query("SELECT * FROM todoitem WHERE itemid = ?", resultHandler, 1);
            return dto;
        } catch (Exception e) {
            // エラーハンドリング
            e.printStackTrace();
            return null;
        }
    }
}
