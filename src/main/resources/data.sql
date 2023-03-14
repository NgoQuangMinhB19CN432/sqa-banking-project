/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Minh ngo
 * Created: Mar 11, 2023
 */
CREATE TABLE BankAccount (
  bankAccountNumber VARCHAR(20) NOT NULL PRIMARY KEY,
  money INT NOT NULL,
  creditScore FLOAT NOT NULL
);

CREATE TABLE Customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fullname VARCHAR(20) NOT NULL,
  age INT NOT NULL,
  job VARCHAR(20) NOT NULL,
  address VARCHAR(250) NOT NULL,
  phoneNumber VARCHAR(20) NOT NULL,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  bankAccountNumber VARCHAR(20) NOT NULL, FOREIGN KEY(bankAccountNumber) REFERENCES BankAccount(bankAccountNumber)
);

CREATE TABLE Saving (
  savingId INT AUTO_INCREMENT PRIMARY KEY,
  toDate VARCHAR(20) NOT NULL,
  originalMoney INT NOT NULL,
  interestRate FLOAT NOT NULL,
  kindOfProfit VARCHAR(20) NOT NULL,
  bankAccountNumber VARCHAR(20), FOREIGN KEY(bankAccountNumber) REFERENCES BankAccount(bankAccountNumber)
);

CREATE TABLE Credit (
  creditId INT AUTO_INCREMENT PRIMARY KEY,
  money INT NOT NULL,
  interestRate FLOAT NOT NULL,
  borrowDay VARCHAR(20) NOT NULL,
  payDay VARCHAR(20) NOT NULL,
  mortgage VARCHAR(20) NOT NULL,
  bankAccountNumber VARCHAR(20), FOREIGN KEY(bankAccountNumber) REFERENCES BankAccount(bankAccountNumber)
);
INSERT INTO BankAccount (bankAccountNumber, money, creditScore) VALUES
  ('12345678', 5000000, 8.8),
  ('23456789', 100000, 4.5);

INSERT INTO Customer (fullname, age, job, address, phoneNumber, username, password, bankAccountNumber) VALUES
  ('NgoQuangMinh', 20, 'student','NamDinh', '0817791620', 'minhngo', 'alune', '12345678'),
  ('LeThiLinh', 23, 'master', 'NinhBinh', '0123456789', 'linhle', '1106', '23456789');

INSERT INTO Saving (toDate, originalMoney, interestRate, kindOfProfit, bankAccountNumber) VALUES
  ('1/12/2023', 5000000, 0.8, 'laikep', '12345678'),
  ('1/12/2023', 10000000, 0.8, 'laikep', '12345678'),
  ('1/12/2023', 500000, 0.8, 'laikep', '12345678'),
  ('1/12/2023', 5000000, 0.4, 'laikep', '23456789'),
  ('1/12/2023', 5000000, 0.4, 'laikep', '23456789'),
  ('1/12/2023', 5000000, 0.4, 'laikep', '23456789');

INSERT INTO Credit (money, interestRate, borrowDay, payDay, mortgage, bankAccountNumber) VALUES
  (5000000, 0.8, '1/3/2023', '1/12/2023', 'nharieng','12345678'),
  (5000000, 0.8, '1/3/2023', '1/12/2023', 'nharieng','12345678'),
  (5000000, 0.8, '1/3/2023', '1/12/2023', 'nharieng','12345678');