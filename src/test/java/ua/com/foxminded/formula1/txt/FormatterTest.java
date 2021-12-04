package ua.com.foxminded.formula1.txt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.formula1.math.TimeCount;
import ua.com.foxminded.formula1.model.Racer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    TimeCount timeCount;
    Formatter formatter;

    @BeforeEach
    void setUp() {
        timeCount = new TimeCount();
        formatter = new Formatter();
    }

    @Test
    void format_ShouldSuccess_whenArgsIsCorrect() throws IOException {
        List<String> abbreviationsRacers = Files.lines(Paths.get("docs/abbreviations.txt")).collect(Collectors.toList());
        List<String> startList = Files.lines(Paths.get("docs/start.log")).collect(Collectors.toList());
        List<String> endList = Files.lines(Paths.get("docs/end.log")).collect(Collectors.toList());

        TimeCount timeCount = new TimeCount();

        Formatter formatter = new Formatter();
        String output = formatter.format(timeCount.createRacer(abbreviationsRacers, startList, endList));

        String expected = """
                1  | Sebastian Vettel          | FERRARI                   | 1:4.415
                2  | Daniel Ricciardo          | RED BULL RACING TAG HEUER | 1:12.013
                3  | Valtteri Bottas           | MERCEDES                  | 1:12.434
                4  | Lewis Hamilton            | MERCEDES                  | 1:12.46
                5  | Stoffel Vandoorne         | MCLAREN RENAULT           | 1:12.463
                6  | Kimi Raikkonen            | FERRARI                   | 1:12.639
                7  | Fernando Alonso           | MCLAREN RENAULT           | 1:12.657
                8  | Sergey Sirotkin           | WILLIAMS MERCEDES         | 1:12.706
                9  | Charles Leclerc           | SAUBER FERRARI            | 1:12.829
                10 | Sergio Perez              | FORCE INDIA MERCEDES      | 1:12.848
                11 | Romain Grosjean           | HAAS FERRARI              | 1:12.93
                12 | Pierre Gasly              | SCUDERIA TORO ROSSO HONDA | 1:12.941
                13 | Carlos Sainz              | RENAULT                   | 1:12.95
                14 | Esteban Ocon              | FORCE INDIA MERCEDES      | 1:13.028
                15 | Nico Hulkenberg           | RENAULT                   | 1:13.065
                _____________________________________________________________________
                16 | Brendon Hartley           | SCUDERIA TORO ROSSO HONDA | 1:13.179
                17 | Marcus Ericsson           | SAUBER FERRARI            | 1:13.265
                18 | Lance Stroll              | WILLIAMS MERCEDES         | 1:13.323
                19 | Kevin Magnussen           | HAAS FERRARI              | 1:13.393
                """;
        assertEquals(expected, output);
    }
}