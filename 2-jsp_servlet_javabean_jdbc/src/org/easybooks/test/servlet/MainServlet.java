package org.easybooks.test.servlet;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.easybooks.test.jdbc.SqlSrvDBConn;
import org.easybooks.test.model.vo.UserTable;;
public class MainServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
request.setCharacterEncoding("gb2312");				//�����������
String usr=request.getParameter("username");			//��ȡ�ύ���û���
String pwd=request.getParameter("password");			//��ȡ�ύ������
boolean validated=false;							//��֤�ɹ���ʶ
SqlSrvDBConn sqlsrvdb=new SqlSrvDBConn();
HttpSession session=request.getSession();	//��ûỰ�����������浱ǰ��¼�û�����Ϣ
UserTable user=null;
    	//�Ȼ��UserTable��������ǵ�һ�η��ʸ�ҳ���û�����϶�Ϊ�գ�������ǵڶ��������ǵ����Σ�
  	//��ֱ�ӵ�¼��ҳ�������ٴ��ظ���֤���û�����Ϣ
user=(UserTable)session.getAttribute("user");
    	//����û��ǵ�һ�ν��룬�Ự����δ�洢user�־û����󣬹�Ϊnull
if(user==null){
    		//��ѯuserTable���еļ�¼
String sql="select * from userTable";
	ResultSet rs=sqlsrvdb.executeQuery(sql);				//ȡ�ý����
    		try {
				while(rs.next())	{
if((rs.getString("username").trim().compareTo(usr)==0)&&(rs.getString("password"). compareTo(pwd)==0)){
		user=new UserTable();	//�����־û���JavaBean����user
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		session.setAttribute("user", user);	//��user����洢�ڻỰ��
		validated=true;				//��ʶΪtrue��ʾ��֤�ɹ�ͨ��
		}
}
  		rs.close();
} catch (SQLException e) {
	e.printStackTrace();
	}
sqlsrvdb.closeStmt();
sqlsrvdb.closeConn();
   }
   else{
    	validated=true;		//���û���֮ǰ�ѵ�¼�����ɹ���֤���ʱ�ʶΪtrue��ʾ����������
        }
        if(validated)
        {
            //��֤�ɹ���ת��main.jsp
        	response.sendRedirect("main.jsp");
        }
        else{
            //��֤ʧ����ת��error.jsp
        	response.sendRedirect("error.jsp");
        }
	}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
                     IOException{  
		doGet(request,response);
	}
}
