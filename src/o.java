import java.sql.*;
import java.util.Scanner;

public class o {
    public static void main(String[] args) {
        //插入几个新的购买订单
        System.out.println("想要新增商品请输1，想要更新商品请输2，想要删除商品请输3,想要查询商品请按4,遍历数据库输入5，退出输入6");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while(i!=6)
        {
            //新增
            while (i == 1) {
                System.out.println("请输入商品的id，名字，价格，订单编号，信息，出货时间:");
                int id = sc.nextInt();
                String name = sc.next();
                int price = sc.nextInt();
                int out_id = sc.nextInt();
                String message = sc.next();
                String time = sc.next();
                Connection conn;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    try {
                        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.");
                        try (PreparedStatement sta = conn.prepareStatement("INSERT INTO form1 (id,name,price,out_id,message,time) VALUES (?,?,?,?,?,?)")) {
                            sta.setObject(1, id);
                            sta.setObject(2, name);
                            sta.setObject(3, price);
                            sta.setObject(4, out_id);
                            sta.setObject(5, message);
                            sta.setObject(6, time);
                            sta.executeUpdate();
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("想要新增商品请输1，想要更新商品请输2，想要删除商品请输3,想要查询商品请按4,遍历数据库输入5，退出输入6");
                i = sc.nextInt();
                if (i != 1)
                    break;
            }

            //更新
            while(i==2){
                System.out.println("请输入要更新的商品id");
                int id=sc.nextInt();
                System.out.println("想要更新名字输入1，想要更新价格输入2，想要更新编码输入3，想要修改信息输入4，想要更新时间输入5");
                int n=sc.nextInt();
                if(n==1){
                    String name=sc.next();
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.")) {
                        try (PreparedStatement ps = conn.prepareStatement("UPDATE form1 SET name=? WHERE id=?")) {
                            ps.setObject(1,name);
                            ps.setObject(2, id);
                            ps.executeUpdate(); // 返回更新的行数
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(n==2){
                    int price=sc.nextInt();
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.")) {
                        try (PreparedStatement ps = conn.prepareStatement("UPDATE form1 SET price=? WHERE id=?")) {
                            ps.setObject(1,price);
                            ps.setObject(2, id);
                            ps.executeUpdate(); // 返回更新的行数
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(n==3){
                    int out_id=sc.nextInt();
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.")) {
                        try (PreparedStatement ps = conn.prepareStatement("UPDATE form1 SET out_id=? WHERE id=?")) {
                            ps.setObject(1,out_id);
                            ps.setObject(2, id);
                            ps.executeUpdate(); // 返回更新的行数
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(n==4){
                    String message=sc.next();
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.")) {
                        try (PreparedStatement ps = conn.prepareStatement("UPDATE form1 SET message=? WHERE id=?")) {
                            ps.setObject(1,message);
                            ps.setObject(2, id);
                            ps.executeUpdate(); // 返回更新的行数
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(n==5){
                    String time=sc.next();
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.")) {
                        try (PreparedStatement ps = conn.prepareStatement("UPDATE form1 SET time=? WHERE id=?")) {
                            ps.setObject(1,time);
                            ps.setObject(2, id);
                            ps.executeUpdate(); // 返回更新的行数
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("想要新增商品请输1，想要更新商品请输2，想要删除商品请输3,想要查询商品请按4,遍历数据库输入5，退出输入6");
                i = sc.nextInt();
                if (i != 2)
                    break;
            }








            //删除
            while(i == 3) {
                System.out.println("请输入要修改的商品id");
                int id = sc.nextInt();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.")) {
                    try (PreparedStatement ps = conn.prepareStatement("DELETE FROM form1 WHERE id=?")) {
                        ps.setObject(1, id);
                        ps.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("想要新增商品请输1，想要更新商品请输2，想要删除商品请输3,想要查询商品请按4,遍历数据库输入5，退出输入6");
                i = sc.nextInt();
                if (i != 3)
                    break;
            }

                //查询
                while(i == 4) {
                    System.out.println("输入想查询的商品id");
                    int m = sc.nextInt();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.");
                        try (PreparedStatement sta = conn.prepareStatement("SELECT id,name,price,out_id,message,time FROM form1 WHERE id=?")) {
                            sta.setObject(1, m);
                            try (ResultSet rs = sta.executeQuery()) {
                                while (rs.next()) {
                                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " +
                                            rs.getInt("price") + " " + rs.getInt("out_id") + " " +
                                            rs.getString("message") + " " + rs.getString("time"));
                                }

                            }


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("想要新增商品请输1，想要更新商品请输2，想要删除商品请输3,想要查询商品请按4,遍历数据库输入5，退出输入6");
                    i = sc.nextInt();
                    if (i != 4)
                        break;


            }

            //遍历
            while(i==5){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/form", "root", "Aires0420.");
                    try (PreparedStatement sta = conn.prepareStatement("SELECT id,name,price,out_id,message,time FROM form1")) {
                        try (ResultSet rs = sta.executeQuery()) {
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " +
                                        rs.getInt("price") + " " + rs.getInt("out_id") + " " +
                                        rs.getString("message") + " " + rs.getString("time"));
                            }

                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("想要新增商品请输1，想要更新商品请输2，想要删除商品请输3,想要查询商品请按4,遍历数据库输入5，退出输入6");
                i = sc.nextInt();
                if (i != 5)
                    break;
            }
        }




    }
}
