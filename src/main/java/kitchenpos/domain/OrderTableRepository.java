package kitchenpos.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderTableRepository {
    Optional<OrderTable> findById(UUID orderTableId);

    List<OrderTable> findAll();

    OrderTable save(OrderTable orderTable);
}
