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
    private final List<String> timestamp;
    private final List<String> ax;
    private final List<String> ay;
    private final List<String> az;
    private final List<String> wx;
    private final List<String> wy;
    private final List<String> wz;

    public SwingData() {
        timestamp = new LinkedList<>();
        ax = new ArrayList<>(1000);
        ay = new ArrayList<>(1000);
        az = new ArrayList<>(1000);
        wx = new ArrayList<>(1000);
        wy = new ArrayList<>(1000);
        wz = new ArrayList<>(1000);
    }

    public void insertEntry(String timestamp, String ax, String ay, String az, String wx, String wy, String wz) {
        this.timestamp.add(timestamp);
        this.ax.add(ax);
        this.ay.add(ay);
        this.az.add(az);
        this.wx.add(wx);
        this.wy.add(wy);
        this.wz.add(wz);
    }

    public List<String> getTimestamp() {
        return timestamp;
    }

    public List<String> getAx() {
        return ax;
    }

    public List<String> getAy() {
        return ay;
    }

    public List<String> getAz() {
        return az;
    }

    public List<String> getWx() {
        return wx;
    }

    public List<String> getWy() {
        return wy;
    }

    public List<String> getWz() {
        return wz;
    }
}
