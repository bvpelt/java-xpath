package nl.bsoft;

import com.codahale.metrics.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by bvpelt on 6/3/17.
 *
 *
 * http://metrics.dropwizard.io/3.2.2/getting-started.html
 */
public class GetStarted {
    private final Logger log = LoggerFactory.getLogger(GetStarted.class);

    static final MetricRegistry metrics = new MetricRegistry();

    public static void main(String args[]) {
        startReport();
        Meter requests = metrics.meter("requests");
        requests.mark();
        waitnSeconds(10);
    }

    static void startReport() {

        final ConsoleReporter reporterConsole = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();

        final Slf4jReporter reporterSlf4j = Slf4jReporter.forRegistry(metrics)
                .outputTo(LoggerFactory.getLogger("nl.bsoft.GetStarted"))
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();

        final JmxReporter reporterJmx = JmxReporter.forRegistry(metrics).build();

        reporterConsole.start(1, TimeUnit.SECONDS);
        reporterSlf4j.start(1, TimeUnit.SECONDS);
        reporterJmx.start();
    }

    static void waitnSeconds(int n) {
        try {
            Thread.sleep(n*1000);
        }
        catch(InterruptedException e) {}
    }
}
