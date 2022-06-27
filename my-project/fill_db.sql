USE `teachers`;
START TRANSACTION;

INSERT INTO `users`
(`id`, `login`, `password`, `roles`)
VALUES
(1, N'admin', N'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', N'admin'), -- password: admin
(2, N'bob', N'81b637d8fcd2c6da6359e6963113a1170de795e4b725b84d1e0b4cfd9ec58ce9', N'user'); -- password: bob

INSERT INTO `teachers`
(`id`, `fname`, `lname`, `patronymic`, `degree`, `place`, `gender`, `birthdate`)
VALUES
(1, N'Алексей', N'Смирнов', N'Александрович', N'магистр', N'преподаватель', N'м', '1977-7-04');

INSERT INTO `courses`
(`id`, `teacher_id`, `title`, `speciality`, `semester`, `number_of_students`, `hours_of_lectures`, `hours_of_practice`, `hours_of_lab`, `exam`)
VALUES
(1, 1, N'Тестовый курс', N'Спец', 4, 12, 64, 60, 56, true);

COMMIT;