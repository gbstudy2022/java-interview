CREATE TABLE students (
   id INTEGER PRIMARY KEY AUTOINCREMENT,
   name TEXT NOT NULL,
   age INTEGER NOT NULL
);

insert into students (name, age)
values
    ('Иванов Иван', 18),
    ('Иванов Егор', 19),
    ('Иванов Сергей', 20),
    ('Сергеев Иван', 21);