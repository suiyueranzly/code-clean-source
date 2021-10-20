package Chapter14.渐进;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerArgumentMarshaler extends ArgumentMarshaler {

    private Integer intValue = 0;

    public void set(String s) throws ArgsException {
        try {
            this.intValue = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new ArgsException();
        }
    }

    public Object get() {
        return intValue;
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            this.intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException();
        } catch (NumberFormatException e) {
            throw new ArgsException();
        }
    }
}
