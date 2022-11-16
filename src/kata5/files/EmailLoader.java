package kata5.files;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailLoader implements Loader {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    private final Loader loader;

    public EmailLoader(Loader loader) {
        this.loader = loader;
    }

    @Override
    public Iterable<String> items() {
        return this::createIterator;
    }

    private Iterator<String> createIterator() {
        return new Iterator<>() {
            private final Iterator<String> iterator = loader.items().iterator();
            private String nextEmail = readNextEmail();

            @Override
            public boolean hasNext() {
                return nextEmail != null;
            }

            @Override
            public String next() {
                String toRet = nextEmail;
                nextEmail = readNextEmail();
                return toRet;
            }

            private String readNextEmail() {
                Predicate<String> tester = EMAIL_PATTERN.asMatchPredicate();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (tester.test(next))
                        return next;
                }
                return null;
            }
        };
    }
}
