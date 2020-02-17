-- 다 지우고~
DELETE FROM `study`;
DELETE FROM `account`;
DELETE FROM `car`;
DELETE FROM `comment`;
DELETE FROM `post`;
DELETE FROM `film`;

INSERT INTO `account` (`id`, `username`, `password`, `age`, `city`, `state`, `street`, `zip_code`, `created`) VALUES
    (1, '홍길동', '1234', 20, 'Seoul', 'Yeongdeungpo-gu', 'Gamasan-ro', '54287', '2020-02-04 13:31:55.000000'),
    (2, '강감찬', '!@#$', 10, 'Seoul', 'Gangnam-gu', 'Teheran-ro', '27896', '2020-03-04 10:31:55.000000');

INSERT INTO `study` (`id`, `name`, `owner_id`) VALUES
    (1, '서양미술사', 1),
    (2, '양자역학', 1),
    (3, '알고리즘', 2),
    (4, '자료구조', 2),
    (5, '컴파일러', 2);

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
    
INSERT INTO `film` (`id`, `title`, `director`, `language`, `time`, `released`, `created`) VALUES 
    (1, '기생충', '봉준호', '한국어', '132', '2019-10-01', NOW()),    
    (2, '살인의추억', '봉준호', '한국어', '120', '2017-02-01', NOW()),    
    (3, '올드보이', '박찬욱', '한국어', '110', '2015-02-13', NOW()),    
    (4, '1987', '장준환', '한국어', '140', '2017-12-27', NOW()),    
    (5, '부산행', '연상호', '한국어', '100', '2016-07-01', NOW()), 
    (6, '도둑들', '최동훈', '한국어', '139', '2012-07-25', NOW()), 
    (7, '추격자', '나홍진', '한국어', '123', '2008-02-14', NOW()); 
    