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

