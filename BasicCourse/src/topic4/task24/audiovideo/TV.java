package topic4.task24.audiovideo;

public class TV extends AudioVideo {
    private int diag;

    public TV(String serialNumber,String brand,int diag){
        this.diag=diag;
        this.serialNumber=serialNumber;
        this.brand=brand;
    }

    public int getDiag() {
        return diag;
    }
}
