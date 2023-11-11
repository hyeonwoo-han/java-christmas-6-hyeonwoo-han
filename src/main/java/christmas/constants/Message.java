package christmas.constants;

public enum Message {

    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASK_VISITING_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW_EVENT_BENEFIT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!") {
        @Override
        public String getEventPreviewMsg(int date) {
            return String.format(getContent(), date);
        }
    },
    ORDERED_MENU_INFORM("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT_INFORM("<할인 전 총주문 금액>"),
    GIFT_INFORM("<증정 메뉴>"),
    BENEFIT_INFORM("<혜택 내역>"),
    TOTAL_BENEFIT_INFORM("<총혜택 금액>"),
    DISCOUNTED_TOTAL_PRICE_INFORM("<할인 후 예상 결제 금액>"),
    BADGE_INFORM("<12월 이벤트 배지>");

    private final String content;

    Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getEventPreviewMsg(int date) {
        throw new UnsupportedOperationException("[ERROR] 이 Message는 이벤트 미리보기를 지원하지 않습니다.");
    }
}
