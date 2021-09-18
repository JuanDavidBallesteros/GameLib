package TADAction;

public interface StackAction<T> {
    public void push(T value);
    public boolean isEmpty();
    public T top();
    public T pop();
}
