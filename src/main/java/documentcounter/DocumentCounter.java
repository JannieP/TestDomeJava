package documentcounter;

public class DocumentCounter {

    public static class Counter {
        private int count = 0;
        private int increment;

        public Counter(int increment) {
            this.increment = increment;
        }

        public int getAndIncrement() {
            this.count += this.increment;
            return this.count;
        }

    }

    public static class DocumentNameCreator {
        private String prefix;
        private Counter counter;

        public DocumentNameCreator(String prefix, Counter counter) {
            this.counter = counter;
            this.prefix = prefix;
        }

        public String getNewDocumentName() {
            return prefix + this.counter.getAndIncrement();
        }
    }
}
