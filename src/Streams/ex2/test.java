package Streams.ex2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class test {

    public static void main(String[] args) {
        List<String> fastestTeams = Stream.generate(F1Car::new)
                .limit(50)
                .sorted(Comparator.comparing(F1Car::getMaxSpeed).reversed())
                .map(F1Car::getTeam)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(fastestTeams);

        Stream.generate(F1Car::new)
                .limit(50)
                .filter(c -> c.getDriver().getRacesWon() >= 8)
                .mapToDouble(F1Car::getMaxSpeed)
                .average()
                .ifPresent(System.out::println);

        String names = Stream.generate(F1Car::new)
                .limit(50)
                .sorted(Comparator.comparing(c -> c.getDriver().getRacesWon()))
                .limit(3)
                .map(F1Car::getDriver)
                .map(d -> d.getFirstName() + " " + d.getLastName())
                .collect(Collectors.joining(", "));
        System.out.println(names);
    }

}
