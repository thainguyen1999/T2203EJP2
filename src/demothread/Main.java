package demothread;


public class Main {
    public static void main(String[] args) {
        SubThread1 st1= new SubThread1();
        st1.setDaemon(true);
        SubRunnable r =new SubRunnable();
        Thread t= new Thread(r);
        t.setDaemon(true);

        st1.start();
        t.start();
    }
    public static void main2(String[] args) {
        SubThread1 st1= new SubThread1();
        st1.start();

       //Runnable
        SubRunnable r =new SubRunnable();
        Thread t= new Thread(r);
        t.start();

        Runnable r2=new Runnable() {
            @Override
            public void run() {

            }
        };
        //lớp ẩn danh
        Thread t2= new Thread(r2);
        t2.start();
        new Thread(()->{

        }).start();

        for (int i=0;i<20;i++){
            System.out.println("main i= "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
