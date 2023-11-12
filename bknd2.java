package p2;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
public class bknd2{
static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//Remove NULL
public static void nul (){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8&useSSL=false&useUnicode=true","root","1234");
Statement myStmt = con.createStatement();
String sql = "delete from stock where ISBN is NULL";
myStmt.executeUpdate(sql);
}catch(Exception e){
e.printStackTrace();
}
}
//Delete Data
public static void delete (JFrame Add){
try{
String det="";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8&useSSL=false&useUnicode=true","root","1234");
JButton inputButton = new JButton("DELETE");
inputButton.setFont(new Font("Arial",Font.BOLD,20));
inputButton.setForeground(new Color(0, 0, 0));
inputButton.setBackground(new Color(255, 255, 255));
JLabel ISBN = new JLabel("Enter ISBN of book to be deleted below>");
ISBN.setForeground(Color.black);
ISBN.setFont(new Font("Courier New",Font.PLAIN,20));
Add.add(ISBN ,BorderLayout.NORTH);
JTextArea ISBN1 = new JTextArea("");
ISBN1.setBackground(Color.BLACK);
ISBN1.setForeground(Color.WHITE);
ISBN1.setFont(new Font("Courier New",Font.PLAIN,20));
Add.add(ISBN1);
Add.add(inputButton, BorderLayout.SOUTH);
inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                String det= ISBN1.getText();
		ISBN1.setText("");
		System.out.println(det);
		try{
		Statement myStmt = con.createStatement();
		String sql = "delete from stock where ISBN=";
		sql+=det;
		System.out.print(sql);
		myStmt.executeUpdate(sql);
}
catch(Exception et){
et.printStackTrace();
}}});
}catch(Exception e){
e.printStackTrace();
}
}
//Add Data
public static void write (JFrame Add){
try{
String det="";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8&useSSL=false&useUnicode=true","root","1234");
JButton inputButton = new JButton("STORE");
inputButton.setFont(new Font("Arial",Font.BOLD,20));
inputButton.setForeground(new Color(0, 0, 0));
inputButton.setBackground(new Color(255, 255, 255));
JLabel ISBN = new JLabel("Enter Book details separated by Comma below>");
ISBN.setForeground(Color.black);
ISBN.setFont(new Font("Courier New",Font.PLAIN,20));
Add.add(ISBN ,BorderLayout.NORTH);
JTextArea ISBN1 = new JTextArea("");
ISBN1.setBackground(Color.BLACK);
ISBN1.setForeground(Color.WHITE);
ISBN1.setFont(new Font("Courier New",Font.PLAIN,20));
Add.add(ISBN1);
Add.add(inputButton, BorderLayout.SOUTH);
inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                String det= ISBN1.getText();
		ISBN1.setText("");
		System.out.println(det);
		try{
		Statement myStmt = con.createStatement();
		String sql = "insert into stock values (";
		sql+=det;
		sql+=")";
		System.out.print(sql);
		myStmt.executeUpdate(sql);
}
catch(Exception et){
et.printStackTrace();
}}});
}catch(Exception e){
e.printStackTrace();
}
}
//Display
public static void read(JPanel rec){
rec.removeAll();
rec.setBackground(Color.black);
System.out.println("+---------------+---------------+---------------+---------------+---------------+---------------+");
System.out.println("|     ISBN      |     Name      |     Author    |    Edition    |   Quantity    |      Cost     |");
System.out.println("+---------------+---------------+---------------+---------------+---------------+---------------+");
try {
String p="";
String title="<tr>"+"<th>"+"ISBN"+"</th>"+"<th>"+"Name"+"</th>"+"<th>"+"Author"+"</th>"+"<th>"+"Edition"+"</th>"+"<th>"+"Quantity"+"</th>"+"<th>"+"Cost"+"</th>"+"</tr>";
p+=title;
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf8&useSSL=false&useUnicode=true","root","1234");
Statement rt = con.createStatement();
ResultSet rs= rt.executeQuery("select * from stock"); 
int c=0;	
while(rs.next()){
String st="";
System.out.printf("|%15s|%15s|%15s|%15s|%15s|%15s|",rs.getLong("ISBN"),rs.getString("Name"),rs.getString("Author"),rs.getInt("Edition"),rs.getInt("Quantity"),rs.getInt("Cost"));
System.out.println("");
st+="<tr>"+"<td>"+rs.getLong("ISBN")+"</td>"+"<td>"+rs.getString("Name")+"</td>"+"<td>"+rs.getString("Author")+"</td>"+"<td>"+Integer.toString(rs.getInt("Edition"))+"</td>"+"<td>"+Integer.toString(rs.getInt("Quantity"))+"</td>"+"<td>"+rs.getInt("Cost")+"</td>"+"</tr>";
c++;
p+=st;}
JLabel lab= new JLabel("<html><style>table, th, td {  border:1px solid white;}</style><table>"+p+"</table></html>");
lab.setFont(new Font("Courier New",Font.PLAIN,20));
lab.setForeground(Color.white);
lab.setBackground(Color.black);
lab.setSize(screenSize.width-10,5);
rec.add(lab, BorderLayout.NORTH);
}
catch(Exception e){
e.printStackTrace();
}
System.out.println("+---------------+---------------+---------------+---------------+---------------+---------------+");
}
}