import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class LastAccessed implements Function<String, String> {

    private static long lastAccessedOn;

    private long getLastAccessedOn() {
        return lastAccessedOn;
    }

    private void setLastAccessedOn(long lastAccessedOn) {
        LastAccessed.lastAccessedOn = lastAccessedOn;
    }

    @Override
    public String apply(String name) {
        DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
        if (this.getLastAccessedOn() == 0) {
            this.setLastAccessedOn(System.currentTimeMillis());
        }
        Date result = new Date(this.getLastAccessedOn());
        this.setLastAccessedOn(System.currentTimeMillis());
        return simple.format(result);
    }

    public static void main(String[] args) throws Throwable{
        while (true) {
            System.out.println(new LastAccessed().apply("demo"));
            Thread.sleep(5000);
        }
    }
}