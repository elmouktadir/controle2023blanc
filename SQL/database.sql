CREATE DATABASE dbCtrlblanc;

USE dbCtrlblanc;

CREATE TABLE produit(
    reference VARCHAR(30) PRIMARY KEY,
    prix DECIMAL(100,2) NOT NULL,
    designation VARCHAR(200)
);