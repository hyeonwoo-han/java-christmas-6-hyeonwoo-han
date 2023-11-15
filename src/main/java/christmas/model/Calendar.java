package christmas.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calendar {
    private static final List<Integer> christmasEventDates = IntStream.rangeClosed(1, 25).boxed().toList();
    private static final List<Integer> starredDates = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static final List<Integer> weekDays = Arrays.asList(
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31);
    private static final List<Integer> weekends = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

    public boolean doesMatchWithChristmasDDayEvent(int visitDate) {
        return christmasEventDates.contains(visitDate);
    }

    public boolean doesMatchWithWeekDaysEvent(int visitDate) {
        return weekDays.contains(visitDate);
    }

    public boolean doesMatchWithWeekendsEvent(int visitDate) {
        return weekends.contains(visitDate);
    }

    public boolean doesMatchWithStarredDatesEvent(int visitDate) {
        return starredDates.contains(visitDate);
    }
}
