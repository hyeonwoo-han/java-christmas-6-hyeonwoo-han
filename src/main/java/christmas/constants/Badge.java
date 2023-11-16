package christmas.constants;

public enum Badge {
    STAR_BADGE("별", 5000),
    TREE_BADGE("트리", 10000),
    SANTA_BADGE("산타", 20000);

    private final String name;
    private final int conditionPrice;

    Badge(String name, int price) {
        this.name = name;
        this.conditionPrice = price;
    }

    public String getName() {
        return name;
    }

    public int getCondition() {
        return conditionPrice;
    }
}
