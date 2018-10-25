package topic4.task22;

/**
     * @author Vitaliy Perelayko
    */

public interface WorkWithTime {
    /**
     *
     * @return full number of seconds
     * @throws NullPointerException if the specified object is null
     */
    int getSecond();

    /**
     * print time
     * @throws NullPointerException if the specified object is null
     */
    void printTime();

    /**
     * makes the time correct (number of second and minutes is between 0 and 59
     * @throws NullPointerException if the specified object is null
     */
    void toCorrectTime();

    /**
     * @param t the time that will be added
     * @throws NullPointerException if the specified object is null
     */
    void plusTime(Time t);

    /**
     * @param t the time that will be subtracted
     * @throws NullPointerException if the specified object is null
     */
    void minusTime(Time t);

    /**
     * @param s the time that will be added
     * @throws NullPointerException if the specified object is null
     */
    void plusSecond(int s);

    /**
     * @param s the time that will be subtracted
     * @throws NullPointerException if the specified object is null
     */
    void minusSecond(int s);

    /**
     * @param m the time that will be added
     * @throws NullPointerException if the specified object is null
     */
    void plusMinute(int m);

    /**
     * @param m the time that will be subtracted
     * @throws NullPointerException if the specified object is null
     */
    void minusMinute(int m);

    /**
     * @param h the time that will be added
     * @throws NullPointerException if the specified object is null
     */
    void plusHour(int h);

    /**
     * @param h the time that will be subtracted
     * @throws NullPointerException if the specified object is null
     */
    void minusHour(int h);

}
