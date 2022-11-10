package demogeneric;

public class Main {
    public static void main(String[] args) {
        Generic<String, Integer> g=new Generic<>();
        g.setDataX("hello");
         Generic<Integer,String> g2=new Generic<>();
         g2.setDataX(20);

         g.run("hi bae");
         g.run(10);
    }
}
