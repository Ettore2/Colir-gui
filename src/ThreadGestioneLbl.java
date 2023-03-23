import javax.swing.*;

public class ThreadGestioneLbl extends Thread {
    private Frame f;

    public ThreadGestioneLbl(Frame f){
        this.f=f;

    }

    public void run(){
        while(true){
            f.updateLabelsColor();


            //sleep
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
