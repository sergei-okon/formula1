package ua.com.foxminded.formula1.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Racer {
    String abbreviations;
    String name;
    String team;
    LocalDateTime start;
    LocalDateTime end;
    Duration duration;

    public Racer() {
    }

    public Racer(String abbreviations, String name, String team, LocalDateTime start, LocalDateTime end, Duration duration) {
        this.abbreviations = abbreviations;
        this.name = name;
        this.team = team;
        this.start = start;
        this.end = end;
        this.duration = duration;
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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "abbreviations='" + abbreviations + '\'' +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                '}';
    }
}


