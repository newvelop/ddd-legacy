package kitchenpos.application.fakeobject;

import kitchenpos.domain.Product;
import kitchenpos.domain.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeProductRepository implements ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public FakeProductRepository() {
        for (int i = 1; i <= 5; i++) {
            Product product = new Product();
            product.setId(UUID.fromString("0ac16db7-1b02-4a87-b9c1-e7d8f226c48" + i));
            product.setPrice(BigDecimal.valueOf(1000 * i));
            productList.add(product);
        }
    }

    @Override
    public List<Product> findAllByIdIn(List<UUID> ids) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (ids.contains(product.getId())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        for (Product product : productList) {
            if (productId.equals(product.getId())) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product save(Product product) {
        product.setId(UUID.randomUUID());
        productList.add(product);
        return product;
    }
}
