-- 다 지우고~
DELETE FROM `study`;
DELETE FROM `account`;
DELETE FROM `car`;
DELETE FROM `comment`;
DELETE FROM `post`;
DELETE FROM `director`;
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
    (3, 'Apple'),
    (4, 'Apple');
    
INSERT INTO `comment` (`id`, `title`, `post_id`) VALUES
    (1, 'Excel', 1),
    (2, 'Word', 1),
    (3, 'PowerPoint', 1),
    (4, 'Gmail', 2),
    (5, 'Photo', 2),
    (6, 'Driver', 2),
    (7, 'KeyNote', 3),
    (8, 'AppStore', 3);
    
    
INSERT INTO `director` (`id`, `name`, `birth_date`, `created`) VALUES    
    (1, '봉준호', '1969-09-14', NOW()),    
    (2, '박찬욱', '1963-08-23', NOW()),    
    (3, '장준환', '1970-01-18', NOW()),    
    (4, '연상호', '1978-03-01', NOW()),    
    (5, '최동훈', '1971-02-24', NOW()),    
    (6, '나홍진', '1974-03-02', NOW());   
    
INSERT INTO `film` (`id`, `title`, `director_id`, `language`, `time`, `released`, `created`) VALUES 
    (1, '기생충', '1', '한국어', '132', '2019-10-01', NOW()),    
    (2, '살인의추억', '1', '한국어', '120', '2017-02-01', NOW()),    
    (3, '괴물', '1', '한국어', '120', '2006-07-27', NOW()),    
    (4, '올드보이', '2', '한국어', '110', '2015-02-13', NOW()),    
    (5, '아가씨', '2', '한국어', '144', '2016-05-14', NOW()),    
    (6, '1987', '3', '한국어', '140', '2017-12-27', NOW()),    
    (7, '부산행', '4', '한국어', '100', '2016-07-01', NOW()), 
    (8, '도둑들', '5', '한국어', '139', '2012-07-25', NOW()), 
    (9, '암살', '5', '한국어', '139', '2015-07-22', NOW()), 
    (10, '추격자', '6', '한국어', '123', '2008-02-14', NOW()),
    (11, '곡성', '6', '한국어', '156', '2016-05-12', NOW()); 
