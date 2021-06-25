package nextstep.subway.auth.domain;

import java.util.Objects;
import java.util.Optional;
import nextstep.subway.path.domain.DiscountStrategy;

public class LoginMember implements User {

    private final UserProperty userProperty;

    public LoginMember(Long id, String email, Integer age) {
        this.userProperty = new UserProperty(id, email, age);
    }

    @Override
    public Optional<UserProperty> getUserProperty() {
        return Optional.of(userProperty);
    }

    @Override
    public DiscountStrategy getDiscountStrategy() {
        return DiscountStrategy.of(userProperty.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginMember that = (LoginMember) o;
        return Objects.equals(userProperty, that.userProperty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProperty);
    }
}
