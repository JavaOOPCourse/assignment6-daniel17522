import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("S001", new Student("danon", 3.8, 20));
        students.put("S002", new Student("tema", 3.5, 22));
        students.put("S003", new Student("akbar", 3.5, 21));
        students.put("S004", new Student("serega", 3.9, 23));
        students.put("S005", new Student("petya", 3.2, 19));

        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("All Students");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println(students.get("S002"));

        // TODO: Удали одного студента по ID
        students.remove("S005");

        // TODO: Обнови GPA у одного студента
        students.get("S001").setGpa(4.0);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> studentList = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(studentList);
        for (Student s : studentList) {
            System.out.println(s);
        }

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        studentList.sort(Comparator.comparing(Student::getName));
        for (Student s : studentList) {
            System.out.println(s);
        }

        // ====================== TASK 2 ======================
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        ArrayList<Student> top3 = new ArrayList<>(students.values());
        top3.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        for (int i = 0; i < Math.min(3, top3.size()); i++) {
            System.out.println((i + 1) + " " + top3.get(i));
        }

        // ====================== TASK 3 ======================
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<Student>> gpaGroups = new HashMap<>();
        for (Student s : students.values()) {
            gpaGroups.computeIfAbsent(s.getGpa(), k -> new ArrayList<>()).add(s);
        }
        for (Map.Entry<Double, List<Student>> entry : gpaGroups.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + " " + entry.getValue());
            }
        }

        // ====================== TASK 4 ======================
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course math = new Course("Math");
        Course science = new Course("Science");
        Course history = new Course("History");

        courseMap.put(math, new ArrayList<>(List.of(
                students.get("S001"), students.get("S002"))));
        courseMap.put(science, new ArrayList<>(List.of(
                students.get("S003"), students.get("S004"))));
        courseMap.put(history, new ArrayList<>(List.of(
                students.get("S001"), students.get("S004"))));

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // ====================== TASK 5 ======================
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и
        // отсортируй
        ArrayList<Student> task5List = new ArrayList<>(students.values());
        task5List.sort(Comparator.comparingDouble(Student::getGpa).reversed()
                .thenComparing(Student::getName));
        for (Student s : task5List) {
            System.out.println(s);
        }
    }
}
