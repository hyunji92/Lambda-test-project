package org.guxd.lombok.main;

import org.guxd.lombok.vo.PersonVO;
import org.guxd.lombok.vo.StudentVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hyunji on 2016. 6. 15..
 */
public class LombokMain {
    public static void main(String args[]) {
        final List<StudentVO> students = new ArrayList<>();

        StudentVO student1 = makeStudent("mook",1);
        StudentVO student2 = makeStudent("je",2);
        StudentVO student3 = makeStudent("jel",3);
        StudentVO student4 = makeStudent("jell",4);
        StudentVO student5 = makeStudent("jelly",5);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

            students
                .stream()
                .forEach(s -> {
                    try {
                        System.out.println(s.getClassNumber());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        });

        
        students
                .parallelStream()
                .forEach(s -> {
                    try {
                        System.out.println(s.getClassNumber());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });


        // 리스트 중복제거
        // reduce
        List<PersonVO> filteredStudents = listFilter(students.stream());
    }


    public static List<PersonVO> listFilter(Stream<StudentVO> personVOStream) {
        return personVOStream
                .filter(p -> p.getAge() > 3)
                .filter(p -> p.getJob().length() > 3)
                .collect(Collectors.toList());
    }


    public static StudentVO makeStudent(String name, int classNumber) {
        StudentVO student = new StudentVO();
        student.setName(name);
        student.setAge(1);
        student.setJob("student");
        student.setDeleteYn(false);
        student.setClassNumber(classNumber);
        student.setGrade("junior");
        student.setMajor("CS");

        return student;
    }
}
