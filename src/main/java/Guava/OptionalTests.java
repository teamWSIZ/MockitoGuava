package Guava;


import com.google.common.base.Optional;

class B {
    public Optional<Integer> funnyFunction(int i) {
        if (i==0) return Optional.of(12);
        return Optional.absent();
    }
}


public class OptionalTests {
    public static void main(String[] args) {
        System.out.println(new B().funnyFunction(10));
        System.out.println(new B().funnyFunction(0).get());

    }
}
