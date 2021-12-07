package ua.com.foxminded.formula1.math;

import ua.com.foxminded.formula1.model.Racer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeCount {

    public List<Racer> createRacer(List<String> abbreviationsRacers, List<String> startList, List<String> endList) {
        List<Racer> racers = splitAbbreviations(abbreviationsRacers);
        Map<String, LocalDateTime> startSplitLogMapSplitLogFiles = splitLogFiles(startList);
        Map<String, LocalDateTime> endSplitLogMapSplitLogFiles = splitLogFiles(endList);

        racers.forEach(racer -> {
            String abbTemp = racer.getAbbreviations();

            LocalDateTime strTempStart = startSplitLogMapSplitLogFiles.getOrDefault(abbTemp, null);
            racer.setStart(strTempStart);

            LocalDateTime strTempEnd = endSplitLogMapSplitLogFiles.getOrDefault(abbTemp, null);
            racer.setEnd(strTempEnd);

            Duration duration = Duration.between(strTempStart, strTempEnd);
            racer.setDuration(duration);
        });

        return racers;
    }

    private List<Racer> splitAbbreviations(List<String> abbreviationsRacers) {
        List<Racer> racersAbbList = new ArrayList<>();

        abbreviationsRacers.stream()
                .map(abbreviation -> abbreviation.split("_"))
                .forEach(strTemp -> {
                    Racer racer = new Racer();
                    racer.setAbbreviations(strTemp[0]);
                    racer.setName(strTemp[1]);
                    racer.setTeam(strTemp[2]);
                    racersAbbList.add(racer);
                });

        return racersAbbList;
    }

    private Map<String, LocalDateTime> splitLogFiles(List<String> logs) {
        Map<String, LocalDateTime> splitLogMap = new HashMap<>();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

        logs.forEach(log -> {
            String indexZero = log.substring(0, 3);
            LocalDateTime indexOne = LocalDateTime.parse(log.substring(3), formatterDate);
            splitLogMap.put(indexZero, indexOne);
        });

        return splitLogMap;
    }
}
