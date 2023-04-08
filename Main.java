package practiceMavenSkillbox;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.*;

public class Main {
    private static final String staffFile = "data/staff.txt";
    private static final String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();

        staff.forEach(out::println);
        staff.stream().min(Comparator.comparing((Employee::getSalary)).reversed()).ifPresent(out::println);

        staff.stream().map(Employee::getSalary).filter(s -> s>=100000).reduce((s1,s2)->s1+s2).ifPresent(out::println);

        staff.stream().
                sorted(Comparator.comparing(Employee::getSalary)).
                forEach(out::println);

        Optional<Employee> optionalEmployee= staff.stream().max(Comparator.comparing(Employee::getSalary));
        out.println(optionalEmployee);

        staff.stream().max
        (Comparator.comparing(Employee::getSalary)).
        ifPresent(out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines) {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}