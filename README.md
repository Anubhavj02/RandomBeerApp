# RandomBeerApp

A simple web app to show information of random Beer Sample Records from the Database. A user can perform basic CRUD operation to manage the Beer Records.

![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output1.png)

## Technical Stack
#### Backend
* Java 8
* Spring 4.3.0
* Hibernate 5.2
#### Frontend
* Angular 1.4.9
* Bootstrap 4
* jQuery 3.3.1
#### Database
* MySQL 5.7
#### Testing
* Junit 4
* Mockito 1.9.5
#### Misc
* Maven 3.5.3 (Build Automation Tool)
* Tomcat 7 Server

## Steps to Run:
#### Requirements(only these requirements need to be installed; rest dependencies will be installed through maven)
* Java 8
* Maven 3.5.3
* Tomcat 7
* MySQL 5.7

1. Install maven 3.5.3 and set MVN_HOME
2. Instal MySQL 5.7 and run the MySQL service on port 3306(Ensure the MySql service is running on the machine)

3. Creating Database, tables and some initial entries or run **RandomBeerApp/sql/createbeerdb.sql** <br/><br/>


Create a Database with name "BeerDB"
```sql
create database BeerDB;
```
Create Beer table
```sql
CREATE TABLE `Beer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `abv` float NOT NULL,
  `breweryLocation` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
```
Load some initial Entries
```sql
CREATE DATABASE BeerDB;


USE BeerDB;

CREATE TABLE `Beer` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `abv` FLOAT NOT NULL,
    `breweryLocation` VARCHAR(255) DEFAULT NULL,
    `description` VARCHAR(5000) DEFAULT NULL,
    `imageUrl` VARCHAR(255) DEFAULT NULL,
    `name` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `beer` 
            (`abv`, 
             `brewerylocation`, 
             `description`, 
             `imageurl`, 
             `name`) 
VALUES  (4.9,'KINNEGAR BREWING','The Craft beer industry in Ireland is booming and there are so many new beers arriving on the scene every week! For me to recommend an Irish beer you must try for 2015 I’m going straight into my personal favourite bank!','http://www.belgiansmaak.com/wp-content/gallery/irish-beers-2015/dynamic/Devils-Backbone.jpg-nggid041004-ngg0dyn-0x0x100-00f0w010c010r110f110r010t010.jpg','DEVIL’S BACKBONE'),
				(3.6,'TROUBLE BREWING','You like hops. Well done. You’ve earned your licence to drink craft beer. But if you’re serious about the little green fellas you don’t want any malt or yeast getting in the way. And this is where Graffiti steps in: all the fresh citrus burst of the New World varieties at just 3.6% ABV. You can look at it as a healthy alternative to the high alcohol heavy hitters of Irish craft beer, or you can take the lesson that an expert brewer knows how to make the best use of the ingredients to hand. Graffiti is a rare vision of how brilliant Irish beer can be.','http://www.belgiansmaak.com/wp-content/gallery/irish-beers-2015/dynamic/Graffiti_Tap.jpg-nggid041010-ngg0dyn-0x0x100-00f0w010c010r110f110r010t010.jpg','GRAFFITI'),
				(4.8,'RASCAL’S BREWING CO','The first time I tasted Rascal’s Ginger Porter was on a hot August day at The Big Grill festival; not necessarily when you want to get your hands on a dark beer but I fell in love with Emma Devlin and Cathal O’Donoghue’s take on tradition with the first sip.','http://www.belgiansmaak.com/wp-content/gallery/irish-beers-2015/dynamic/Ginger-Porter-Rascals.jpg-nggid041008-ngg0dyn-0x0x100-00f0w010c010r110f110r010t010.jpg','GINGER PORTER'),
				(6,'CARLOW BREWING COMPANY','O’Hara’s Leann Folláin is possibly the best example of an extra stout brewed in Ireland. The words themselves, ‘Leann Folláin’ are simply the Irish for ‘Wholesome Stout’. This 6% ABV beauty takes a typical dry Irish stout and bumps it up a notch. Expect masses of chocolate and a little milky coffee. The alcohol is well hidden but adds a warming effect towards the end. Whenever I’m asked what my favourite beer is, or the best beer in the world, I can’t answer but respond with Leann Folláin as being the beer I would happily drink for the rest of my life, if I had to pick just one.','http://www.belgiansmaak.com/wp-content/gallery/irish-beers-2015/dynamic/oharas-leann-follain.jpg-nggid041014-ngg0dyn-0x0x100-00f0w010c010r110f110r010t010.jpg','O’HARA’S LEANN FOLLÁIN'),
				(5.3,'KINNEGAR BREWING','I’ve trawled and traipsed my way through many of the beers in, I think, pretty much every Irish brewery over the last year and I could have picked about a dozen for this. The one I have gone for is a perennial favourite both in the bottle and on tap. When it was unavailable for a few months a while back I genuinely missed having it to hand. It’s the Scraggy Bay IPA. If I have a favourite type of beer it’s the IPA and Scraggy Bay is at the very, very top of the pile in Ireland when it comes to that.','http://www.belgiansmaak.com/wp-content/gallery/irish-beers-2015/dynamic/Scraggy-Bay.jpg-nggid041022-ngg0dyn-0x0x100-00f0w010c010r110f110r010t010.jpg','SCRAGGY BAY');

```
3. Install Tomcat 7
4. Clone the repository and change path to the cloned directory
  ```shell
  $ git clone https://github.com/Anubhavj02/RandomBeerApp.git
  $ cd RandomBeerApp
  ```
5. Do maven clean install; this will build the application and run all the test cases
  ```shell
  $ mvn clean install
  ```
6. There are two ways to run on server:
  * Using Maven tomcat plugin
  ```shell
  $ mvn tomcat7:run
  ```
  Access http://localhost:8080/RandomBeerApp
  * Using installed tomcat; after Maven Clean install, a WAR file is made in the target directory
  ```
  Copy the the WAR file "RandomBeerApp/target/RandomBeerApp.war" to "---Your_Tomcat_Directory---/webapps"
  and then; run the tomcat server.
  ```
  ```shell
  $ sh Your_Tomcat_Directory/bin/startup.sh
  ```
  Access http://localhost:8080/RandomBeerApp
  
 ## Output and Screen Shots:
 ### GUI Web
 1. Show Random Beer functionality
 ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output6.png)
 ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output5.gif)
 
 2. Manage Beer
 ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output2.png)
 
 3. Add Beer Record
 ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output3.png)
 
 4. Edit Beer Record
  ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output4.png)
  
  ### Postman Json
  ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output7.png)
  ![output](https://github.com/Anubhavj02/RandomBeerApp/blob/master/output/output8.png)
  
 
 



