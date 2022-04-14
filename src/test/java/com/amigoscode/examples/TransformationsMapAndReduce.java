package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS = people.stream()
                .map(PersonDTO::map)
                .collect(Collectors.toList());
        assertThat(people.size()).isEqualTo(personDTOS.size());
        personDTOS.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers)
                .reduce(0, (a, b) -> a + b);
        int sum2 = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        int substraction = Arrays.stream(integers)
                .reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(substraction);

    }
}

