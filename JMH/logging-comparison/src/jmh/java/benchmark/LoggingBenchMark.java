package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Refer - https://antoniogoncalves.org/2015/01/15/micro-benchmarking-with-jmh-measure-dont-guess/
public class LoggingBenchMark {

	private static final Logger logger = LoggerFactory.getLogger(LoggingBenchMark.class);

	@Benchmark
	public int testConcatenationStrings() {
		String x = "Aplha";
		String y = "Beta";
		String z = "Gamma";

		for(int i = 0; i < 100; i++){
			x += i; y += i; z += i;
			logger.debug("Strings are : " + x + " " + y + " " + z);
		}
		return 1;
	}

	@Benchmark
	public void testVariableArguments() {
	 
	  String x = "", y = "", z = "";
	 
	  for (int i = 0; i < 100; i++) {
	    x += i; y += i; z += i;
	 
	    logger.debug("Variable arguments {} {} {}", x, y, z);
	  }
	}

	@Benchmark
	public void testIfDebugEnabled() {
	 
	  String x = "", y = "", z = "";
	 
	  for (int i = 0; i <100; i++) {
	    x += i; y += i; z += i;
	 
	    if (logger.isDebugEnabled())
	      logger.debug("If debug enabled {} {} {}", x, y, z);
	  }
	}

}