package demothread;

public class SubThread1 extends Thread{
    @Override
    public void run(){
        for (int i=0;i<20;i++){
            System.out.println("subthread1 i= "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }

        }

    }
}
