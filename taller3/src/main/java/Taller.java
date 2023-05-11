import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class Taller {

    public static void main(String[] args) {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Holaa");
            emitter.onNext("me llamo");
            emitter.onNext("Adrian !");
            emitter.onComplete();
        });

        observable.subscribe(System.out::println);

        Observable<String> observable2 = Observable.just("ejemplo", "de", "observer");

        Observer<String> observer1 = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                System.out.println("Observer1: " + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
            }

            @Override
            public void onComplete() {
            }

        };

        Observer<String> observer2 = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                System.out.println("Observer2: " + s);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };

        observable.subscribe(observer1);
        observable.subscribe(observer2);


    }

}
