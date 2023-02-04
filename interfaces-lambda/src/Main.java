import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> checkInt = new Predicate<Integer>() {
            @Override
            public boolean test(Integer check) {
                return check >= 0;
            }
        };

        Predicate<Integer> checkIntLabda = x -> x >= 0;

        System.out.println("Число положительное? " + checkInt.test(25));
        System.out.println("Число положительное? " + checkInt.test(-9));
        System.out.println("Число положительное? " + checkIntLabda.test(0));
        System.out.println("Число положительное? " + checkIntLabda.test(-1));



        Consumer<String> introduce = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println("Привет, я " + name);
            }
        };

        Consumer<String> introduceLambda = name -> System.out.println("Привет, я " + name);

        introduce.accept("Герман Греф");
        introduceLambda.accept("Белла Златкис");



        Function<Double, Long> toLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double number) {
                return Double.valueOf(number).longValue();
            }
        };

        Function<Double, Long> toLongLambda = number -> Double.valueOf(number).longValue();

        System.out.println(toLong.apply(1.08776));
        System.out.println(toLong.apply(999.999));
        System.out.println(toLongLambda.apply(1.08776));
        System.out.println(toLongLambda.apply(999.999));


        Supplier<Integer> intRand = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //конкурятина
                return ThreadLocalRandom.current().nextInt(0, 101);
            }
        };

        Supplier<Integer> intRandLambda = () -> ThreadLocalRandom.current().nextInt(0, 101);

        System.out.println(intRand.get());
        System.out.println(intRandLambda.get());



        Predicate<Integer> condition = speed -> speed <= 60;
        Function<Integer, String> ifTrue = message -> "Скорость не была превышена";
        Function<Integer, String> ifFalse = message -> "Штраф! Превышение скорости";

        Function<Integer, String> speedLimit = Ternarka.ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(speedLimit.apply(225));
        System.out.println(speedLimit.apply(60));
        System.out.println(speedLimit.apply(180));
    }


}