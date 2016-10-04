package connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by sander on 28-9-16.
 */
public class ConnectionCreationTest {

    //Helper methds
    private long connectionURLGetTime() {
        long start = System.nanoTime();

        ConnectionCreation cc = new ConnectionCreation();

        for(int i = 0; i < 456000; i++) {
            String url = cc.addConnectionURL();
        }

        long end = System.nanoTime();

        long duration = (end - start)/1000000;

        return duration;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * change i < 10 to i < 1000 for a realistic average (within a reasonable timescale)
     */
    @Test
    public void addConnectionURL_TimeTest() {
        ArrayList<Long> durations = new ArrayList<Long>();
        for(int i = 0; i < 100; i++) {
            long duration = connectionURLGetTime();
            System.out.println("[" + i + "%]Time to add 456000 items: " + duration + "ms");

            durations.add(duration);
        }

        long avg = 0;

        for (long duration : durations) {
            avg += duration;
        }

        avg = avg / durations.size();
        System.out.println("AVG: Time to add 456000 items: " + avg + "ms");
    }

    @Test
    public void addConnectionURL() throws Exception {
        System.out.println("ConnectionCreation - addConnectionURL");
        HashSet<String> links = new HashSet<String>();

        ConnectionCreation cc = new ConnectionCreation();

        for(int i = 0; i < 10000; i++) {
            String url = cc.addConnectionURL();
            assertFalse(links.contains(url));
            links.add(url);
        }
    }

    @Test
    public void addConnectionURL_BigNumbers() throws Exception {
        System.out.println("ConnectionCreation - addConnectionURL_BigNumbers");
        HashSet<String> links = new HashSet<String>();

        ConnectionCreation cc = new ConnectionCreation();

        boolean crashed = false;

        try{
            for(int i = 0; i < 10000000; i++) {
                String url = cc.addConnectionURL();
                assertFalse(links.contains(url));
                links.add(url);
            }
        } catch (StackOverflowError ex) {
            crashed = true;
            fail();
        } finally {
            assertFalse(crashed);
        }
    }

    @Test
    public void removeConnectionURL() throws Exception {

    }

}