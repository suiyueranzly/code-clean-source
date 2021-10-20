package Chapter14.渐进;


import java.util.Iterator;

public abstract class ArgumentMarshaler {
    protected boolean booleanValue = false;

    protected String stringValue;

    public abstract void set(String s) throws ArgsException;

    public abstract Object get();

    public abstract void set(Iterator<String> currentArgument) throws ArgsException;

}
