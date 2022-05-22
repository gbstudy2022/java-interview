package hw5;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {

    public void addStudent(String name, Integer mark) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student student = new Student();
            student.setName(name);
            student.setMark(mark);
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public List<Student> getStudents() {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s", Student.class)
                    .getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    public Student getStudentById(Long id) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Student students = session.createQuery("select s from Student s where s.id = :id", Student.class)
                    .setParameter("id", id)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElseThrow(()->new RuntimeException("Не найден студент с id = "+id));
            session.getTransaction().commit();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteStudent(Student student) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public void updateStudent(Student student) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }
}
