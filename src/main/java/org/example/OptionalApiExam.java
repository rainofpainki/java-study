package org.example;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalApiExam {

    public static void main(String[] args) {

        // 기본 예제
        Optional<String> opt = Optional.ofNullable("값이 없음");
        System.out.println(opt.get());

        // 예외 발생
        try {
            Optional<String> opt2 = Optional.empty();
            System.out.println(opt2.get());
        } catch(NoSuchElementException e) {
            // 값이 없을 경우 NoSuchElementException 발생
            e.printStackTrace();
        }

        // orElse, orElseGet, orElseThrow 메소드
        try {
            Optional<String> opt3 = Optional.empty();
            System.out.println(opt3.orElse("비어 있음"));
            System.out.println(opt3.orElseGet(() -> "비어 있습니다."));
            System.out.println(opt3.orElseThrow(() -> new NoSuchElementException("객체가 비어있다구요.")));
        } catch(Exception e) {
            e.printStackTrace();
        }

        // IntStream
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        OptionalInt result = stream.findFirst();
        System.out.println(result.getAsInt());
    }
}
