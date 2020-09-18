CREATE TABLE `time_request` (
  `time_request_id` int NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `reason` varchar(45) NOT NULL,
  `date_requested` date NOT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`time_request_id`),
  KEY `employee_id_idx` (`employee_id`)
);
