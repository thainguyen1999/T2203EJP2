package demothread;

public class SubRunnable implements Runnable{
    @Override
    public  void  run(){
        for (int i=0;i<30;i++){
            System.out.println("sub runnable i= "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }

        }
    }
}
