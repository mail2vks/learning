package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

// Refer - https://antoniogoncalves.org/2015/01/15/micro-benchmarking-with-jmh-measure-dont-guess/
@State(Scope.Thread)
public class LoggingBenchMark {

    Logger logger;

    @Setup
    public void setUp() {
        logger = LoggerFactory.getLogger(LoggingBenchMark.class);
    }

    @Benchmark
    public int testConcatenationStrings() {

        String x = "", y = "", z = "";

        for (int i = 0; i < 100; i++) {
            x += i;
            y += i;
            z += i;
            logger.debug("Strings are : " + x + " " + y + " " + z);
        }
        return 1;
    }

    @Benchmark
    public void testVariableArguments() {

        String x = "", y = "", z = "";

        for (int i = 0; i < 100; i++) {
            x += i;
            y += i;
            z += i;

            logger.debug("Variable arguments {} {} {}", x, y, z);
        }
    }

    @Benchmark
    public void testIfDebugEnabled() {

        String x = "", y = "", z = "";

        for (int i = 0; i < 100; i++) {
            x += i;
            y += i;
            z += i;

            if (logger.isDebugEnabled())
                logger.debug("If debug enabled {} {} {}", x, y, z);
        }
    }

    public static void main(String[] args) {
        Options opt = new OptionsBuilder().include(LoggingBenchMark.class.getSimpleName()).warmupIterations(3).forks(5)
                .measurementIterations(3).timeUnit(TimeUnit.SECONDS).build();
    }

}