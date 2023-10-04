package jp.co.example.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jp.co.example.dao.TodoItemDAO;
import jp.co.example.dto.TodoItemDTO;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

@Controller
public class TodoAction extends ActionSupport {

    @Autowired
    private TodoItemDAO todoItemDAO;

    private TodoItemDTO todoItem;
    private List<TodoItemDTO> todoItemList;

    public String execute() throws Exception {

        // todoItem = todoItemDAO.getRowTodoItems();
        todoItemList = todoItemDAO.getAllTodoItems();

        //Display values
        //System.out.print("itemid: " + todoItemList.get(0).getItemid());
        //System.out.print("userid: " + todoItemList.get(0).getUserid());
        return SUCCESS;
    }

    public TodoItemDTO getTodoItem() {
        return todoItem;
    }

    public List<TodoItemDTO> getTodoItemList() {
        return todoItemList;
    }

}
