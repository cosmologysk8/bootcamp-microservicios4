package org.example;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.util.annotation.NonNull;

import java.util.Observable;
import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Consumer;

public class Publisher {

    public static void main(String[] args) {

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        TextSubscriber subscriber = new TextSubscriber();

        publisher.subscribe(subscriber);

        publisher.submit("Mensaje 1");
        publisher.submit("Mensaje 2");
        publisher.submit("Mensaje 3");

        publisher.close();

        Consumer<String> consumer1 = text -> System.out.println("Consumer 1: " + text);
        Consumer<String> consumer2 = text -> System.out.println("Consumer 2: " + text);

        Flux<String> publisherFlux = Flux.just("Hola", "Soy", "Adrian");
        publisherFlux.subscribe(consumer1);
        System.out.println("Consumer 1: Complete");
        publisherFlux.subscribe(consumer2);
        System.out.println("Consumer 2: Complete");

    }

    static class TextSubscriber implements Subscriber<String> {
        private Subscription subscription;

        @Override
        public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println(item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println("Complete");
        }
    }
}
