package test;
import java.sql.*;
public class DeleteDAO {
 public int k=0;
 public int delete(UserBean ub) {
 try {
Connection con = DBConnection.getCon();
PreparedStatement ps = con.prepareStatement
 ("delete from UserReg50 where rollno=?");
ps.setLong(1, ub.getRollno());
k = ps.executeUpdate();
}catch(Exception e) {e.printStackTrace();}
 return k;
 }
}