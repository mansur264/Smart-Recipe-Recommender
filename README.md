**Smart Recipe Recommender System**

Project Overview

The Smart Recipe Recommender System is a Java-based project designed to help students, hostel residents, and individuals living away from home cook meals with limited ingredients.
By entering the ingredients they have, users can quickly find recipes they can prepare, along with detailed instructions.

This system uses Java for the frontend and backend, and MySQL as the database.
  
Features 
   
User Module

User Signup & Login 
Search recipes by ingredients
View detailed recipe instructions (ingredients, steps, cooking time)
Save recipes to favorites
Get personalized recipe recommendations

Admin Module

Add new recipes
Update existing recipes
Delete recipes
Manage users (optional feature)

Tech Stack  

Programming Language: Java
Frontend (UI): Java Swing
Backend Logic: Java (OOP concepts)
Database: MySQL
Database Connectivity: JDBC

How to Use

Start the application.
New users can sign up; existing users can log in.
Enter available ingredients (e.g., Rice, Egg).
View suggested recipes with preparation steps and cooking time.
Save favorite recipes for future use.
Admin users can add, update, or delete recipes.

OOP Concepts Used

Encapsulation: User, Recipe, and Admin classes with private fields and getters/setters.
Inheritance: Admin and User inherit common features from a base class (e.g., Person).
Polymorphism: Method overloading for searching recipes (by name or by ingredient).
Abstraction: Database operations handled through a JDBC abstraction layer.

