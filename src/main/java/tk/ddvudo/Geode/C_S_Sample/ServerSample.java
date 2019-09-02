package tk.ddvudo.Geode.C_S_Sample;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.RegionService;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.distributed.LocatorLauncher;
import org.apache.geode.distributed.ServerLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerSample {
    static Logger logger = LoggerFactory.getLogger(ServerSample.class.getName());

    public static void main(String... args) throws InterruptedException {
        ClientCache cache = new ClientCacheFactory().create();
        RegionService regionService = cache.createAuthenticatedView(System.getProperties());
        while (true) {
            Thread.sleep(100);
        }
    }
}
