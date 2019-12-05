# Book-Management-Website
A basic web-app about book management using Java EE and MS SQL server

To start, you have to run some .sql files, on folder sql, first "create database.sql" then "data.sql" to have sample data I inserted
This project written on netbean, so you can open by netbean 8.x and run after run .sql files
In sql folder also have query.sql, it contains some query I used in project to test

This web-app uses MVC model:
*View is .jsp files include HTML, javascript, link to w3 boostrap and jquery and have only view to user
*Controller in folder controller, is java servlet files take event from View and send result to View. Every link in web-app must be Controller file
*Model contain beans and daos is Java class, bean contain Class of Objects use in project. DAO is Database sql Access Object, to select and insert data from and to Database 
