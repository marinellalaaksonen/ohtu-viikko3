package ohtu;

import java.util.Arrays;

public class Submission implements Comparable<Submission> {
    public int week;
    public String course;
    public int hours;
    public int[] exercises;

    // public void setWeek(int week) {
    //     this.week = week;
    // }

    // public int getWeek() {
    //     return week;
    // }

    // public void setCourse(String course) {
    //     this.course = course;
    // }

    // public String getCourse() {
    //     return this.course;
    // }

    // public void setHours(int hours) {
    //     this.hours = hours;
    // }

    // public int getHours() {
    //     return hours;
    // }

    // public void setExercises(int[] exercises) {
    //     this.exercises = exercises;
    // }

    // public int[] getExercises() {
    //     return exercises;
    // }

    public String tehtavatStringina() {
        String s = Arrays.toString(exercises);
        return s.substring(1, s.length()-1); //Jätetään sulut pois
    }

    @Override
    public int compareTo(Submission other) {
        return this.week - other.week;
    }

    @Override
    public String toString() {
        return course + ", viikko " + week + " tehtyjä tehtäviä yhteensä " + exercises.length + " aikaa kului " + hours + 
                " tehdyt tehtävät: " + tehtavatStringina();
    }
    
}