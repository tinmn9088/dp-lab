USE `teachers`;
START TRANSACTION;

INSERT INTO `teachers`
(`id`, `fname`, `lname`, `patronymic`, `degree`, `place`, `gender`, `birthdate`)
VALUES
(1, N'Алексей', N'Смирнов', N'Александрович', N'магистр', N'преподаватель', N'м', '1977-7-04');

INSERT INTO `courses`
(`id`, `teacher_id`, `title`, `speciality`, `semester`, `number_of_students`, `hours_of_lectures`, `hours_of_practice`, `hours_of_lab`, `exam`)
VALUES
(1, 1, N'Тестовый курс', N'Спец', 4, 12, 64, 60, 56, true);

COMMIT;