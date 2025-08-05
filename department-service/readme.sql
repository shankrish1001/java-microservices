CREATE TABLE `department` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  `dept_desc` varchar(255) DEFAULT NULL,
  `dept_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE (dept_name),
  UNIQUE (dept_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
