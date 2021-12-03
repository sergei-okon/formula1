package ua.com.foxminded.formula1;

import ua.com.foxminded.formula1.math.TimeCount;
import ua.com.foxminded.formula1.model.Racer;
import ua.com.foxminded.formula1.txt.Formatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> abbreviationsRacers = Files.lines(Paths.get("docs/abbreviations.txt")).collect(Collectors.toList());
        List<String> startList = Files.lines(Paths.get("docs/start.log")).collect(Collectors.toList());
        List<String> endList = Files.lines(Paths.get("docs/end.log")).collect(Collectors.toList());

        TimeCount timeCount = new TimeCount();


        Formatter formatter = new Formatter();
        String output = formatter.format(timeCount.createRacer(abbreviationsRacers, startList, endList));

        System.out.print(output.toString());
//        Counter counter = new Counter();
//        Result result = counter.countUniqueSymbols(stringArgs);
//
//        Formatter formatter = new Formatter();
//        StringBuilder output = formatter.format(result);


//        System.out.println(timeCount.createRacer(abbreviationsRacers, startList, endList));
    }
}
