import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {

    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 44, 1, 32}, new int[]{12222, 3, 32, 44}),
                Arguments.of(new int[]{7, 24, 13, 39}, new int[]{7, 13, 24, 39}),
                Arguments.of(new int[]{39, 441, 133, 342}, new int[]{39, 133, 342, 441}),
                Arguments.of(new int[]{83, 14, 1445, 3232}, new int[]{14, 83, 1445, 3232}),
                Arguments.of(new int[]{Integer.MAX_VALUE, 1114, Integer.MIN_VALUE, 32332},
                        new int[]{Integer.MIN_VALUE, 1114, 32332, Integer.MAX_VALUE})
        );
    }

    @ParameterizedTest(name="#{index} testcases - Arguments {0}, {1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> target = new PriorityQueue<Integer>();

        // Populate Priority Queue
        for (int i = 0; i < random_array.length; i++)
            target.add(random_array[i]);

        // Test Result
        for (int i = 0; i < correct_array.length; i++) {
            assertEquals(correct_array[i], target.poll());
        }
    }

    @Test
    public void add_testClassCastException() {
        Exception exception = assertThrows(ClassCastException.class, ( ) -> {
            PriorityQueue<Object> target = new PriorityQueue<Object>();
            target.add("aaa");
            target.add(11);
        });

        assertTrue(exception.getMessage().contains("class java.lang.String cannot be cast to class java.lang.Integer"));
    }

    @Test
    public void add_testNullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> target = new PriorityQueue<Integer>();
            target.add(null);
        });
    }

    @Test
    public void offer_testClassCastException() {
        Exception exception = assertThrows(ClassCastException.class, ( ) -> {
            PriorityQueue<Object> target = new PriorityQueue<Object>();
            target.offer("aaa");
            target.offer(11);
        });

        assertTrue(exception.getMessage().contains("class java.lang.String cannot be cast to class java.lang.Integer"));
    }
}
