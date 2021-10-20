package Chapter14.渐进;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler extends ArgumentMarshaler {

    public void set(String s) throws ArgsException {
        this.stringValue = s;
    }

    public Object get() {
        return stringValue;
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException();
        }
    }
}
