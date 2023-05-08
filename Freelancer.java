public class Freelancer extends Employee{
    private int time;
    private double salaryTotal;

    public Freelancer(String name, String surName, String occupation, int age, int time, double salary) {
        super(name, surName, occupation, age, salary);
        this.time = time;
        salaryTotal = (salary/8) * time;
    }
    @Override
    public String toString() {
        return  String.format("Сотрудник: %s %s; Род занятия - %s; Возраст, лет - %d; Отработано часов: %d; Заработная плата за месяц: %.2f (руб.)", name, surName, occupation, age, time, salaryTotal);
    }
    @Override
    public double calculateSalary() {
        return salaryTotal;
    }
}
