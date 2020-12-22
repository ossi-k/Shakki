Projektissa on tarkoitus toteuttaa ohjelma, jolla voi pelata shakkia.
Ohjelmaan ei ole tarkoitus toteuttaa tietokonevastustajaa, vaan tavoite on mahdollistaa ainoastaan shakin pelaaminen supistetuilla säännöillä.

Ohjelma on koodattu javan versiolla 1.8 (java 8), joten se ei välttämättä toimi uudemmilla versioilla.

4. iteraation palautuksesta
	- Valitettavasti tilanne on edelleen sama kuin 3. iteraation palautuksessa, eli ohjelma ei ole edennyt
		- Aikani on ollut kortilla viimeisen kuukauden ajan, mutta lopulliseen palautukseen minun pitäisi ehtiä toteuttaa hieman lisää toiminnallisuuksia

3. Iteraation palautuksesta
	- valitettavasti en ole ehtinyt edistämänään ohjelmaa edellisestä palautuksesta, joten toiminnallisuudet
	ovat samat kuin 2. iteraatiossa
	- ohjelmaa varten on luotu jar-tiedosto target-kansioon

Säännöistä
    - Shakki- ja shakkimattitoiminnallisuuksia ei pyritä toteuttamaan ensisijaisesti
        - Peli päättyy joko kuninkaan syömiseen tai materiaaliedun omaavan pelaajan voittoon, kun musta on tehnyt 25. siirtonsa (yhteensä siis 50 siirtoa, 25 kummallekin)
			- 50. siirron jälkeen lasketaan materiaalietu ja voittaja on se, jolla on enemmän materiaalia pöydällä
    - Myöskään nk. ikuista shakkia tai pattia ei lähdetä toteuttamaan
    - Nappuloiden siirrot pyritään toteuttamaan sääntöjen mukaisesti
        - nk. en passant-siirto ja linnoittautuminen eivät kuitenkaan ole ensisijaisia tavoitteita
    - Puuttuvat shakin ominaisuudet jätetään pohdintaan mikäli aika sallii niiden pohdinnan ja osaaminen riittää toteutukseen. Toiminnallisuuksia voi myös täydentää myöhemmin harrastuksen vuoksi :)

2. Iteraation palautuksen toiminnallisuuksia
	- nappuloiden liikkumissäännöt on pääsääntöisesti toteutettu
		- puuttuvia: 
			- sotilaan liikkuminen kaksi ruutua ensimmäisellä siirrolla
			- sotilaan mahdollisuus syödä vastapuolen nappuloita
			- kuninkaan linnoittautuminen (tämän toteutusta voisi yrittää 3. iteraatioon, jos osaaminen riittää)
			- nk. en passant-syöminen
	- tarkistus, onko siirto blokattu (onko alkuruudun ja halutun loppuruudun välissä jokin nappula)
	- pelin lopetus 50 siirron jälkeen tai jommankumman kuninkaan syömiseen
		- shakkia tai shakkimattia ei ole toteutettu, eikä näitä määrittelyssä lähdetykään ensisijaisesti tavoittelemana, vaan tavoitteena on yksinkertaisemman ohjelman toteutus
			- toteutusta voisi miettiä ja yrittää lopulliseen versioon, mikäli osaaminen riittää
	- graafista käyttöliittymää on aloitettu
		- nappuloita voi siirrellä ja peliä pelata
		- puuttuu esim. mahdollisuus sulkea peli ja muita tekstiruutuja, joille printataan infoa pelistä (kenen vuoro, mones siirto jne)
	- lisätty yksikkötestejä
	- ohjelmassa pyörii edelleen mukana tekstikäyttöliittymän luokka, jolla ei ole tällä hetkellä enää toteutuksessa virkaa
		- mukana testausta varten
		- tämä poistetaan viimeistään lopullisessa versiossa
	- ohjelma tallentaa pelin alkaessa pelin numeron tietokantaan ja pelin päätyttyä tallentaa pelin voittajan
  
