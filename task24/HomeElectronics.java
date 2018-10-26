package topic4.task24;


public abstract class HomeElectronics implements HomeElectronicsDo {
    private boolean isWork=false;
    protected String serialNumber;
    protected String brand;

    public boolean isIsWork(){
        return isWork;
    }

    @Override
    public void on() {
        this.isWork=true;
    }

    @Override
    public void off() {
        this.isWork=false;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String getBrand() {
        return brand;
    }


}
