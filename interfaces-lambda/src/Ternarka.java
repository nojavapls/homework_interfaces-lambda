import java.util.function.Function;
import java.util.function.Predicate;

public class Ternarka {
    public static Function<Integer, String> ternaryOperator(
            Predicate<? super Integer> condition,
            Function<? super Integer, ? extends String> ifTrue,
            Function<? super Integer, ? extends String> ifFalse) {
        return result -> condition.test(result) ? ifTrue.apply(result) : ifFalse.apply(result);
    }
}
