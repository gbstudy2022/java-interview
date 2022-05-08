package hw1;

import lombok.Setter;

@Setter
public class Person {
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .firstName("Иванов")
                .lastName("Иван")
                .middleName("Иванович")
                .country("Россия")
                .address("ул. Московская")
                .phone("+12345")
                .age(60)
                .gender("М")
                .build();
        System.out.println(person.toString());
    }
}
