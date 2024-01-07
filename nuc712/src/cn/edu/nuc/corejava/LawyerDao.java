/*
 * 英才汇硕信息科技有限公司 版权所有 2023-2028.
 */
package cn.edu.nuc.corejava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

/**
 * 对律师表做增删改查
 * @author wuzhijun
 * @version 1.0 2023-12-29
 */
public class LawyerDao {  
	/**
	 * 添加律师
	 * @param lawyername 律师姓名
	 * @param gender 性别
	 * @param nation 籍贯
	 * @param school 毕业院校
	 * @return 添加成功返回1，否则返回0
	 */
	public int addLawyer(String lawyername,String gender,String nation,String school) {
		//1. 声明一些变量备用
		int flag = 0; // 添加成功与否的标志，取值是0或1
		Connection conn = null; // 代表数据库连接
		//2. 打开数据库连接
		conn = DbUtil.getConnection();
		//3. 定义并准备SQL语句
		String sql = "INSERT INTO lawyer(lawyername,gender,nation,school) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lawyername);
			pstmt.setString(2, gender);
			pstmt.setString(3, nation);
			pstmt.setString(4, school);
			//4. 执行SQL语句（下达执行指令）
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 关闭连接、释放资源
			DbUtil.closeConnection(conn);
		}
		return flag;
	}
    
	public int deleteLawyer(int id) {
		int flag = 0; // 1成功，0失败
		Connection conn = null;
		
		conn = DbUtil.getConnection();
		
		try {
			String sql = "DELETE FROM lawyer WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			flag = pstmt.executeUpdate();//
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection(conn);
		}
		return flag;
	}
	public static void main(String[] args) {
		LawyerDao lawyerDao = new LawyerDao();
		int flag = lawyerDao.modifyLawyer(1, "陈鹏超", "男", "山西", "中北");
		System.out.println(flag);
		/*
		 * List<Lawyer> lawList = lawyerDao.selectAllLawyer();
		 * System.out.println(lawList);
		 */
		
		/*
		 * int flag = lawyerDao.deleteLawyer(3); if (flag == 0) {
		 * System.out.println("fail..."); } else { System.out.println("OK....."); }
		 */
	}
    
	public List<Lawyer> selectAllLawyer() {
		// 这个集合放表里的数据
		List<Lawyer> lawyerList = new ArrayList<Lawyer>();
		Connection conn = null;
		conn = DbUtil.getConnection();
		String sql = "SELECT * FROM lawyer";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// rs里放的就是查询到的数据
			ResultSet rs = pstmt.executeQuery();//换了！！
			// 把rs里的数据转移到lawyerList里
			while (rs.next()) {
				Lawyer law = new Lawyer();
				law.setId(rs.getInt("id"));
				law.setLawyername(rs.getString("lawyername"));
				law.setGender(rs.getString("gender"));
				law.setNation(rs.getString("nation"));
				law.setSchool(rs.getString("school"));
				lawyerList.add(law);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection(conn);
		}		
		return lawyerList;
	}
    public int modifyLawyer(int id,String lawyername,String gender,String nation,String school) {
    	int flag = 0;// 标志
    	Connection conn = null;
    	conn = DbUtil.getConnection();
    	String sql = "UPDATE lawyer SET lawyername=?,gender=?,nation=?,school=? WHERE id=?";
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lawyername);
			pstmt.setString(2, gender);
			pstmt.setString(3, nation);
			pstmt.setString(4, school);
			pstmt.setInt(5, id);
			flag = pstmt.executeUpdate();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.closeConnection(conn);
		}
    	return flag;
    }
}







