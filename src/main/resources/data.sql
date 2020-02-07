DELETE FROM `study`;
DELETE FROM `account`;
DELETE FROM `car`;
DELETE FROM `comment`;
DELETE FROM `post`;

INSERT INTO `account` (`id`, `username`, `password`, `age`, `city`, `state`, `street`, `zip_code`, `created`) VALUES
    (1, '홍길동', '1234', 10, 'Seoul', 'Yeongdeungpo-gu', 'Gamasan-ro', '54287', '2020-02-04 13:31:55.000000');

INSERT INTO `study` (`id`, `name`, `owner_id`) VALUES
    (1, '서양미술사', 1),
    (2, '양자역학', 1);

INSERT INTO `car` (`id`, `make`, `number_of_seats`, `type`) VALUES
    (1, 'BMW', 4, 'A'),
    (2, 'FORD', 2, 'A'),
    (3, 'HYUNDAI', 5, 'C');

INSERT INTO `post` (`id`, `title`) VALUES
    (1, 'Microsoft'),
    (2, 'Google'),
    (3, 'Apple');
    
INSERT INTO `comment` (`id`, `title`, `post_id`) VALUES
    (1, 'Excel', 1),
    (2, 'Word', 1),
    (3, 'PowerPoint', 1),
    (4, 'Gmail', 2),
    (5, 'Photo', 2),
    (6, 'Driver', 2),
    (7, 'KeyNote', 3),
    (8, 'AppStore', 3);
