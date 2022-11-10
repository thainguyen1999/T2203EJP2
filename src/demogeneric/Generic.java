package demogeneric;

public class Generic <x,y>{
    x dataX;
    y dataY;

    public x getDataX() {
        return dataX;
    }

    public void setDataX(x dataX) {
        this.dataX = dataX;
    }

    public y getDataY() {
        return dataY;
    }

    public void setDataY(y dataY) {
        this.dataY = dataY;
    }

    public <A> void run(A msg){//generic in method
        System.out.println(msg);
    }
}
