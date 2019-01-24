package com.jiaxin;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/23 17:06
 */
public abstract class AbstractClass {

    protected abstract int count(int a, int b);

    public static AbstractClass newInstance() {
        return new AbstractClassImpl();
    }

    private final static class AbstractClassImpl extends AbstractClass {

        @Override
        protected int count(int a, int b) {
            return a + b;
        }
    }
}
