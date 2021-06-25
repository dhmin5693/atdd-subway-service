package nextstep.subway.auth.domain;

import java.util.Optional;
import nextstep.subway.path.domain.DiscountStrategy;

public class Guest implements User {

    private static final Guest instance = new Guest();

    private Guest() { }

    public static Guest getInstance() {
        return instance;
    }

    @Override
    public Optional<UserProperty> getUserProperty() {
        return Optional.empty();
    }

    @Override
    public DiscountStrategy getDiscountStrategy() {
        return DiscountStrategy.of(0);
    }
}
