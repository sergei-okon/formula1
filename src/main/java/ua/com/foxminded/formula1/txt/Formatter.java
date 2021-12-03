package ua.com.foxminded.formula1.txt;

import ua.com.foxminded.formula1.model.Racer;

import java.util.List;

public class Formatter {

    public String format(List<Racer> racers) {
        String output = "";

        int number = 1;
        String outputTemp = "";

        for (int i = 0; i < racers.size(); i++) {

            outputTemp = (number + "|" + racers.get(i).getName() + "|" + racers.get(i).getTeam() + "|" +
                    racers.get(i).getStart() + "|" + racers.get(i).getEnd() + "\n");

            output = output + outputTemp;
            number++;
        }
        return output;
    }
}
