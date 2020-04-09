package org.apache.geode.addon.demo;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.query.FunctionDomainException;
import org.apache.geode.cache.query.NameResolutionException;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryInvocationTargetException;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.TypeMismatchException;

/**
 * CacheRead dumps the specified Region values.
 * 
 * @author dpark
 *
 */
public class CacheRead {
	public final static String PROPERTY_executableName = "executable.name";

	private static void usage() {
		String executableName = System.getProperty(PROPERTY_executableName, CacheRead.class.getName());
		writeLine();
		writeLine("Usage:");
		writeLine("   " + executableName + " region_path [-?]");
		writeLine();
		writeLine("   Dumps the values of the specified region.");
		writeLine();
		writeLine("       region_path   Region path.");
		writeLine();
	}

	private static void writeLine() {
		System.out.println();
	}

	private static void writeLine(String line) {
		System.out.println(line);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws FunctionDomainException, TypeMismatchException, NameResolutionException, QueryInvocationTargetException {

		if (args.length == 0) {
			System.err.println("Region path not specified. Command aborted.");
			System.exit(1);
		}

		String regionPath = args[0];
		if (regionPath.equals("-?")) {
			usage();
			System.exit(0);
		}
		ClientCache clientCache = new ClientCacheFactory().create();
		Region region = clientCache.getRegion(regionPath);
		
		if (region == null) {
			System.out.println("Region undefined: " + regionPath);
		} else {
			Query query = clientCache.getQueryService().newQuery("select * from " + regionPath);
			System.out.println("Region Values [" + regionPath + "]:");
			SelectResults sr = (SelectResults)query.execute();
			sr.forEach(c -> System.out.println("\t" + c));
		}
		clientCache.close();
	}
}

