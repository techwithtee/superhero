-- Drop the database if it exists
DROP DATABASE IF EXISTS superhero_sightings;

-- Create the database
CREATE DATABASE superhero_sightings;

-- Use the database
USE superhero_sightings;

-- Create the hero table
CREATE TABLE hero (
    hero_id INT AUTO_INCREMENT PRIMARY KEY,
    hero_name VARCHAR(255) NOT NULL,
    hero_desc TEXT,
    superpower VARCHAR(255)    
);

-- Create the location table
CREATE TABLE location (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    location_name VARCHAR(255) NOT NULL,
    location_desc TEXT,
    location_add VARCHAR(255),
    location_lat DECIMAL(10, 6),
    location_long DECIMAL(10, 6)
);

-- Create the organisation table
CREATE TABLE organisation (
    org_id INT AUTO_INCREMENT PRIMARY KEY,
    org_name VARCHAR(255) NOT NULL,
    org_desc TEXT,
    org_contact VARCHAR(255)
);

-- Create the hero-organisation junction table
CREATE TABLE hero_organisation (
    hero_org_id INT AUTO_INCREMENT PRIMARY KEY,
    hero_id INT,
    org_id INT,
    FOREIGN KEY (hero_id) REFERENCES hero(hero_id),
    FOREIGN KEY (org_id) REFERENCES organisation(org_id)
);

-- Create the sighting table
CREATE TABLE sighting (
    sight_id INT AUTO_INCREMENT PRIMARY KEY,
    sight_title VARCHAR(255) NOT NULL,
    sighting_date DATE,
    location_id INT,
    FOREIGN KEY (location_id) REFERENCES location(location_id)
);

-- Create the hero-sighting junction table
CREATE TABLE hero_sighting (
    hero_sight_id INT AUTO_INCREMENT PRIMARY KEY,
    hero_id INT,
    sight_id INT,
    FOREIGN KEY (hero_id) REFERENCES hero(hero_id),
    FOREIGN KEY (sight_id) REFERENCES sighting(sight_id)
);

