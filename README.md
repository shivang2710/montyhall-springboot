# montyhall-springboot
This project simulates Monty Hall game.

# Problem Overview
The Monty Hall problem is a well-known counter-intuitive statistics problem that at scale, consistently provides the expected results as defined by the problem.  The problem is as follows
1.	Three doors are presented to a gameshow contestant, but the contestant does not know what is behind each door, and cannot see through them
2.	There is a goat behind each of two of the doors, and a car behind the third
3.	The goal is for the contestant to win the car by guessing the correct door behind which the car is located
4.	The contestant chooses one of the three doors, randomly
5.	Then one of the other doors, behind which is a goat, is opened to reveal the goat to the contestant
6.	The contestant can then choose to either switch their initial selection, or keep it
7.	If the contestant switches the door from the one that they originally picked to the other remaining door, then  they increase their odds of winning the car to 66.66666% (instead of the intuitive 50%).

# Usage

First, clone the project, navigate to the project root and use Maven to build:
mvn clean install

Then run the maven command to run spring boot app:
mvn spring-boot:run

The app accepts the following input:
a.	Number of iterations
b.	Whether or not to switch door selection
c.	Accepts the above input via a REST endpoint in the following path format:
/api/play/{iterations}/{switch}
where:
{iterations} is the number of iterations to run the simulation (integer)
{switch} is a boolean denoting whether to switch contestant’s initial door selection

use this curl command to run the app- "curl -X POST "Content-Type: application/json" localhost:8080/api/play/{iterations}/{switch}"

Currently it is displayed response in the json format. Need to enhance to display in the tabular format.


