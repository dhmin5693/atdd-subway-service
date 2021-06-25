package nextstep.subway.path.domain;

@FunctionalInterface
public interface DiscountStrategy {

    DiscountStrategy CHILD_INSTANCE = new ChildDiscountStrategy();
    DiscountStrategy TEENAGER_INSTANCE = new TeenagerDiscountStrategy();
    DiscountStrategy NO_INSTANCE = new NoDiscountStrategy();

    int COMMON_DISCOUNT_AMOUNT = 350;

    int discount(int fare);

    default void verifyNotNegativeFare(int fare) {
        if (fare - COMMON_DISCOUNT_AMOUNT < 0) {
            throw new IllegalArgumentException(
                String.format("요금 할인을 받기 위해서는 최소 %d원의 요금을 지불해야 합니다.", COMMON_DISCOUNT_AMOUNT));
        }
    }

    static DiscountStrategy of(int age) {
        if (age >= 6 && age < 13) {
            return CHILD_INSTANCE;
        }

        if (age >= 13 && age < 19) {
            return TEENAGER_INSTANCE;
        }

        return NO_INSTANCE;
    }
}
