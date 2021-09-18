package TADAction;

public interface QueueAction<T> {
    public void add(T value);
    public boolean isEmpty();
    public T front();
    public T dequeue();
}
