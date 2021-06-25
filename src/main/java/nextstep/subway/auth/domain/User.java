package nextstep.subway.auth.domain;

import java.util.Optional;
import nextstep.subway.path.domain.DiscountStrategy;

public interface User {

    Optional<UserProperty> getUserProperty();

    DiscountStrategy getDiscountStrategy();
}
