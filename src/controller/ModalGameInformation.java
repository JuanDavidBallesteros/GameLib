package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import model.App;

public class ModalGameInformation {
   
    private Font textEdit = Font.font("Comic Sans",FontPosture.ITALIC, 15);
    
    private MainGUI mainGUI;
    private App app;

    private Stage stage;

    @FXML
    private JFXTextArea taGameText;

    @FXML
    private Label lbGameName;

    @FXML
    private JFXComboBox<String> cbCodeGame;
   
   
    public ModalGameInformation(MainGUI mainGUI, App app) {
        this.mainGUI = mainGUI;
        this.app = app;    
    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void returnAddClient(ActionEvent event) {
        stage.close();
    }


    @FXML
    public void searchGameButton(ActionEvent event) {
        String codeGame = cbCodeGame.getValue();
        taGameText.setFont(textEdit);
        
        if(codeGame == null){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ");
            alert.setHeaderText("Look");
            alert.setContentText("select a game!");

            alert.showAndWait();

        }else{
            switch (codeGame) {
                case "331":
                    lbGameName.setText("The legend of zelda ocarine of time");
                    taGameText.setText("With a stellar soundtrack, thoughtful level design and a deceptively massive feel, The Legend of Zelda: The Ocarina of Time proved to be the picture of polygonal perfection when Nintendo released it in 1998. "+
                                        "One of Nintendo’s first 3-D adventure games, it’s considered by some to be the best-rated videogame ever.");
                    break;
                case "465":
                    lbGameName.setText("Rocket league");
                    taGameText.setText("Rocket league puts you in control of a rocket-powered car and pits you against other vehicles in a heated game of fantasy soccer. " + 
                                        "Fortunately, developer Psyonix absolutely nails the concept and delivers an addicting sports game that is fun when played casually or as an esport.");

                    break;
                case "612":
                    lbGameName.setText("Pro evolution soccer 2021");
                    taGameText.setText("When you step on the pitch, PES 2021 becomes much more than a simple game. The pace is slower. Players handle more responsively. Everything feels more natural. The AI is vastly improved when playing offline."+ 
                                        " Sharper and more aware, offline gamers will really enjoy the variety of matches.");

                    break;
                case "971":
                    lbGameName.setText("Shadow of the tomb raider");
                    taGameText.setText("Shadow of the Tomb Raider tells a great story that continues the series’ tradition of high-concept, Indiana Jones-style mumbo jumbo. This time it’s centered around an impending apocalypse and the search for the ancient item that can prevent it that propels Lara through the dark guts of South America.");

                    break;
                case "441":
                    lbGameName.setText("Until dawn");
                    taGameText.setText("Until Dawn isn't much of a game, but it's a very good interactive horror movie. If you're the kind of gamer who likes to chill out, take it easy, and make some decisions that let you decide which annoying teenager dies first, then it's worth checking out.");

                    break;
                case "112":
                    lbGameName.setText("Super Mario 64");
                    taGameText.setText("SM64 is the greatest videogame to date, and one which all games, regardless of genre, will be judged henceforth. Nintendo set itself a nearly impossible goal and achieved it with SM64. Look closely, Mario's lineage is 2D -- not ideal material upon which to base the most intensely scrutinized 3D video game ever. But video games are, in the end, meant to entertain. And entertainment is at the heart of this fantastic title.");

                    break;
                case "229":
                    lbGameName.setText("Mario kart 8");
                    taGameText.setText("Mario Kart 8 is the best kart racing game Nintendo has made in a long time. It strikes a careful balance between refining old ideas while introducing fresh new ones.");

                    break;
                case "281":
                    lbGameName.setText("Erica");
                    taGameText.setText("You control the actions of the aptly-named Erica, played by Holly Earl. Following the deaths of both her parents, she finds herself floating through life alone in an apartment as the world passes her by. It’s the father’s death that affects the protagonist the most, as nightmares bring back visions of his last moments as Erica holds him close with the killer still in the room. She attempts to suppress these memories, until they’re dragged back into the present day when new clues pertaining to his murder open the case back up.");

                    break;
                case "333":
                    lbGameName.setText("Call of duty black ops II");
                    taGameText.setText("one of the most full-featured and best games in the series. Call of Duty: Black Ops II makes improvements to the formula in every single one of its game modes--from its incredibly balanced and thrilling multiplayer to a campaign that's engaging and full of surprises and a Zombies mode that could pass as its own stand-alone experience.");

                    break;
                case "767":
                    lbGameName.setText("Need for speed Carbon");
                    taGameText.setText("Carbon is an arcade-style racer that plays, in general, a lot like other Need for Speed games. It provides four camera perspectives (two in-car, two over-the-shoulder), a 10-14 hour single-player campaign, and a series of mini-challenges based on collecting racing cards.");

                    break;
                case "287":
                    lbGameName.setText("Smash bros ultimate");
                    taGameText.setText("With 74 fighters (depending on how you count), 108 stages, nearly 1300 Spirit characters to collect, and a single-player Adventure mode that took me a full 24 hours of playtime to beat, Super Smash Bros. Ultimate offers far more in a single package than any of its four predecessors. ");

                    break;
                case "161":
                    lbGameName.setText("Goldeneye 007");
                    taGameText.setText("Goldeneye 007 is a first-person shooter set mostly to the events of the movie of the same name. Being an early console shooter, you will be surprised about the amount of control you have in this game.");
                    
                    break;
                case "678":
                    lbGameName.setText("Just dance 2020");
                    taGameText.setText("The standard Just Dance blueprint remains the same as it always has been you’ll grab a Joy-Con in one hand and dance along to a number of pop hits");

                    break;
                case "408":
                    lbGameName.setText("Hitman 2");
                    taGameText.setText("Unlike most games, which love to send you to outlandish and exotic places, the Hitman series works best when you’re taking down targets in the most relatable, everyday environments possible.");

                    break;
                case "923":
                    lbGameName.setText("For Honor’s");
                    taGameText.setText("For Honor’s combat is the kind of brutal melee I always wanted, but never thought I’d actually get to play. Its third-person action-game exterior hides a strategically complex fighting game, mixing team-based action with less interesting solo modes, all built on the most flexible and technically complete melee fighting system I’ve ever experienced.");
                    break;
                case "569":
                    lbGameName.setText("Grand Theft Auto V");
                    taGameText.setText("I could go on like this for ages. GTA V has an abundance of such moments, big and small, that make San Andreas – the city of Los Santos and its surrounding areas – feel like a living world where anything can happen.");
                    
                    break;
                case "679":
                    lbGameName.setText("Wii sports");
                    taGameText.setText("Wii Sports is great for the fact it comes with Five Games that allow for hours of fun and will have everyone trying to outdo the other. "+
                    "The Five games you get are Baseball, Golf, Tennis, Bowling and Boxing.");
                    
                    break;
                case "131":
                    lbGameName.setText("Metal gear solid V");
                    taGameText.setText("The Phantom Pain, an open-world stealth game about the adventures of Big Boss, also known as Snake, seems to be his unexpected swan song. The Phantom Pain closes the loop on the three decade-long Metal Gear saga and the result, warts and all, turns out to be one of the best entries in the series.");
                    
                    break;
                case "970":
                    lbGameName.setText("Pokemon pearl");
                    taGameText.setText("Under its kid-friendly, thick sugary coating lies a deceptively deep and addictive design that encourages players to create collections of highly marketable creatures of various species. The core mechanic is an adventure with role-playing game battle mechanics.");
                    
                    break;
                case "580":
                    lbGameName.setText("Skyrim");
                    taGameText.setText("The biggest in terms of the actual square footage it covers. That’s given it a lasting presence. Today, Skyrim is available not only for its original launch platforms (PC, PlayStation 3, and Xbox 360) but also Xbox One, PlayStation 4, Nintendo Switch, and VR headsets.");
                    
                    break;
                case "781":
                    lbGameName.setText("Bully");
                    taGameText.setText("Imagine if John Hughes made an open-world videogame starring John Bender, the thug from The Breakfast Club, and you should have a pretty good idea of the tone for Bully. This is an angst-filled game; a light-hearted simulation of the horrors of high school.");    
                
                    break;
                case "382":
                    lbGameName.setText("Plants vs Zombies battle for neighborville");
                    taGameText.setText("Whether you’re listening to a tiny Acorn yodel as it transforms into a mighty Oak tree or watching a wannabe superhero zombie hold his arms aloft like Superman when he sprints, Plants vs. Zombies: Battle for Neighborville's roster pops with personality.");
                    
                    break;
                case "568":
                    lbGameName.setText("Fortnite");
                    taGameText.setText("Fortnite is still the battle royale game to beat. It has a lot going for it, including approachable gameplay modes, bright and zany graphics, an excellent construction system, and a huge player base.");
                    break;
                case "263":
                    lbGameName.setText("The sims 4");
                    taGameText.setText("The Sims 4 is the latest in the world-conquering virtual doll house series, a very unique set of perennial games that reliably arrive feature-light and skeletal, before fattening themselves up with downloadable content and expansion packs of varying quality.");
                    
                    break;
                case "400":
                    lbGameName.setText("Valorant");
                    taGameText.setText("Valorant has captured the collective consciousness of FPS fans. Riot's competitive shooter is just barely out of beta, yet it already stands toe-to-toe with the biggest games in its genre.");
                    
                    break;
                case "983":
                    lbGameName.setText("Counter strike global offensive");
                    taGameText.setText("first-person shooter, gamers from all over the world can work together to complete objectives or eliminate the enemy. Each player can either join the counter-terrorist team or the terrorist team for that particular round, with each team having its own special features or weapons.");
                    
                    break;
                case "546":
                    lbGameName.setText("Killing floor 2");
                    taGameText.setText("It’s a fast, fun co-op shooter with cool classes, satisfying guns, and aggressive, grotesque enemies, all doused in fitting heavy metal music.");
                    
                    break;
                case "325":
                    lbGameName.setText("Zombie army 4");
                    taGameText.setText("Zombie Army 4: Dead War is one of the best co-operative focused games on PS4. Its meaty campaign boasts of impressive level variety, a superb control scheme, and enjoyable gameplay mechanics while a Horde mode tests your abilities to the max.");
                    
                    break;
                case "972":
                    lbGameName.setText("Mortal kombat XI");
                    taGameText.setText("Mortal Kombat 11 is a snappier, sharper-looking game on next-gen consoles. On both Xbox Series X and PS5, the incredibly (and sometimes disturbingly) detailed fighter has received a minor technical facelift and one or two new features that will ultimately make the game better for everyone.");
                    
                    break;
                case "334":
                    lbGameName.setText("Injustice 2");
                    taGameText.setText("Injustice 2 is exceptional. The fight mechanics have been guided in the right direction following 2013’s Injustice: Gods Among Us. The hours of play potential in the new Multiverse mode alone it’s impressive. The heroes and villains of the DC Universe look better here than they have in any game before.");
                    
                    break;
                case "132":
                    lbGameName.setText("Payday 2");
                    taGameText.setText("Fittingly, PayDay 2 is a lot like a bank heist. If you pick your crew well, everything comes together like a well-oiled machine, and everybody gets rich. If, on the other hand, you leave the guy with the IQ of a toaster in charge of grabbing the money while you guard the hostages, you’ve booked yourself a one-way ticket to San Quentin.");
                    
                    break;
                case "882":
                    lbGameName.setText("Portal");
                    taGameText.setText("its uniquely puzzling gameplay and dark, sharp-witted humor thrilled consumers and critics alike. Set in a mysterious scientific facility, Portal introduced players to new ways of moving through the gameworld that challenged their perspective and flexed their spatial awareness. The pitch-perfect voice-over soon became stuff of Internet legend, and the song that played during the end credits was so popular that it has since been released as a downloadable track for Rock Band.");
                    
                    break;
                case "702":
                    lbGameName.setText("Gang beasts");
                    taGameText.setText("Gang Beasts is a drunken hug of a game in which you're fighting the controls as much as you are each other. You're never really in charge of a fight in Gang Beasts.");
                    
                    break;
                case "340":
                    lbGameName.setText("Left 4 dead 2");
                    taGameText.setText("This co-operative action horror FPS takes you and your friends through the cities, swamps and cemeteries of the Deep South, from Savannah to New Orleans across five expansive campaigns. Play as one of four new survivors armed with a wide and devastating array of classic and upgraded weapons.");
                    
                    break;
                case "614":
                    lbGameName.setText("Among us");
                    taGameText.setText("An online and local party game of teamwork and betrayal for 4-10 players...in space!");
                    
                    break;
                case "219":
                    lbGameName.setText("Garry’s mod");
                    taGameText.setText("Garry's Mod is a physics sandbox. Unlike regular games there aren't any predefined aims or goals. We give you the tools and leave you to play.");
                    
                    break;
                case "913":
                    lbGameName.setText("Move or die");
                    taGameText.setText("Move or Die is an absurdly fast-paced, four-player local and online party game where the mechanics change every 20 seconds. The very definition of a perfect friendship-ruining game.");
                    
                    break;
                case "125":
                    lbGameName.setText("Street fighter V");
                    taGameText.setText("With the new Arcade Edition, substantial new modes and game-changing V-trigger moves finally give it the meat on its bones it needs to live up to its legendary name.");
                    
                    break;
                case "566":
                    lbGameName.setText("Minecraft");
                    taGameText.setText("Minecraft lets you shape the blocky world around you with your digital hands and has proved surprisingly compelling to a legion of fans. Because of its fun, creative play, and the creations it has inspired, it's an Editors' Choice and easily among the best PC games.");
                    
                    break;
                case "174":
                    lbGameName.setText("Sniper elite 4");
                    taGameText.setText("elaborate machines built to make simple tasks more complicated, like striking a match or springing a mousetrap? They’re called Rube Goldberg machines, and they now have a shooter equivalent in Sniper Elite 4.");
                    
                    break;
                case "314":
                    lbGameName.setText("Crash bandicoot 4");
                    taGameText.setText("It’s a great excuse to thrust our bandicoots into a diverse bunch of themed stages. You’ve got it all, from the classic beaches and jungles, to pirate ships, jazzy New Orleans swamps, and of course slippy ice flows.");
                    
                    break;
                case "898":
                    lbGameName.setText("Star fox");
                    taGameText.setText("Its level design is solid. Its characters are iconic, and its worlds are imaginative. Its soundtrack is sublime; one of the SNES' very best.");
                    
                    break;
                case "833":
                    lbGameName.setText("Resident evil village");
                    taGameText.setText("ultra-realistic graphics powered by the RE Engine, fight for survival as danger lurks around every corner.");
                    
                    break;
                case "930":
                    lbGameName.setText("God of war");
                    taGameText.setText("The gods and the past get in the way of good intentions, and rather quickly, Kratos and his son find themselves vivisecting undead soldiers, elves, trolls, ancients, and a number of other mythological creatures with silly names and even siller characteristics.");
                    
                    break;
                case "190":
                    lbGameName.setText("Sonic the hedgehog");
                    taGameText.setText("Featuring interactive 3D environments and a large cast of returning and new characters, get ready for the reinvention of Sonic The Hedgehog, in his most intense, high velocity escapade to date.");
                    
                    break;
                case "834":
                    lbGameName.setText("Mario party");
                    taGameText.setText("Super Mario Party is the best Party in two console generations. It’s done away with some, but not all, of the slowness, you get to play a ton of great minigames.");
                    
                    break;
                case "750":
                    lbGameName.setText("Fall guys");
                    taGameText.setText("Colourful, bouncy breath of fresh air that takes a different, less explosive approach to battle royales without losing any of the tension. Instead of C4, it’s Vitamin C you’ll be steering clear of as you’re bombarded with monstrously overgrown oranges.");
                    
                    break;
                case "435":
                    lbGameName.setText("Stranded deep");
                    taGameText.setText("Assume the role of a plane crash survivor stranded somewhere in the Pacific Ocean. Come face-to-face with some of the most life-threatening scenarios that will result in a different experience each time you play as you scavenge for supplies in order to survive on this hostile island.");
                    
                    break;
                case "492":
                    lbGameName.setText("Red dead redemption 2");
                    taGameText.setText("Red Dead Redemption 2 is a sprawling Western tale of loyalty, conviction, and the price of infamy, chronicling the inevitable collapse of a motley crew of Wild West holdouts kicking against the slow march of civilisation and industrialisation.");
                    
                    break;
                case "202":
                    lbGameName.setText("Super Mario galaxy 2");
                    taGameText.setText("There is so much creativity, variety and challenge poured into this sequel. 2007 Super Mario Galaxy was brilliant, but 2010's Super Mario Galaxy 2 is absolutely amazing");
                    
                    break;       
                default:
                    taGameText.setText("This game not exist");
                    break;
            }
        }
    }



    public void cbCodeGames(){
        ObservableList<String> elements = FXCollections.observableArrayList();

        elements.addAll("331","465","612","971","441","112","229","281","333","767","287","161","678",
                        "408","923","569","679","131","970","580","781","382","568","263","400","983",
                        "546","325","972","334","132","882","702","340","614","219","913","125","566",    
                        "174","314","898","833","930","190","834","750","435","492","202");

        cbCodeGame.setItems(elements);
   
    }


}