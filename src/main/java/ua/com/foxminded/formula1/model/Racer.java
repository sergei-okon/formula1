package ua.com.foxminded.formula1.model;

public class Racer {
    String abbreviations;
    String name;
    String team;
    String start;
    String end;

    public Racer() {
    }

    public String getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(String abbreviations) {
        this.abbreviations = abbreviations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "abbreviations='" + abbreviations + '\'' +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
