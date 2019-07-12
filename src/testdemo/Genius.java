package testdemo;

import java.util.Date;

/**
 * @Description
 * @Date 2019/6/18 18:51
 * @Created by Feng Shiwei
 */

public class Genius {

    public Genius(String name) {
        this.name = name;
    }

    private String name;

    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Genius{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
