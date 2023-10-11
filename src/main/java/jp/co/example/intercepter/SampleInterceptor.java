package jp.co.example.intercepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class SampleInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    // インターセプターの処理（コンソールに文字列を出力する）
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println("Intercept-test");

        invocation.addPreResultListener(
                new PreResultListener() {
                    public void beforeResult(ActionInvocation actioninvocation, String resultCode) {
                        System.out.println("Result:"+resultCode);
                   }
               }
            );

        // 次のインターセプター処理
        String result_code = invocation.invoke();

        // Result後のインターセプター処理
        System.out.println("Intercept-After-Result");

        // セッションの取得
        // Struts 2では、Mapオブジェクトとしてセッションが取得できる
//        Map<String, String> session = ActionContext.getContext().getSession();

        // HttpServletRequest、HttpSessionの取得
//        HttpServletRequest request = ServletActionContext.getRequest();
//        HttpSession session = ServletActionContext.getRequest().getSession();

        return result_code;
    }
}
