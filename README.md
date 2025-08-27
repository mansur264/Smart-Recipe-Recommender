Software Requirement Specification (SRS)
Project Title: Smart Recipe Recommender
Prepared By: [Mansur Ansari]
________________________________________
1. Introduction
1.1 Purpose
The purpose of this project is to create a Smart Recipe Recommender System that suggests recipes based on the ingredients a user already has. Users can register, log in, enter ingredients, and receive recipe suggestions. They can also save recipes as favorites for quick access.
1.2 Scope
The system will:
•	Provide user authentication (login/signup).
•	Accept ingredient input from the user.
•	Suggest recipes that can be prepared using the entered ingredients.
•	Display recipe details (name, category, instructions).
•	Allow users to save/view favorite recipes.
•	(Optional) Provide an Admin module to manage recipes.
The application will be developed in Java + JDBC + MySQL and can be extended to GUI/web-based versions.
________________________________________
2. Overall Description
2.1 Product Perspective
This system is a standalone application with a MySQL backend. It is intended for students, homemakers, and cooking enthusiasts who want easy recipe suggestions.
2.2 User Classes
•	End User: Register, log in, search recipes, save favorites.
•	Admin (optional): Add/update/delete recipes.
2.3 Operating Environment
•	Programming Language: Java (JDBC)
•	Database: MySQL
•	Tools: MySQL 
2.4 Constraints
•	Requires MySQL connection.
•	Users must input ingredients correctly.
2.5 Assumptions
•	Recipes are pre-stored in the database.
•	Users know how to operate console/GUI.
________________________________________
3. Functional Requirements
1.	User Authentication
o	Register & login functionality.
o	Passwords stored securely.
2.	Ingredient Input
o	User enters a list of available ingredients.
3.	Recipe Search
o	System searches for recipes matching the ingredients.
4.	Recipe Display
o	Show recipe name, category, and preparation steps.
5.	Favorites Management
o	Save recipe to favorites.
o	View saved favorites.
6.	Admin Module (optional)
o	Add/update/delete recipes and ingredients.
________________________________________
4. Non-Functional Requirements
•	Performance: Recipe suggestions within 2–3 seconds.
•	Security: No plain-text passwords.
•	Usability: Easy to use and navigate.
•	Scalability: Can extend to GUI/web/mobile.
________________________________________
5. Database Design
Tables:
•	Users(user_id, username, password)
•	Recipes(recipe_id, name, category, instructions)
•	Ingredients(ingredient_id, recipe_id, ingredient_name)
•	Favorites(fav_id, user_id, recipe_id)
________________________________________
6. Use Case Diagram (Text Description)
•	Actor: User
o	Login/Signup
o	Enter ingredients
o	Search recipes
o	View recipe details
o	Save/View favorites
•	Actor: Admin (optional)
o	Manage recipes
________________________________________
7. Future Enhancements
•	AI-based recommendations for missing ingredients.
•	Nutrition calculator for each recipe.
•	Voice input for ingredients.
•	GUI & Mobile app version.

