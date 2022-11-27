package myboot.app6.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class TestReactor {

	@Test
	public void testMono() {
		System.out.println("-- test Mono");
		Mono.just(10).log().doFirst(() -> System.out.println("start")).map(v -> v + 10)//
				.doOnNext(v -> System.out.println(v)).map(v -> "Message " + v)//
				.map(v -> v.toUpperCase())//
				.doAfterTerminate(() -> System.out.println("Done")).subscribe(System.out::println);
	}

	@Test
	public void testMulti() {
		System.out.println("-- test multi");
		Flux.just(1, 2, 3).filter(v -> v != 2).subscribe(System.out::println);
	}

	@Test
	public void testMulti2() {
		System.out.println("-- test multi");
		var first = Flux.just(1, 2, 3).blockFirst(Duration.ofSeconds(1));

		var last = Flux.just(1, 2, 3).blockLast(Duration.ofSeconds(1));

		assertEquals(first, 1);
		assertEquals(last, 3);

	}

	@Test
	public void collectListTest() {
		System.out.println("-- test multi");
		Mono<List<Integer>> l = Flux.just(1, 2, 3).collectList();

		// l.subscribe(System.out::println);

		Mono.delay(Duration.ofSeconds(2)).log().then(Mono.just("text")).block();

		System.out.println("After chain");

	}

	@Test
	public void operationsTest() {
		System.out.println("-- test multi");
		Flux.just(2, 2, 2).all(v -> v == 2).subscribe(System.out::println);

		Flux.just(1, 2, 3).any(v -> v == 2).subscribe(System.out::println);

		// Flux.just(2, 1, 3)
		// .sort()
		// .subscribe(System.out::println);

		// Flux.just(2, 1, 3, 2, 3 ,3)
		// .distinct()
		// .subscribe(System.out::println);

		Flux<Integer> f2 = Flux.just(10, 6, 9, 8);
		
		
		
		Flux.just(2, 1, 3, 2, 3, 3)//
				.map(v -> {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					return v;
				})//
				.concatWith(f2)//
				.subscribe(System.out::println);
		
		Function<String, Publisher<String>> mapper = s -> Flux.just(s.toUpperCase().split(""));
		Flux<String> inFlux = Flux.just("baeldung", ".", "com");					   
		}
	
	@Test
	public void errorsTest() {
		System.out.println("-- test multi");
		
		Mono<List<Integer>> l = Flux.just(1, 2, 3).collectList();

		// l.subscribe(System.out::println);

		Mono.delay(Duration.ofSeconds(2)).log().then(Mono.just("text")).block();

		System.out.println("After chain");

	}

}