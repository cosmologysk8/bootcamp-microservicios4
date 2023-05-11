import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> shopping = List.of( new Product("Clothes",
                        new BigDecimal("15.90"), Tax.NORMAL),
                new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
                new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
                new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
                new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
                new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));


        BigDecimal precioTotal = shopping.stream().map(product -> product.getPrice().
                multiply(BigDecimal.valueOf(1 + (double) product.getTax().getPercent() / 100)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        precioTotal = precioTotal.setScale(2, RoundingMode.HALF_DOWN);

        System.out.println("Total : " + precioTotal);

        List<String> empiezaPorC = shopping.stream().filter(p -> p.name.startsWith("C")).map(Product::getName).collect(Collectors.toList());
        System.out.println("Letras que empiezan por C : " + empiezaPorC);

    }

}
