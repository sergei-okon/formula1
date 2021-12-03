package ua.com.foxminded.formula1.math;

import ua.com.foxminded.formula1.model.Racer;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeCount {

    public List<Racer> createRacer(List<String> abbreviationsRacers, List<String> startList, List<String> endList) {
        List<Racer> racers = splitAbbreviations(abbreviationsRacers);
        Map<String, String> startSplitLogMapSplitLogFiles = splitLogFiles(startList);
        Map<String, String> endSplitLogMapSplitLogFiles = splitLogFiles(endList);

//        System.out.println(racers);
//        System.out.println(startSplitLogMapSplitLogFiles);
//        System.out.println("===========================================================================================");
//        System.out.println(endSplitLogMapSplitLogFiles);
//        System.out.println("===========================================================================================");

        String strTempStart = "";
        String strTempEnd = "";
        String abbTemp = "";
        for (int i = 0; i < racers.size(); i++) {
            abbTemp = racers.get(i).getAbbreviations();

            strTempStart = startSplitLogMapSplitLogFiles.getOrDefault(abbTemp, "Value not found");
            racers.get(i).setStart(strTempStart);

            strTempEnd = endSplitLogMapSplitLogFiles.getOrDefault(abbTemp, "Value not found");
            racers.get(i).setEnd(strTempEnd);
//            System.out.println("+++++++" + strTempEnd);
        }


        return racers;
    }

    private List<Racer> splitAbbreviations(List<String> abbreviationsRacers) {
        List<Racer> racers = new ArrayList<>();

        String[] strTemp;

        for (String abbreviation : abbreviationsRacers) {
            strTemp = abbreviation.split("_");

            Racer racer = new Racer();
            racer.setAbbreviations(strTemp[0]);
            racer.setName(strTemp[1]);
            racer.setTeam(strTemp[2]);

            racers.add(racer);
        }
        return racers;
    }

    //Разделяет текстовые файлы
    private Map<String, String> splitLogFiles(List<String> logs) {
        Map<String, String> splitLogMap = new HashMap<>();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:nnn");


        String indexZero;
        //TODO Переконвертить IndexOne в localTime
        String indexOne;

        for (String log : logs) {
            indexZero = log.substring(0, 3);
            indexOne = log.substring(3);

            splitLogMap.put(indexZero, indexOne);
        }
        return splitLogMap;
    }
}
