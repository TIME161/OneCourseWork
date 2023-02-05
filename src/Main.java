public class Main {
    private static final Employee[] employees = new Employee[10];

    private static void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static void sumSalary() {
        double sum = 0.0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        System.out.println("Сумма окладов = " + sum);
    }

    private static void minSalaryPrint() {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployer = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                minSalaryEmployer = employee;
            }
        }
        System.out.println("Сотрудник с наименьшим окладом: " + minSalaryEmployer);
    }

    private static void maxSalaryPrint() {
        double max = Double.MIN_VALUE;
        Employee maxSalaryEmployer = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                maxSalaryEmployer = employee;
            }
        }
        System.out.println("Сотрудник с набольшим окладом: " + maxSalaryEmployer);
    }

    private static void printAverageSalary() {
        double amount = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                amount += employee.getSalary();
                count++;
            }
        }
        System.out.println("Средний оклад: " + amount/count);
    }

    private static void printNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("ФИО: " + employee.getFullName());
            }
        }
    }

    public static void bookOfEmployes() {
        employees[0] = new Employee("Шашков Арнольд Евсеевич", 1, 94512);
        employees[1] = new Employee("Власов Тарас Вениаминович", 2, 22432);
        employees[2] = new Employee("Матвеев Егор Улебович", 3, 27165);
        employees[3] = new Employee("Гордеев Родион Александрович", 4, 70342);
        employees[4] = new Employee("Николаев Юстин Германнович", 5, 61339);
        employees[5] = new Employee("Моисеева Ева Ростиславовна", 1, 25723);
        employees[6] = new Employee("Кузнецова Ульяна Дамировна", 3, 33706);
        employees[7] = new Employee("Логинова Харитина Геннадьевна", 4, 41129);
        employees[8] = new Employee("Лукина Ляля Аркадьевна", 2, 40886);
        employees[9] = new Employee("Боброва Астра Леонидовна", 5, 11446);
    }

    public static void main(String[] args) {
        int departmentCheck = 2;
        int indexationPercent = 10;
        int numberToCompare = 15000;

        bookOfEmployes();
        printEmployees();
        sumSalary();
        minSalaryPrint();
        maxSalaryPrint();
        printAverageSalary();
        printNames();

        printDepEmployees(departmentCheck);
        minSalaryDepPrint(departmentCheck);
        maxSalaryDepPrint(departmentCheck);
        sumDepSalary(departmentCheck);
        printDepAverageSalary(departmentCheck);

        salaryDepIndexation(indexationPercent, departmentCheck);
        salaryIndexation(indexationPercent);

        findSalaryLess(numberToCompare);
        findSalaryGreat(numberToCompare);
    }

  //////// ПОВЫШЕННАЯ СЛОЖНОСТЬ //////////
    private static void salaryIndexation(int percentToUp) {
        System.out.println("Сотрудники с проиндексированной зарплатой: ");
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + ((employee.getSalary()/ 100) * percentToUp));
                System.out.println(employee);
            }
        }
    }

    private static void  salaryDepIndexation(int percentToUp, int dep) {
        System.out.println("Сотрудники " + dep + " отдела с проиндексированной зарплатой: ");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dep) {
                employee.setSalary(employee.getSalary() + ((employee.getSalary()/ 100) * percentToUp));
                System.out.println("ID " + employee.getId()
                        + " | ФИО: " + employee.getFullName()
                        + " | Оклад: " + employee.getSalary());
            }
        }
    }

    private static void minSalaryDepPrint(int dep) {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployer = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < min && employee.getDepartment() == dep) {
                min = employee.getSalary();
                minSalaryEmployer = employee;
            }
        }
        System.out.println("Сотрудник с наименьшим окладом в отделе "
                + dep + " : "
                + minSalaryEmployer.getFullName() + " | Оклад: " + minSalaryEmployer.getSalary());
    }
    private static void maxSalaryDepPrint(int dep) {
        double max = Double.MIN_VALUE;
        Employee maxSalaryEmployer = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > max && employee.getDepartment() == dep) {
                max = employee.getSalary();
                maxSalaryEmployer = employee;
            }
        }
        System.out.println("Сотрудник с набольшим окладом в отделе "
                + dep + " : "
                + maxSalaryEmployer.getFullName() + " | Оклад: " + maxSalaryEmployer.getSalary());
    }

    private static void printDepAverageSalary(int dep) {
        double amount = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dep) {
                amount += employee.getSalary();
                count++;
            }
        }
        System.out.println("Средний оклад cотрудников " + dep + " отдела: " + amount/count);
    }

    private static void sumDepSalary(int dep) {
        double sum = 0.0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dep) {
                sum += employee.getSalary();
            }
        }
        System.out.println("Сумма окладов отдела " + dep +" = " + sum);
    }

    private static void printDepEmployees(int dep) {
        System.out.println("Сотрудники отдела " + dep + ": ");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dep) {
                System.out.println("ID " + employee.getId()
                        + " | ФИО: " + employee.getFullName()
                        + " | Оклад: " + employee.getSalary());
            }
        }
    }

    private static void findSalaryLess(int summ) {
        System.out.println("Сотрудники с окладом ниже " + summ + " : ");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < summ) {
                System.out.println(employee);
            }
        }
    }

    private static void findSalaryGreat(int summ) {
        System.out.println("Сотрудники с окладом выше " + summ + " : ");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= summ) {
                System.out.println(employee);
            }
        }
    }
}