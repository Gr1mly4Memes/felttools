package gr1mly4memes.felttools;

import gr1mly4memes.felttools.func.Func;
import gr1mly4memes.felttools.func.Func0;
import gr1mly4memes.felttools.product.Product;

public enum Unit implements Product {
    INSTANCE;

    @Override
    public String toString() {
        return "Unit";
    }

    @Override
    public <R> R map(Func<R> func) {
        if (func instanceof Func0) {
            return ((Func0<R>) func).apply();
        } else {
            return func.applyArray();
        }
    }

    @Override
    public Object productElement(int i) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int productArity() {
        return 0;
    }
}
