public class Worker extends Employee{
    public Worker(String name, String surName, String occupation, int age,double salary) {
        super(name, surName, occupation, age,salary);
    }
    
    public double calculateSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Род занятия - %s; Возраст, лет - %d; Среднемесячная заработная плата (фиксированный месячный оклад): %.2f (руб.)", name, surName, occupation, age, salary);
    }
}