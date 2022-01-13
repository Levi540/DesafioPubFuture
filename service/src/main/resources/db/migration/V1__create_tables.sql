CREATE TABLE `income` (
  `id`                    BIGINT      NOT NULL AUTO_INCREMENT,
  `description`           VARCHAR(45) NOT NULL,
  `receipt_date`          DATE        NOT NULL,
  `expected_receipt_date` DATE        NOT NULL,
  `id_account`            BIGINT      NOT NULL,
  `type_income`           VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `expense` (
  `id`              BIGINT        NOT NULL AUTO_INCREMENT,
  `value_`          DECIMAL(10,2) NOT NULL,
  `payday`          DATE          NOT NULL,
  `expected_payday` DATE          NOT NULL,
  `type_expense`    VARCHAR(30)   NOT NULL,
  `id_account`      BIGINT        NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `account` (
    `id`                    BIGINT        NOT NULL AUTO_INCREMENT,
    `balance`               DECIMAL(10,2) NOT NULL,
    `type_account`          VARCHAR(45)   NOT NULL,
    `financial_institution` VARCHAR(65)   NOT NULL,
    PRIMARY KEY (`id`)
);