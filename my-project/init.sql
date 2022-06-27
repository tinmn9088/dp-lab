DROP DATABASE IF EXISTS `teachers`;
CREATE DATABASE `teachers` DEFAULT CHARACTER SET utf8;
USE `teachers`;

CREATE TABLE `users` (
    `id`          BIGINT         NOT NULL  AUTO_INCREMENT,
    `login`       NVARCHAR(255),
    `password`    NVARCHAR(255),
    `roles`       NVARCHAR(255),
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `teachers` (
    `id`          BIGINT         NOT NULL  AUTO_INCREMENT,
    `fname`       NVARCHAR(255),
    `lname`       NVARCHAR(255),
    `patronymic`  NVARCHAR(255),
    `degree`      NVARCHAR(255),
    `place`       NVARCHAR(255),
    `gender`      NVARCHAR(255),
    `birthdate`   DATE,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `courses` (
    `id`                  BIGINT       NOT NULL  AUTO_INCREMENT,
    `teacher_id`          BIGINT,
    `title`               NVARCHAR(255),
    `speciality`          NVARCHAR(255),
    `semester`            TINYINT,
    `number_of_students`  SMALLINT,
    `hours_of_lectures`   INT,
    `hours_of_practice`   INT,
    `hours_of_lab`        INT,
    `exam`                BOOLEAN,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

ALTER TABLE `courses` ADD CONSTRAINT `fk_courses_teacher_id_teachers_id`
    FOREIGN KEY (`teacher_id`) REFERENCES `teachers`(`id`);
    