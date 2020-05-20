package Streams.ex2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class test {

    public static void main(String[] args) {

        //Compute a list of the three teams with the fastest cars
        List<String> fastestTeams = Stream.generate(F1Car::new).limit(50)
                .sorted(Comparator.comparing(F1Car::getMaxSpeed).reversed()) //Reversed is used because otherwise
                //it would start with the slowest cars first, so we would get the three slowest teams later
                .map(F1Car::getTeam)
                .distinct() //To make sure we don't have any team more than once
                .limit(3) //We want three teams
                .collect(Collectors.toList()); //Collect them into a list
        System.out.println(fastestTeams);

        //Print the average speed of the cars with the driver who has won at least 8 races
        Stream.generate(F1Car::new).limit(50)
                .filter(car -> car.getDriver().getRacesWon() >= 8) //We take the driver of the car and then look at his races won
                .mapToInt(F1Car::getMaxSpeed) // Now we are interested in the speed of the cars
                .average()
                .ifPresent(System.out::println); //average function returns an optional because if we don't have any
        //drivers with more than 8 races won then it can't take an average because we wouldn't have any cars
        //This would result in a division by zero. That's why average() is an optional and we print out using
        //ifPresent() in case it is not :)

        //Compute a comma-separated string containing the three drivers who have won the smallest amount of races
        String names = Stream.generate(F1Car::new).limit(50)
                .sorted(Comparator.comparing(c -> c.getDriver().getRacesWon())).limit(3) // Very similar to the exercise above
                .map(F1Car::getDriver)
                .map(d -> d.getFirstName() + " " + d.getLastName())
                .collect(Collectors.joining(", "));
        System.out.println(names);
    }

}
