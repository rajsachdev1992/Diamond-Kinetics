package raj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Raj Sachdev
 */
public class SwingData {

    //timestamp, ax, ay, az, wx, wy, wz
    private final List<Long> timestamp;
    private final List<Double> ax;
    private final List<Double> ay;
    private final List<Double> az;
    private final List<Double> wx;
    private final List<Double> wy;
    private final List<Double> wz;

    public SwingData() {
        timestamp = new LinkedList<>();
        ax = new ArrayList<>(1000);
        ay = new ArrayList<>(1000);
        az = new ArrayList<>(1000);
        wx = new ArrayList<>(1000);
        wy = new ArrayList<>(1000);
        wz = new ArrayList<>(1000);
    }

    public void insertEntry(Long timestamp, Double ax, Double ay, Double az, Double wx, Double wy, Double wz) {
        this.timestamp.add(timestamp);
        this.ax.add(ax);
        this.ay.add(ay);
        this.az.add(az);
        this.wx.add(wx);
        this.wy.add(wy);
        this.wz.add(wz);
    }

    public List<Long> getTimestamp() {
        return timestamp;
    }

    public List<Double> getAx() {
        return ax;
    }

    public List<Double> getAy() {
        return ay;
    }

    public List<Double> getAz() {
        return az;
    }

    public List<Double> getWx() {
        return wx;
    }

    public List<Double> getWy() {
        return wy;
    }

    public List<Double> getWz() {
        return wz;
    }
}
