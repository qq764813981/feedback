package servlet;

import Utils.PageBean;
import entry.User;
import service.ContactService;
import service.ContactServiceImp;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * Created by hp123 on 2016/11/1.
 */
@WebServlet(name = "FeedBackServlet")
public class FeedBackServlet extends HttpServlet {
    private String uri;
    private ContactService service=new ContactServiceImp();

    public void init(ServletConfig config) throws ServletException{
        super.init();
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setPageCount(6);
        service.getAll(pageBean);
        List<User> list = service.getAll();
        config.getServletContext().setAttribute("list", list);
        config.getServletContext().setAttribute("pb", pageBean);
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //接收参数
        User user = new User();
        String message = request.getParameter("message");

        if("page".equals(message)){
         page  (request,response);
        }else if("save".equals(message)){
            save(request,response);
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user=new User();
            user.setMessage(request.getParameter("message"));
            user.setMessageTime(new Date());
            service.Insert(user);
            page(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1. 获取“当前页”参数；  (第一次访问当前页为null)
            String currPage = request.getParameter("currentPage");
            // 判断
            if (currPage == null || "".equals(currPage.trim())) {
                currPage = "1";    // 第一次访问，设置当前页为1;
            }
            // 转换
            int currentPage = Integer.parseInt(currPage);

            //2. 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<User> pageBean = new PageBean<User>();
            pageBean.setCurrentPage(currentPage);

            //3. 调用service
            service.getAll(pageBean);    // 【pageBean已经被dao填充了数据】

            //4. 保存pageBean对象，到request域中
            List<User>list=pageBean.getPageData();
            request.setAttribute("pageBean", pageBean);
            request.setAttribute("list",list);
            //5. 跳转
            uri = "show_feedback_content1.jsp";
        } catch (Exception e) {
            e.printStackTrace();  // 测试使用
            // 出现错误，跳转到错误页面
            uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
