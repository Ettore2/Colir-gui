import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    private boolean ledOn;
    //palette
    Color colorAcceso=new Color(255, 0, 0);
    Color colorSpento=new Color(0, 32, 255);

    Container c;
    JLabel[] labels;
    JButton buttonOn,buttonOff;

    Frame(){
        super("finestra led");
        c=this.getContentPane();
        c.setLayout(null);

        creoComponenti();
        aggiungoComponenti();


        this.setVisible(true);
        this.setBounds(0,0,400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void creoComponenti() {
        labels=new JLabel[5];
        for(int i=0;i<labels.length;i++){
            labels[i]=new JLabel();
            labels[i].setBackground(colorSpento);
            labels[i].setBounds(80*i,100,50,50);
            labels[i].setOpaque(true);
        }

        buttonOn=new JButton("on");
        buttonOn.addActionListener(this);
        buttonOn.setBounds(100,300,75,75);

        buttonOff=new JButton("off");
        buttonOff.addActionListener(this);
        buttonOff.setBounds(200,300,75,75);
    }
    private void aggiungoComponenti() {
        for(int i=0;i<labels.length;i++){
            c.add(labels[i]);
        }

        c.add(buttonOn);
        c.add(buttonOff);
    }

    public synchronized void setLedOn(boolean ledOn) {
        this.ledOn = ledOn;

    }
    public synchronized boolean getLedOn() {
        return ledOn;

    }
    public synchronized void updateLabelsColor(){
        //System.out.println("update colors "+ledOn);
        for(JLabel lbl: labels){
            if(ledOn){
                lbl.setBackground(colorAcceso);
            }else{
                lbl.setBackground(colorSpento);
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonOff){
            setLedOn(false);
            //System.out.println("off");
        }
        if(e.getSource()==buttonOn){
            setLedOn(true);
            //System.out.println("on");
        }
    }
}
