import p2.bknd2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI{
    public static void main(String args[]){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	bknd2 fnc = new bknd2();
	ImageIcon logo = new ImageIcon("icon.png");       
       JFrame frame = new JFrame("BookManager");
	frame.setContentPane(new JLabel(new ImageIcon("libbw.jpg")));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.setIconImage(logo.getImage());
	Icon btn = new ImageIcon("bi.png");
	JButton m1 = new JButton(btn);
	m1.setBorder(null);
        m1.setBorderPainted(true);
        m1.setContentAreaFilled(false);
        m1.setOpaque(false);
	m1.setFocusPainted(false);
	//LOGIN PAGE
	JLabel userLabel=new JLabel("USERNAME");
    	JLabel passwordLabel=new JLabel("PASSWORD");
    	JTextField userTextField=new JTextField();
    	JPasswordField passwordField=new JPasswordField();
	userLabel.setFont(new Font("Arial",Font.PLAIN,20));
	passwordLabel.setFont(new Font("Arial",Font.PLAIN,20));
	userLabel.setForeground(new Color(255,255,255));
	passwordLabel.setForeground(new Color(255,255,255));
	userLabel.setBounds(screenSize.width/2-250,screenSize.height-700,150,30);
       passwordLabel.setBounds(screenSize.width/2-250,screenSize.height-500,150,30);
       userTextField.setBounds(screenSize.width/2-100,screenSize.height-700,150,30);
       passwordField.setBounds(screenSize.width/2-100,screenSize.height-500,150,30);
	frame.add(userLabel);
       	frame.add(passwordLabel);
       	frame.add(userTextField);
       	frame.add(passwordField);
	//LOGIN BUTTON
	m1.setBounds(screenSize.width/2-100,screenSize.height-400, 100, 100);
  	frame.add(m1);
       frame.setBounds(0,0,screenSize.width, screenSize.height);
       frame.setVisible(true);
	m1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
	    String au="root";
	    String ap="123";
;	    String Uname = userTextField.getText();
	    String pass = String.valueOf(passwordField.getPassword());
	  if(!(Uname.equals(au) && pass.equals(ap))){
	JOptionPane.showMessageDialog(frame,"Incorrect Username or Password","Login Error",JOptionPane.WARNING_MESSAGE);
    	}
	    if(Uname.equals(au) && ap.equals(pass)){
	    frame.remove(m1);
	    frame.remove(userLabel);
       	    frame.remove(passwordLabel);
       	    frame.remove(userTextField);
       	    frame.remove(passwordField);	
	    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	    JLabel wel=new JLabel("Welcome,"+Uname);
	    wel.setFont(new Font("Arial",Font.PLAIN,30));
	    wel.setForeground(new Color(255,255,255));
	    wel.setBounds(0,0,400,30);
	    frame.add(wel);
	    JFrame rec= new JFrame("Records");
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.black);
	    fnc.read(panel);
	    rec.setIconImage(logo.getImage());
            rec.setBounds(screenSize.width/2,0,screenSize.width/2, screenSize.height);
	    // add the panel to a JScrollPane
		JScrollPane jScrollPane = new JScrollPane(panel);
		// only a configuration to the jScrollPane...
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   		rec.add(jScrollPane);
            rec.setVisible(true);
	    JButton Display= new JButton("REFRESH STOCK");
	    Display.setFont(new Font("Arial",Font.BOLD,30));
	    Display.setForeground(new Color(0, 0, 0));
	    Display.setBackground(new Color(255, 255, 255));
	    Display.setBounds(10,40, 400, 200);	
	    frame.add(Display);
	    JButton Add= new JButton("ADD BOOK");
	    Add.setFont(new Font("Arial",Font.BOLD,30));
	    Add.setForeground(new Color(0, 0, 0));
	    Add.setBackground(new Color(255, 255, 255));
	    Add.setBounds(10, 260, 400, 200);	
	    frame.add(Add);
	    JButton Rent= new JButton("BUY BOOK");
	    Rent.setFont(new Font("Arial",Font.BOLD,30));
	    Rent.setForeground(new Color(0, 0, 0));
	    Rent.setBackground(new Color(255, 255, 255));
	    Rent.setBounds(10, 480, 400, 200);	
	    frame.add(Rent);
	    JButton nul= new JButton("REMOVE NULL");
	    nul.setFont(new Font("Arial",Font.BOLD,30));
	    nul.setForeground(new Color(0, 0, 0));
	    nul.setBackground(new Color(255, 255, 255));
	    nul.setBounds(10, 700, 400, 200);	
	    frame.add(nul);
	    Display.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
	    JPanel panel1 = new JPanel();
	    panel.setBackground(Color.black);
	    fnc.read(panel);
	    rec.dispose();	
	    fnc.read(panel1);
	    rec.setIconImage(logo.getImage());
            rec.setBounds(screenSize.width/2,0,screenSize.width/2, screenSize.height);
	    //add the panel to a JScrollPane
		JScrollPane jScrollPane1  = new JScrollPane(panel1);
		// only a configuration to the jScrollPane...
		jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   		rec.add(jScrollPane1);
		rec.setVisible(true);
}});
	Add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
	JFrame Add= new JFrame("Add new User");
	//Add.getContentPane().setBackground(Color.black);
	Add.setIconImage(logo.getImage());
	fnc.write(Add);
        Add.setSize(1000,500);
        Add.setVisible(true);	
}});
	Rent.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
	JFrame del= new JFrame("Buy a book");
	//del.getContentPane().setBackground(Color.black);
	del.setIconImage(logo.getImage());
	fnc.delete(del);
        del.setSize(1000,500);
        del.setVisible(true);	
}});
	nul.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
	fnc.nul();	
}});
	}}});
         }
}