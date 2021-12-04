package ua.com.foxminded.formula1.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.formula1.model.Racer;
import ua.com.foxminded.formula1.txt.Formatter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeCountTest {
    TimeCount timeCount;
    Formatter formatter;

    @BeforeEach
    void setUp() {
        timeCount = new TimeCount();
        formatter = new Formatter();
    }

    @Test
    void createRacer_shouldMadeObjectRacer_whenArgsIsCorrect() {
        List<String> abbreviationsRacers = new ArrayList<>(Collections.singleton("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER"));
        List<String> startList = new ArrayList<>(Collections.singleton("DRR2018-05-24_12:14:12.054"));
        List<String> endLis = new ArrayList<>(Collections.singleton("DRR2018-05-24_12:15:24.067"));

        abbreviationsRacers.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        startList.add("DRR2018-05-24_12:14:12.054");
        endLis.add("DRR2018-05-24_12:15:24.067");

        LocalDateTime start = LocalDateTime.parse("2018-05-24T12:14:12.054");
        LocalDateTime end = LocalDateTime.parse("2018-05-24T12:15:24.067");
        Duration duration = Duration.parse("PT1M12.013S");

        Racer expected = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", start, end, duration);

        List<Racer> actual = timeCount.createRacer(abbreviationsRacers, startList, endLis);

        assertEquals(expected.getAbbreviations(), actual.get(0).getAbbreviations());
        assertEquals(expected.getName(), actual.get(0).getName());
        assertEquals(expected.getTeam(), actual.get(0).getTeam());
        assertEquals(expected.getStart(), actual.get(0).getStart());
        assertEquals(expected.getEnd(), actual.get(0).getEnd());
        assertEquals(expected.getDuration(), actual.get(0).getDuration());
    }
}