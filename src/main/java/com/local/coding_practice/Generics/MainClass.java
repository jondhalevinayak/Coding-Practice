package com.local.coding_practice.Generics;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        Employee ft = new FTEmployee();
        Employee ct = new CTEmployee();

        Car toyota = new Toyota();
        Car nissan = new Nissan();

        ObjectBox<Employee> objEmp = new ObjectBox<>(List.of(ct, ft));
        ObjectBox<Car> objCar = new ObjectBox<>(List.of(toyota, nissan));

        List<Employee> empList = objEmp.getList();
        List<Car> carList = objCar.getList();

        empList.forEach(e -> System.out.println(e.getSalary()));
        System.out.println("==================================");
        carList.forEach(c -> System.out.println(c.getCar()));

    }
}
