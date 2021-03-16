package com.example.daltondoveandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ContactActivity extends AppCompatActivity {

    private TextView mDisplayAboutTextView;
    private Button mOpenWebpageButton;
    private Button mOpenMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // connect with UI elements
        mDisplayAboutTextView = (TextView) findViewById(R.id.tv_about_text);


        Intent intentThatStartedThisActivity = getIntent();
        String movies = "\n\nThe Shawshank Redemption\n" +
                "The Godfather\n" +
                "The Godfather: Part II\n" +
                "The Dark Knight\n" +
                "12 Angry Men\n" +
                "Schindler's List\n" +
                "The Lord of the Rings: The Return of the King\n" +
                "Pulp Fiction\n" +
                "The Good, the Bad and the Ugly\n" +
                "The Lord of the Rings: The Fellowship of the Ring\n" +
                "Fight Club\n" +
                "Forrest Gump\n" +
                "Inception\n" +
                "The Lord of the Rings: The Two Towers\n" +
                "Star Wars: Episode V - The Empire Strikes Back\n" +
                "The Matrix\n" +
                "Goodfellas\n" +
                "One Flew Over the Cuckoo's Nest\n" +
                "Seven Samurai\n" +
                "Se7en\n" +
                "Life Is Beautiful\n" +
                "City of God\n" +
                "The Silence of the Lambs\n" +
                "It's a Wonderful Life\n" +
                "Star Wars: Episode IV - A New Hope\n" +
                "Saving Private Ryan\n" +
                "The Green Mile\n" +
                "Spirited Away\n" +
                "Interstellar\n" +
                "Parasite\n" +
                "Léon: The Professional\n" +
                "Hara-Kiri\n" +
                "The Usual Suspects\n" +
                "The Lion King\n" +
                "The Pianist\n" +
                "Terminator 2: Judgment Day\n" +
                "Back to the Future\n" +
                "American History X\n" +
                "Modern Times\n" +
                "Gladiator\n" +
                "Psycho\n" +
                "The Departed\n" +
                "City Lights\n" +
                "The Intouchables\n" +
                "Whiplash\n" +
                "Grave of the Fireflies\n" +
                "The Prestige\n" +
                "Once Upon a Time in the West\n" +
                "Casablanca\n" +
                "Cinema Paradiso\n" +
                "Rear Window\n" +
                "Alien\n" +
                "Apocalypse Now\n" +
                "Memento\n" +
                "The Great Dictator\n" +
                "Indiana Jones and the Raiders of the Lost Ark\n" +
                "Django Unchained\n" +
                "The Lives of Others\n" +
                "Hamilton\n" +
                "Paths of Glory\n" +
                "Joker\n" +
                "WALL·E\n" +
                "The Shining\n" +
                "Avengers: Infinity War\n" +
                "Sunset Blvd.\n" +
                "Witness for the Prosecution\n" +
                "Oldboy\n" +
                "Spider-Man: Into the Spider-Verse\n" +
                "Princess Mononoke\n" +
                "Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb\n" +
                "The Dark Knight Rises\n" +
                "Once Upon a Time in America\n" +
                "Your Name.\n" +
                "Aliens\n" +
                "Coco\n" +
                "Avengers: Endgame\n" +
                "Capernaum\n" +
                "American Beauty\n" +
                "Braveheart\n" +
                "High and Low\n" +
                "Das Boot\n" +
                "Toy Story\n" +
                "3 Idiots\n" +
                "Amadeus\n" +
                "Inglourious Basterds\n" +
                "Good Will Hunting\n" +
                "Star Wars: Episode VI - Return of the Jedi\n" +
                "Like Stars on Earth\n" +
                "Reservoir Dogs\n" +
                "2001: A Space Odyssey\n" +
                "Requiem for a Dream\n" +
                "The Hunt\n" +
                "Vertigo\n" +
                "M\n" +
                "Eternal Sunshine of the Spotless Mind\n" +
                "Citizen Kane\n" +
                "Dangal\n" +
                "Singin' in the Rain\n" +
                "Bicycle Thieves\n" +
                "The Kid\n" +
                "Full Metal Jacket\n" +
                "Come and See\n" +
                "Snatch\n" +
                "Ikiru\n" +
                "North by Northwest\n" +
                "A Clockwork Orange\n" +
                "Scarface\n" +
                "1917\n" +
                "Taxi Driver\n" +
                "Incendies\n" +
                "A Separation\n" +
                "Toy Story 3\n" +
                "The Sting\n" +
                "Lawrence of Arabia\n" +
                "Amélie\n" +
                "Metropolis\n" +
                "The Apartment\n" +
                "For a Few Dollars More\n" +
                "Double Indemnity\n" +
                "To Kill a Mockingbird\n" +
                "Up\n" +
                "Indiana Jones and the Last Crusade\n" +
                "Heat\n" +
                "L.A. Confidential\n" +
                "Green Book\n" +
                "Die Hard\n" +
                "Monty Python and the Holy Grail\n" +
                "Batman Begins\n" +
                "Yojimbo\n" +
                "Rashomon\n" +
                "Downfall\n" +
                "Children of Heaven\n" +
                "Unforgiven\n" +
                "Ran\n" +
                "Some Like It Hot\n" +
                "Howl's Moving Castle\n" +
                "All About Eve\n" +
                "Casino\n" +
                "A Beautiful Mind\n" +
                "The Wolf of Wall Street\n" +
                "The Great Escape\n" +
                "Pan's Labyrinth\n" +
                "There Will Be Blood\n" +
                "The Secret in Their Eyes\n" +
                "Lock, Stock and Two Smoking Barrels\n" +
                "Judgment at Nuremberg\n" +
                "Raging Bull\n" +
                "My Neighbor Totoro\n" +
                "The Treasure of the Sierra Madre\n" +
                "Dial M for Murder\n" +
                "Three Billboards Outside Ebbing, Missouri\n" +
                "Shutter Island\n" +
                "Chinatown\n" +
                "The Gold Rush\n" +
                "My Father and My Son\n" +
                "No Country for Old Men\n" +
                "V for Vendetta\n" +
                "Inside Out\n" +
                "The Thing\n" +
                "The Elephant Man\n" +
                "The Seventh Seal\n" +
                "Warrior\n" +
                "The Sixth Sense\n" +
                "Jurassic Park\n" +
                "Klaus\n" +
                "Trainspotting\n" +
                "The Truman Show\n" +
                "Gone with the Wind\n" +
                "Finding Nemo\n" +
                "Stalker\n" +
                "Wild Strawberries\n" +
                "Kill Bill: Vol. 1\n" +
                "Blade Runner\n" +
                "Memories of Murder\n" +
                "The Bridge on the River Kwai\n" +
                "Fargo\n" +
                "Room\n" +
                "Wild Tales\n" +
                "Gran Torino\n" +
                "Tokyo Story\n" +
                "The Third Man\n" +
                "On the Waterfront\n" +
                "The Deer Hunter\n" +
                "In the Name of the Father\n" +
                "Mary and Max\n" +
                "The Grand Budapest Hotel\n" +
                "Before Sunrise\n" +
                "Catch Me If You Can\n" +
                "Gone Girl\n" +
                "Hacksaw Ridge\n" +
                "Prisoners\n" +
                "Persona\n" +
                "Andhadhun\n" +
                "Sherlock Jr.\n" +
                "The Big Lebowski\n" +
                "Barry Lyndon\n" +
                "To Be or Not to Be\n" +
                "The General\n" +
                "How to Train Your Dragon\n" +
                "Autumn Sonata\n" +
                "Ford v Ferrari\n" +
                "12 Years a Slave\n" +
                "The Bandit\n" +
                "Anand\n" +
                "Mr. Smith Goes to Washington\n" +
                "Mad Max: Fury Road\n" +
                "Raatchasan\n" +
                "Dead Poets Society\n" +
                "Million Dollar Baby\n" +
                "Stand by Me\n" +
                "Harry Potter and the Deathly Hallows: Part 2\n" +
                "Network\n" +
                "Ben-Hur\n" +
                "Hachi: A Dog's Tale\n" +
                "Cool Hand Luke\n" +
                "The Handmaiden\n" +
                "Logan\n" +
                "Platoon\n" +
                "Into the Wild\n" +
                "Rush\n" +
                "The Wages of Fear\n" +
                "Monty Python's Life of Brian\n" +
                "La Haine\n" +
                "The 400 Blows\n" +
                "Soul\n" +
                "The Passion of Joan of Arc\n" +
                "Spotlight\n" +
                "Hotel Rwanda\n" +
                "Amores Perros\n" +
                "Gangs of Wasseypur\n" +
                "Monsters, Inc.\n" +
                "Andrei Rublev\n" +
                "Rocky\n" +
                "Nausicaä of the Valley of the Wind\n" +
                "Rebecca\n" +
                "Time of the Gypsies\n" +
                "Before Sunset\n" +
                "In the Mood for Love\n" +
                "Rififi\n" +
                "Rang De Basanti\n" +
                "Paris, Texas\n" +
                "Drishyam\n" +
                "Portrait of a Lady on Fire\n" +
                "It Happened One Night\n" +
                "A Silent Voice: The Movie\n" +
                "The Invisible Guest\n" +
                "The Battle of Algiers\n" +
                "Three Colors: Red\n" +
                "7 Kogustaki Mucize\n" +
                "Tangerines";

        mDisplayAboutTextView.append(movies);

    }
} // end of ContactActivity class