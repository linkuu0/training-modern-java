package me.link;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 Stream API
 */
public class StreamApi {
    public static void howToMakeStream() {
        // 1. 스트림 직접 생성
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);

        // 2. Array에서 생성
        int[] arr = new int[] {1, 2, 3, 4, 5};
        Stream<Integer> stream2 = Arrays.stream(arr).boxed();

        // 2-1. Primitive Type Stream -> Int, Long, Double
        IntStream stream2_1 = Arrays.stream(arr);
        stream2_1 = IntStream.of(1, 2, 3, 4, 5);

        // 3. Collection에서 생성
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> stream3 = list.stream();
        stream3.sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        // 3-1. Map의 경우 entrySet을 활용하여 생성
        Map<String, Integer> map = new HashMap<>();
        Stream<Map.Entry<String, Integer>> stream3_1 = map.entrySet().stream();
    }

    /**
     * Stream API는 크게 3가지로 구성되어 있음
     * 1. Stream 생성
     * 2. 중간 처리 - 중간 처리 과정은 메소드 체이닝 패턴으로 동일한 리턴 타입을 가짐. Stream<T>
     *     ㄴ 필터링 - filter(), distinct()
     *     ㄴ 자르기 - skip(), limit()
     *     ㄴ 정렬 - sorted()
     *     ㄴ 매핑 - flatMap(), flatMapToX(), map(), mapToX(), asDoubleStream(), asLongStream() //
     *     ㄴ 조회 - peek()
     * 3. 최종 처리 -
     *     ㄴ 매칭 - allMatch(), anyMatch(), noneMatch()
     *     ㄴ 수집 - collect() 보통 결과를 특정 타입으로 리턴시 활용
     *     ㄴ 루프 - forEach()
     *     ㄴ 집계 - count(), sum(), max(), min(), average(), reduce()
     *     ㄴ 조사 - findFirst(), findAny()
     */
    public static void handleStream() {
        // 1. Stream 생성
        int[] arr = new int[] {1, 2, 3, 4, 5};

        Arrays.stream(arr).boxed()                          // 스트림 생성
                .filter(i -> i > 0)                         // 중간 처리 1 - filter
                .peek(i -> System.out.println("i = " + i))  // 중간 처리 2 - peek
                .map(i -> i+1)                              // 중간 처리 3 - map
                .forEach(System.out::println);              // 최종 처리 - forEach
    }

    public static void main(String[] args) {
        howToMakeStream();
        handleStream();
    }
}
