CREATE TABLE `project`.`plan` (
  `PjName` VARCHAR(30) NOT NULL,
  `StartDate` DATE NULL,
  `EndDate` DATE NULL,
  `state` VARCHAR(30) NULL,
  PRIMARY KEY (`PjName`))
COMMENT = '프로젝트 일정';

USE project;
INSERT INTO plan (PjName, StartDate, EndDate, state) VALUES ('웹사이트개발', '2024-03-01', '2024-12-31', '진행중');
INSERT INTO plan (PjName, StartDate, EndDate, state) VALUES ('모바일 앱 개발', '2024-02-01', '2024-08-31', '계획'); 
INSERT INTO plan (PjName, StartDate, EndDate, state) VALUES ('데이터 분석', '2024-03-01', '2024-05-31','완료');

UPDATE plan SET state = '완료' WHERE state = '계획';plan
select*from plan;




