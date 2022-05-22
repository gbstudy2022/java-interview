package hw5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("hw5");
        MainService mainService = ctx.getBean(MainService.class);
        // добавление
//        for (int i = 0; i < 200; i++) {
//            mainService.addStudent("Иванов"+i, 5);
//        }
//        for (int i = 0; i < 200; i++) {
//            mainService.addStudent("Иванюк"+i, 4);
//        }
//        for (int i = 0; i < 200; i++) {
//            mainService.addStudent("Петров"+i, 3);
//        }
//        for (int i = 0; i < 200; i++) {
//            mainService.addStudent("Петрюк"+i, 2);
//        }
//        for (int i = 0; i < 200; i++) {
//            mainService.addStudent("Сидоров"+i, 1);
//        }

        // выборки одной и всех записей
        //mainService.getStudents().forEach(System.out::println);
        System.out.println(mainService.getStudentById(10000L));
        System.out.println(mainService.getStudentById(199L));

        // изменение
        StudentDto studentDto = mainService.getStudentById(199L);
        studentDto.setMark(studentDto.getMark()+1);
        mainService.updateStudent(studentDto);
        System.out.println(mainService.getStudentById(199L));

        // удаление
        System.out.println(mainService.getStudentById(500L));
        mainService.deleteStudentById(500L);
        System.out.println(mainService.getStudentById(500L));
    }
}
