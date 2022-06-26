USE `teachers`;
START TRANSACTION;

INSERT INTO `teachers`
(`id`, `fname`, `lname`, `patronymic`, `degree`, `place`, `gender`, `birthdate`)
VALUES
(1, 'Алексей', 'Смирнов', 'Александрович', 'магистр', 'преподаватель', 'м', '1977-7-04');

INSERT INTO `courses`
(`id`, `teacher_id`, `title`, `speciality`, `semester`, `number_of_students`, `hours_of_lectures`, `hours_of_practice`, `hours_of_lab`, `exam`)
VALUES
(1, 1, 'Тестовый курс', 'Спец', 4, 12, 64, 60, 56, TRUE);

COMMIT;