package cache;


public class Cache {

    public static void main(String[] args) {
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache = (Cache) optimizedDiskCache;

        MemoryCache memoryCache1 = new MemoryCache();
        Cache cache1 = (Cache) memoryCache1;
        //DiskCache diskCache1 = (DiskCache) cache1;

        DiskCache diskCache2 = new DiskCache();
        //OptimizedDiskCache optimizedDiskCache2 = (OptimizedDiskCache) diskCache2;

        OptimizedDiskCache optimizedDiskCache3 = new OptimizedDiskCache();
        DiskCache diskCache3 = (DiskCache) optimizedDiskCache3;

        Cache cache4 = new Cache();
        //MemoryCache memoryCache4 = (MemoryCache) cache4;

        OptimizedDiskCache optimizedDiskCache5 = new OptimizedDiskCache();
        Cache cache5 = (Cache) optimizedDiskCache5;
        DiskCache diskCache5 = (DiskCache) cache5;
    }

}
class DiskCache extends Cache {}
class MemoryCache extends Cache {}
class OptimizedDiskCache extends DiskCache {}

