public abstract class Employee implements Comparable<Employee>{
    protected String name;
    protected String surName;
    protected String occupation;
    protected int age;
    protected double salary;
    
    public Employee(String name, String surName, String occupation, int age, double salary) {
        this.name = name;
        this.surName = surName;
        this.occupation = occupation;
        this.age = age;
        this.salary = salary;
    }
    public abstract double calculateSalary();

    public String toString(){
        return String.format("Сотрудник: %s %s; Род занятия - %s; Возраст, лет: - %d; Среднемесячная заработная плата: %.2f руб.", name, surName, occupation, age, salary);
    }
    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }
}