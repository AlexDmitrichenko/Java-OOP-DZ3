import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Employee generateEmployee() {
        Random random = new Random();
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий",
                "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов",
                "Горбунов", "Лыткин", "Соколов" };
        int age = random.nextInt(18, 65);
        int workforce = random.nextInt(0, 2);
        int salary = random.nextInt(75, 105);
        int index = random.nextInt(19, 23);
        int time = random.nextInt(8, 184);
        if (workforce == 0) {
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], "Рабочий", age, salary * index);
        } else {
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], "Фрилансер", age, time,
                    salary);
        }
    }
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees);
        System.out.printf("\n*** Отсортированный по алфавиту массив сотрудников ***\n\n");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean filter = true;
        while (filter) {
            System.out.printf(
                    "Также можно отсортировать массив сотрудников:\n1 - по заработной плате от меньшей к большей\n" +
                            "2 - по заработной плате от большей к меньшей\n" +
                            "3 - по возрасту\n" +
                            "0 - выход\n" +
                            "Введите цифру, соответствующую нужному критерию: ");
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    Arrays.sort(employees, new SalaryComparatorLM());
                    System.out.printf("\n*** Отсортированный  массив сотрудников по заработной плате от меньшей к большей ***\n\n");
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    System.out.println();
                    break;
                case "2":
                    Arrays.sort(employees, new SalaryComparatorML());
                    System.out.printf("\n*** Отсортированный массив сотрудников по заработной плате от большей к меньшей ***\n\n");
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    System.out.println();
                    break;
                case "3":
                    Arrays.sort(employees, new AgeComparator());
                    System.out.printf("\n*** Отсортированный по возрасту массив сотрудников ***\n\n");
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    System.out.println();
                    break;
                case "0":
                    filter = false;
                    break;
                default:
                    System.out.println("Введена неправильная операция!");
                    System.out.println();
                    break;
            }
        }
        sc.close();
    }

    static class SalaryComparatorML implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.calculateSalary(), o1.calculateSalary());
        }
    }

    static class SalaryComparatorLM implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o1.calculateSalary(), o2.calculateSalary());
        }
    }

    static class AgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }
}


