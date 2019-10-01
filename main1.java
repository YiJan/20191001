import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class main1
{
    private static JFrame frm=new JFrame("calcu");
    private static JPanel pn1=new JPanel(new GridLayout(4,3));
    private static JPanel pn2=new JPanel(new GridLayout(4,1));
    private static JLabel lab=new JLabel("0",SwingConstants.RIGHT);

    private static Button cn,ad,sub,mul,div,amo;

    private static Button digits[]=new Button[10];

    private static long num;

    private static byte op;

public static void main(String args[])
{
    frm.setLayout(null);
    frm.setBounds(100,50,770,970);
    frm.setResizable(true);
    lab.setBounds(10,30,740,100);
    lab.setBackground(new Color(120,240,150));
    pn1.setBounds(10,130,570,800);
    pn2.setBounds(580,130,170,800);

    pn1.setFont(new Font("Arial", Font.PLAIN, 40));
    pn2.setFont(new Font("Arial", Font.PLAIN, 40)); 
    lab.setFont(new Font("Arial", Font.PLAIN, 40));
  
    for(int i=9;i>=0;i--){
        digits[i]=new Button(Integer.toString(i));
        pn1.add(digits[i]);
        digits[i].addActionListener(new ActLis());
    }
    
    cn=new Button("C");
    pn1.add(cn);
    cn.addActionListener(new ActLis());
    
    amo=new Button("=");
    pn1.add(amo);
    amo.addActionListener(new ActLis());
    
    ad=new Button("+");
    pn2.add(ad);
    ad.addActionListener(new ActLis());
    
    sub=new Button("-");
    pn2.add(sub);
    sub.addActionListener(new ActLis());
    
    mul=new Button("*");
    pn2.add(mul);
    mul.addActionListener(new ActLis());
    
    div=new Button("/");
    pn2.add(div);
    div.addActionListener(new ActLis());
   
    frm.addWindowListener(new WindowAdapter(){public void
    windowClosing(WindowEvent e){System.exit(0);}});

    frm.add(lab);
    frm.add(pn1);
    frm.add(pn2);

    frm.setVisible(true);
}

public static class ActLis implements ActionListener
{
    public void actionPerformed(ActionEvent e)throws NumberFormatException,ArithmeticException{
        long result;
          
            Button btn=(Button) e.getSource();
            try{      
                  for(int i=0;i<=9;i++){
                    if(btn==digits[i]){
                        output_digit(digits[i]);
                        break;
                    }
                }
                if(btn==cn){
                    result=0L;
                   num=0L;
                    op=0;
                    lab.setText(Long.toString(num));
                }else if(btn==ad){
                    save_num(ad);
                    op=1;
                }else if(btn==sub){
                    save_num(sub);
                    op=2;
                }else if(btn==mul){
                    save_num(mul);                   
                    op=3;
                }else if(btn==div){
                    save_num(div);
                    op=4;
                }else if(btn==amo){
                    result=Long.parseLong(lab.getText());
               
                    switch(op){
                        case 1:
                            num+=result;
                        break;
                        case 2:
                            num-=result;
                            break;
                        case 3:
                            num*=result;
                            break;
                        case 4:
                            num/=result;
                            break;
                        default:
                    }
                    result=0L;
                    lab.setText(Long.toString(num));
                }
        }catch(NumberFormatException ne){
      }catch(ArithmeticException ae){
      }   
  }
    
    private void output_digit(Button btn){
  lab.setText(Long.toString(Long.parseLong(lab.getText()+btn.getLabel())));
  }
     
    private void save_num(Button oper){
        num=Long.parseLong(lab.getText());
         lab.setText(Long.toString(0L));
    }
}
}