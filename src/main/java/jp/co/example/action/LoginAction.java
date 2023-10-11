package jp.co.example.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class LoginAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = -3434561352924343132L;

    // Generate getters and setters....
    @Getter
    @Setter
    private String userId, userPass;
    private String msg;
    private SessionMap<String, Object> sessionMap;

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    @Override
    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        if (userId != null) {

            if (userPass.equals("websparrow")) {
                // add the attribute in session
                sessionMap.put("userId", userId);

                return "SUCCESS";
            } else {
                msg = "Invalid Password";
                return "LOGIN";
            }
        } else {

            String getSessionAttr = (String) session.getAttribute("userId");

            if (getSessionAttr != null) {

                return "SUCCESS";

            } else {
                return "LOGIN";
            }
        }
    }

    public String logout() {

        sessionMap.remove("userId");
        sessionMap.invalidate();

        return "LOGOUT";
    }
}