
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JavaCalculator extends JFrame {

    double num1,num2;
    public JButton jbtNum1;
    public JButton jbtNum2;
    public JButton jbtNum3;
    public JButton jbtNum4;
    public JButton jbtNum5;
    public JButton jbtNum6;
    public JButton jbtNum7;
    public JButton jbtNum8;
    public JButton jbtNum9;
    public JButton jbtNum0;
    public JButton jbtEqual;

    public JButton jbtAdd;
    public JButton jbtSubtract;
    public JButton jbtMultiply;
    public JButton jbtDivide;
    public JButton jbtSolve;
    public JButton jbtClear;

    public double TEMP;
    public double SolveTEMP;
    public JTextField jtfResult;

    Boolean addBool = false;
    Boolean subBool = false;
    Boolean divBool = false;
    Boolean mulBool = false;

    String display = "";

    public JavaCalculator() {

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 4));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtClear = new JButton("C"));
        p1.add(jbtSolve = new JButton("="));
        p1.add(jbtAdd = new JButton("+"));
        p1.add(jbtSubtract = new JButton("-"));
        p1.add(jbtMultiply = new JButton("*"));
        p1.add(jbtDivide = new JButton("/"));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

       
       

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);
       

        add(p);

        jbtNum1.addActionListener(new ListenToNum());
        jbtNum2.addActionListener(new ListenToNum());
        jbtNum3.addActionListener(new ListenToNum());
        jbtNum4.addActionListener(new ListenToNum());
        jbtNum5.addActionListener(new ListenToNum());
        jbtNum6.addActionListener(new ListenToNum());
        jbtNum7.addActionListener(new ListenToNum());
        jbtNum8.addActionListener(new ListenToNum());
        jbtNum9.addActionListener(new ListenToNum());
        jbtNum0.addActionListener(new ListenToNum());

        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());

        //setSize(200,70);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //display = jtfResult.getText();
            jtfResult.setText("");
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;

            TEMP = 0;
            SolveTEMP = 0;
        }
    }


    class ListenToNum implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           
            display = jtfResult.getText();
            jtfResult.setText(display +e.getActionCommand());
        }
    }

   

    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
num1=TEMP;
            jtfResult.setText(jtfResult.getText()+"+");
            addBool = true;
        }
    }

    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());num1=TEMP;
            jtfResult.setText(jtfResult.getText()+"-");
            subBool = true;
        }
    }

    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());num1=TEMP;
            jtfResult.setText(jtfResult.getText()+"*");
            mulBool = true;
        }
    }

    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());num1=TEMP;
            jtfResult.setText(jtfResult.getText()+"/");
            divBool = true;
        }
    }

    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String sb;
Double ans=0.0;
String st=jtfResult.getText();int s;
            if (addBool == true){
s=st.indexOf('+');
num2=Double.parseDouble(st.substring(s+1));
ans=num1+num2;
                }
            else if (subBool == true){
s=st.indexOf('-');
num2=Double.parseDouble(st.substring(s+1));
ans=num1-num2;
                }
            else if (mulBool == true){
s=st.indexOf('*');
num2=Double.parseDouble(st.substring(s+1));
ans=num1*num2;
                }
            if (divBool == true){
s=st.indexOf('/');
num2=Double.parseDouble(st.substring(s+1));
ans=num1/num2;
                }
            jtfResult.setText(Double.toString(ans));

            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;
        }
    }

 
 
 public static void main(String[] args) {
        
        JavaCalculator calc = new JavaCalculator();
        calc.pack();
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
   
}
}