package ua.com.foxminded.formula1.txt;

import ua.com.foxminded.formula1.model.Racer;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {

    public String format(List<Racer> racers) {

        racers = racers.stream().sorted(Comparator.comparing(Racer::getDuration)).collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        int number = 1;
        String outputTemp;
        String strDataTemp;

        for (int i = 0; i < racers.size(); i++) {
            if (i == 15) {
                output.append("_____________________________________________________________________").append("\n");
            }

            strDataTemp = Duration.between(racers.get(i).getStart(), racers.get(i).getEnd()).toString().substring(2)
                    .replace("M", ":").replace("S", "");

            int length = (int) (Math.log10(number) + 1);

            if (length >= 2) {
                outputTemp = (number + " | " + racers.get(i).getName() + (" ").repeat(25 - racers.get(i).getName().length()) +
                        " | " + racers.get(i).getTeam() + (" ").repeat(26 - racers.get(i).getTeam().length()) + "| " +
                        strDataTemp + "\n");
            } else
                outputTemp = (number + "  | " + racers.get(i).getName() + (" ").repeat(25 - racers.get(i).getName().length()) +
                        " | " + racers.get(i).getTeam() + (" ").repeat(26 - racers.get(i).getTeam().length()) + "| " +
                        strDataTemp + "\n");
            output.append(outputTemp);
            number++;
        }
        return output.toString();
    }
}
