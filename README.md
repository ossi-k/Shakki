Projektissa on tarkoitus toteuttaa ohjelma, jolla voi pelata shakkia.
Ohjelmaan ei ole tarkoitus toteuttaa tietokonevastustajaa, vaan tavoite on mahdollistaa ainoastaan shakin pelaaminen supistetuilla säännöillä.

Säännöistä
    - Shakki- ja shakkimattitoiminnallisuuksia ei pyritä toteuttamaan ensisijaisesti
        - Peli päättyy joko kuninkaan syömiseen tai materiaaliedun omaavan pelaajan voittoon, kun musta on tehnyt 25. siirtonsa
    - Myöskään nk. ikuista shakkia tai pattia ei lähdetä toteuttamaan
    - Nappuloiden siirrot pyritään toteuttamaan sääntöjen mukaisesti
        - nk. en passant-siirto ja linnoittautuminen eivät kuitenkaan ole ensisijaisia tavoitteita
    - Puuttuvat shakin ominaisuudet jätetään pohdintaan mikäli aika sallii niiden pohdinnan ja osaaminen riittää toteutukseen. Toiminnallisuuksia voi myös täydentää myöhemmin harrastuksen vuoksi :)

1. Iteraation palautuksen toiminnallisuuksia
    - Nappuloita voi siirrellä tekstikäyttöliittymällä
        - Siirrosta tarkistetaan, onko se sääntöjen mukainen ja onko tiellä muita nappuloita
    - Toisten nappuloiden syöminen on toteuttamatta
    - Sotilasta ei voi liikuttaa kahta ruutua ensimmäisellä siirrolla
    - Käyttöliittymästä on olemassa suppea tekstiversio
    - Yksikkötestejä on aloitettu, tosin niitä on vasta yhdelle metodille

2. Iteraatioon on tarkoitus pyrkiä toteuttamaan
    - Yksikkötestejä on tarkoitus kirjoittaa lisää
    - Graafisen käyttöliittymän jonkinlainen aloittelu lienee hyvä tehdä aikaisessa vaiheessa
    - Nappuloita on mahdollista syödä ja mahdollisesti muita sääntötäydennyksiä (esim. sotilaan liikuminen kaksi ruutua ensimmäisellä siirrolla)