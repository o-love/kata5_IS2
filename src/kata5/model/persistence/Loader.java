package kata5.model.persistence;

public interface Loader<T> {
    Iterable<T> items();
}
