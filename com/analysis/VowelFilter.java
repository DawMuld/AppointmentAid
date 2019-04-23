/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import resources.raw.words.WordTokenizer;





/**
 *
 * @author daanm
 */
public class VowelFilter {

    public static ArrayList<String> detectVowels(String input) {
        ArrayList<String> vowelList = new ArrayList<>();
        ArrayList<String> holdList = new ArrayList<>();
        List<String> wordList = WordTokenizer.tokenizeList(input);
        for (int i = 0; i < wordList.size(); i++) {
        }
        return vowelList;
        //TODO finish method

    }

    public static final String[] VOWELS = new String[]{
        "bakken", "bakte", "bakten", "gebakken",
        "bederven", "bedierf", "bedierven", "bedorven",
        "bedriegen", "bedroog", "bedrogen", "bedrogen",
        "beginnen", "begon", "begonnen", "begonnen",
        "begrijpen", "begreep", "begrepen", "begrepen",
        "bevallen", "beviel", "bevielen", "bevallen",
        "bewegen", "bewoog", "bewogen", "bewogen",
        "bezoeken", "bezocht", "bezochten", "bezocht",
        "bidden", "bad", "baden", "gebeden",
        "bieden", "bood", "boden", "geboden",
        "bijten", "beet", "beten", "gebeten",
        "binden", "bond", "bonden", "gebonden",
        "blazen", "blies", "bliezen", "geblazen",
        "blijken", "bleek", "bleken", "gebleken",
        "blijven", "bleef", "bleven", "gebleven",
        "braden", "braadde", "braadden", "gebraden",
        "breken", "brak", "braken", "gebroken",
        "brengen", "bracht", "brachten", "gebracht",
        "buigen", "boog", "bogen", "gebogen",
        "denken", "dacht", "dachten", "gedacht",
        "doen", "deed", "deden", "gedaan",
        "dragen", "droeg", "droegen", "gedragen",
        "drijven", "dreef", "dreven", "gedreven",
        "drinken", "dronk", "dronken", "gedronken",
        "duiken", "dook", "doken", "gedoken",
        "dwingen", "dwong", "dwongen", "gedwongen",
        "ervaren", "ervoer", "ervoeren", "ervaren",
        "eten", "at", "aten", "gegeten",
        "fluiten", "floot", "floten", "gefloten",
        "gaan", "ging", "gingen", "gegaan",
        "genezen", "genas", "genazen", "genezen",
        "genieten", "genoot", "genoten", "genoten",
        "geven", "gaf", "gaven", "gegeven",
        "gieten", "goot", "goten", "gegoten",
        "glijden", "gleed", "gleden", "gegleden",
        "glimmen", "glom", "glommen", "geglommen",
        "graven", "groef", "groeven", "gegraven",
        "hangen", "hing", "hingen", "gehangen",
        "hebben", "had", "hadden", "gehad",
        "helpen", "hielp", "hielpen", "geholpen",
        "heten", "heette", "heetten", "geheten",
        "houden", "hield", "hielden", "gehouden",
        "kiezen", "koos", "kozen", "gekozen",
        "kijken", "keek", "keken", "gekeken",
        "klimmen", "klom", "klommen", "geklommen",
        "klinken", "klonk", "klonken", "geklonken",
        "knijpen", "kneep", "knepen", "geknepen",
        "komen", "kwam", "kwamen", "gekomen",
        "kopen", "kocht", "kochten", "gekocht",
        "krijgen", "kreeg", "kregen", "gekregen",
        "krimpen", "kromp", "krompen", "gekrompen",
        "kruipen", "kroop", "kropen", "gekropen",
        "kunnen", "kon", "konden", "gekund",
        "lachen", "lachte", "lachten", "gelachen",
        "laden", "laadde", "laadden", "geladen",
        "laten", "liet", "lieten", "gelaten",
        "lezen", "las", "lazen", "gelezen",
        "liegen", "loog", "logen", "gelogen",
        "liggen", "lag", "lagen", "gelegen",
        "lijden", "leed", "leden", "geleden",
        "lijken", "leek", "leken", "geleken",
        "lopen", "liep", "liepen", "gelopen",
        "meten", "mat", "maten", "gemeten",
        "moeten", "moest", "moesten", "gemoeten",
        "mogen", "mocht", "mochten", "gemogen",
        "nemen", "nam", "namen", "genomen",
        "ontbijten", "ontbeet", "ontbeten", "ontbeten",
        "ontwerpen", "ontwierp", "ontwierpen", "ontworpen",
        "overlijden", "overleed", "overleden", "overleden",
        "raden", "raadde", "raadden", "geraden",
        "rijden", "reed", "reden", "gereden",
        "roepen", "riep", "riepen", "geroepen",
        "ruiken", "rook", "roken", "geroken",
        "scheiden", "scheidde", "scheidden", "gescheiden",
        "schelden", "schold", "scholden", "gescholden",
        "schenken", "schonk", "schonken", "geschonken",
        "scheren", "schoor", "schoren", "geschoren",
        "schieten", "schoot", "schoten", "geschoten",
        "schijnen", "scheen", "schenen", "geschenen",
        "schrijven", "schreef", "schreven", "geschreven",
        "schrikken", "schrok", "schrokken", "geschrokken",
        "schuiven", "schoof", "schoven", "geschoven",
        "slaan", "sloeg", "sloegen", "geslagen",
        "slapen", "sliep", "sliepen", "geslapen",
        "slijpen", "sleep", "slepen", "geslepen",
        "sluipen", "sloop", "slopen", "geslopen",
        "sluiten", "sloot", "sloten", "gesloten",
        "smelten", "smolt", "smolten", "gesmolten",
        "snijden", "sneed", "sneden", "gesneden",
        "snuiten", "snoot", "snoten", "gesnoten",
        "snuiven", "snoof", "snoven", "gesnoven",
        "spijten", "speet", "gespeten",
        "spreken", "sprak", "spraken", "gesproken",
        "springen", "sprong", "sprongen", "gesprongen",
        "spuiten", "spoot", "spoten", "gespoten",
        "staan", "stond", "stonden", "gestaan",
        "steken", "stak", "staken", "gestoken",
        "stelen", "stal", "stalen", "gestolen",
        "sterven", "stierf", "stierven", "gestorven",
        "stijgen", "steeg", "stegen", "gestegen",
        "stinken", "stonk", "stonken", "gestonken",
        "strijden", "streed", "streden", "gestreden",
        "strijken", "streek", "streken", "gestreken",
        "trekken", "trok", "trokken", "getrokken",
        "vallen", "viel", "vielen", "gevallen",
        "vangen", "ving", "vingen", "gevangen",
        "varen", "voer", "voeren", "gevaren",
        "vechten", "vocht", "vochten", "gevochten",
        "verbieden", "verbood", "verboden", "verboden",
        "verdwijnen", "verdween", "verdwenen", "verdwenen",
        "vergelijken", "vergeleek", "vergeleken", "vergeleken",
        "vergeten", "vergat", "vergaten", "vergeten",
        "verliezen", "verloor", "verloren", "verloren",
        "vermijden", "vermeed", "vermeden", "vermeden",
        "verraden", "verraadde", "verraadden", "verraden",
        "vertrekken", "vertrok", "vertrokken", "vertrokken",
        "verwijten", "verweet", "verweten", "verweten",
        "verzinnen", "verzon", "verzonnen", "verzonnen",
        "vinden", "vond", "vonden", "gevonden",
        "vliegen", "vloog", "vlogen", "gevlogen",
        "vouwen", "vouwde", "vouwden", "gevouwen",
        "vragen", "vroeg", "vroegen", "gevraagd",
        "vriezen", "vroor", "gevroren",
        "wassen", "waste", "wasten", "gewassen",
        "wegen", "woog", "wogen", "gewogen",
        "werpen", "wierp", "wierpen", "geworpen",
        "weten", "wist", "wisten", "geweten",
        "wijzen", "wees", "wezen", "gewezen",
        "willen", "wilde", "wilden", "gewild",
        "wouden", "wou", "wouden",
        "winnen", "won", "wonnen", "gewonnen",
        "worden", "werd", "werden", "geworden",
        "wrijven", "wreef", "wreven", "gewreven",
        "zeggen", "zei", "zeiden", "gezegd",
        "zenden", "zond", "zonden", "gezonden",
        "zien", "zag", "zagen", "gezien",
        "zijn", "was", "waren", "geweest",
        "zingen", "zong", "zongen", "gezongen",
        "zinken", "zonk", "zonken", "gezonken",
        "zitten", "zat", "zaten", "gezeten",
        "zoeken", "zocht", "zochten", "gezocht",
        "zuigen", "zoog", "zogen", "gezogen",
        "zullen", "zou", "zouden",
        "zwemmen", "zwom", "zwommen", "gezwommen",
        "zwijgen", "zweeg", "zwegen", "gezwegen"
    };


}



