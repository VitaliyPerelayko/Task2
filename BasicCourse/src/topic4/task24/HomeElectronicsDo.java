package topic4.task24;

public interface HomeElectronicsDo {
    /**
     * @throws NullPointerException if the specified object is null
     */
    void on();

    /**
     * @throws NullPointerException if the specified object is null
     */
    void off();

    /**
     * @throws NullPointerException if the specified object is null
     * @return serialNumber of object
     */
    String getSerialNumber();

    /**
     * @throws NullPointerException if the specified object is null
     * @return serialNumber of object
     */
    String getBrand();
}
