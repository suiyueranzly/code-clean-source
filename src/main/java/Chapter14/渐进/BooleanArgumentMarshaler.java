package Chapter14.渐进;


import java.util.Iterator;

public class BooleanArgumentMarshaler extends ArgumentMarshaler {

    public void set(String s) throws ArgsException {

    }

    public Object get() {
        return booleanValue;
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }
}