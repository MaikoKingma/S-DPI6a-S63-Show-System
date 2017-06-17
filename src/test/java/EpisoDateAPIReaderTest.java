import applications.ShowAPIClient.APIs.EpisoDateAPIReader;
import org.junit.*;

import javax.jms.ObjectMessage;

/**
 * Created by Maiko on 17-6-2017.
 */
public class EpisoDateAPIReaderTest {

    private EpisoDateAPIReader reader;

    public EpisoDateAPIReaderTest() { }

    @Before
    public void before() {
        reader = new EpisoDateAPIReader();
    }

    @Test
    public void testGetRequest() {
        try {
            Object result = reader.getShow("Arrow");
            Assert.assertNotNull(result);
        } catch (Exception e) {
            Assert.fail("Exception was thrown");
        }
    }

    @Test
    public void testJsonToShow() {
        String json = "{\n" +
                "  \"tvShow\": {\n" +
                "    \"id\": 29560,\n" +
                "    \"name\": \"Arrow\",\n" +
                "    \"permalink\": \"arrow\",\n" +
                "    \"url\": \"https://www.episodate.com/tv-show/arrow\",\n" +
                "    \"description\": \"Arrow is an American television series developed by writer/producers Greg Berlanti, Marc Guggenheim, and Andrew Kreisberg. It is based on the DC Comics character Green Arrow, a costumed crime-fighter created by Mort Weisinger and George Papp. It premiered in North America on The CW on October 10, 2012, with international broadcasting taking place in late 2012. Primarily filmed in Vancouver, British Columbia, Canada, the series follows billionaire playboy Oliver Queen, portrayed by Stephen Amell, who, five years after being stranded on a hostile island, returns home to fight crime and corruption as a secret vigilante whose weapon of choice is a bow and arrow. Unlike in the comic books, Queen does not go by the alias \\\"Green Arrow\\\".\\r\\n<br><br>\\r\\nThe series takes a realistic look at the Green Arrow character, as well as other characters from the DC Comics universe. Although Oliver Queen/Green Arrow had been featured in the television series Smallville from 2006 to 2011, the producers decided to start clean and find a new actor (Amell) to portray the character. Arrow focuses on the humanity of Oliver Queen, and how he was changed by time spent shipwrecked on an island. Most episodes have flashback scenes to the five years in which Oliver was missing.\",\n" +
                "    \"description_source\": \"http://en.wikipedia.org/wiki/Arrow_%28TV_series%29\",\n" +
                "    \"start_date\": \"2012-10-10\",\n" +
                "    \"end_date\": null,\n" +
                "    \"country\": \"US\",\n" +
                "    \"status\": \"Running\",\n" +
                "    \"runtime\": 60,\n" +
                "    \"network\": \"The CW\",\n" +
                "    \"youtube_link\": \"rhmtiCJa72k\",\n" +
                "    \"image_path\": \"https://static.episodate.com/images/tv-show/full/29560.jpg\",\n" +
                "    \"image_thumbnail_path\": \"https://static.episodate.com/images/tv-show/thumbnail/29560.jpg\",\n" +
                "    \"rating\": \"9.1691\",\n" +
                "    \"rating_count\": \"343\",\n" +
                "    \"countdown\": {\n" +
                "      \"season\": 6,\n" +
                "      \"episode\": 1,\n" +
                "      \"name\": \"TBA\",\n" +
                "      \"air_date\": \"2017-10-13 01:00:00\"\n" +
                "    },\n" +
                "    \"genres\": [\n" +
                "      \"Drama\",\n" +
                "      \"Action\",\n" +
                "      \"Science-Fiction\"\n" +
                "    ],\n" +
                "    \"pictures\": [\n" +
                "      \"https://static.episodate.com/images/episode/29560-242.jpg\",\n" +
                "      \"https://static.episodate.com/images/episode/29560-804.jpg\",\n" +
                "      \"https://static.episodate.com/images/episode/29560-664.jpg\",\n" +
                "      \"https://static.episodate.com/images/episode/29560-120.jpg\",\n" +
                "      \"https://static.episodate.com/images/episode/29560-764.jpg\",\n" +
                "      \"https://static.episodate.com/images/episode/29560-792.jpg\",\n" +
                "      \"https://static.episodate.com/images/episode/29560-159.jpg\"\n" +
                "    ],\n" +
                "    \"episodes\": [\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 1,\n" +
                "        \"name\": \"Pilot\",\n" +
                "        \"air_date\": \"2012-10-11 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 2,\n" +
                "        \"name\": \"Honor Thy Father\",\n" +
                "        \"air_date\": \"2012-10-18 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 3,\n" +
                "        \"name\": \"Lone Gunmen\",\n" +
                "        \"air_date\": \"2012-10-25 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 4,\n" +
                "        \"name\": \"An Innocent Man\",\n" +
                "        \"air_date\": \"2012-11-01 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 5,\n" +
                "        \"name\": \"Damaged\",\n" +
                "        \"air_date\": \"2012-11-08 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 6,\n" +
                "        \"name\": \"Legacies\",\n" +
                "        \"air_date\": \"2012-11-15 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 7,\n" +
                "        \"name\": \"Muse of Fire\",\n" +
                "        \"air_date\": \"2012-11-29 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 8,\n" +
                "        \"name\": \"Vendetta\",\n" +
                "        \"air_date\": \"2012-12-06 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 9,\n" +
                "        \"name\": \"Year's End\",\n" +
                "        \"air_date\": \"2012-12-13 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 10,\n" +
                "        \"name\": \"Burned\",\n" +
                "        \"air_date\": \"2013-01-17 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 11,\n" +
                "        \"name\": \"Trust But Verify\",\n" +
                "        \"air_date\": \"2013-01-24 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 12,\n" +
                "        \"name\": \"Vertigo\",\n" +
                "        \"air_date\": \"2013-01-31 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 13,\n" +
                "        \"name\": \"Betrayal\",\n" +
                "        \"air_date\": \"2013-02-07 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 14,\n" +
                "        \"name\": \"The Odyssey\",\n" +
                "        \"air_date\": \"2013-02-14 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 15,\n" +
                "        \"name\": \"Dodger\",\n" +
                "        \"air_date\": \"2013-02-21 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 16,\n" +
                "        \"name\": \"Dead to Rights\",\n" +
                "        \"air_date\": \"2013-02-28 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 17,\n" +
                "        \"name\": \"The Huntress Returns\",\n" +
                "        \"air_date\": \"2013-03-21 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 18,\n" +
                "        \"name\": \"Salvation\",\n" +
                "        \"air_date\": \"2013-03-28 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 19,\n" +
                "        \"name\": \"Unfinished Business\",\n" +
                "        \"air_date\": \"2013-04-04 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 20,\n" +
                "        \"name\": \"Home Invasion\",\n" +
                "        \"air_date\": \"2013-04-25 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 21,\n" +
                "        \"name\": \"The Undertaking\",\n" +
                "        \"air_date\": \"2013-05-02 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 22,\n" +
                "        \"name\": \"Darkness on the Edge of Town\",\n" +
                "        \"air_date\": \"2013-05-09 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 1,\n" +
                "        \"episode\": 23,\n" +
                "        \"name\": \"Sacrifice\",\n" +
                "        \"air_date\": \"2013-05-16 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 1,\n" +
                "        \"name\": \"City of Heroes\",\n" +
                "        \"air_date\": \"2013-10-10 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 2,\n" +
                "        \"name\": \"Identity\",\n" +
                "        \"air_date\": \"2013-10-17 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 3,\n" +
                "        \"name\": \"Broken Dolls\",\n" +
                "        \"air_date\": \"2013-10-24 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 4,\n" +
                "        \"name\": \"Crucible\",\n" +
                "        \"air_date\": \"2013-10-31 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 5,\n" +
                "        \"name\": \"League of Assassins\",\n" +
                "        \"air_date\": \"2013-11-07 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 6,\n" +
                "        \"name\": \"Keep Your Enemies Closer\",\n" +
                "        \"air_date\": \"2013-11-14 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 7,\n" +
                "        \"name\": \"State v. Queen\",\n" +
                "        \"air_date\": \"2013-11-21 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 8,\n" +
                "        \"name\": \"The Scientist\",\n" +
                "        \"air_date\": \"2013-12-05 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 9,\n" +
                "        \"name\": \"Three Ghosts\",\n" +
                "        \"air_date\": \"2013-12-12 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 10,\n" +
                "        \"name\": \"Blast Radius\",\n" +
                "        \"air_date\": \"2014-01-16 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 11,\n" +
                "        \"name\": \"Blind Spot\",\n" +
                "        \"air_date\": \"2014-01-23 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 12,\n" +
                "        \"name\": \"Tremors\",\n" +
                "        \"air_date\": \"2014-01-30 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 13,\n" +
                "        \"name\": \"Heir to the Demon\",\n" +
                "        \"air_date\": \"2014-02-06 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 14,\n" +
                "        \"name\": \"Time of Death\",\n" +
                "        \"air_date\": \"2014-02-27 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 15,\n" +
                "        \"name\": \"The Promise\",\n" +
                "        \"air_date\": \"2014-03-06 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 16,\n" +
                "        \"name\": \"Suicide Squad\",\n" +
                "        \"air_date\": \"2014-03-20 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 17,\n" +
                "        \"name\": \"Birds of Prey\",\n" +
                "        \"air_date\": \"2014-03-27 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 18,\n" +
                "        \"name\": \"Deathstroke\",\n" +
                "        \"air_date\": \"2014-04-03 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 19,\n" +
                "        \"name\": \"The Man Under the Hood\",\n" +
                "        \"air_date\": \"2014-04-17 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 20,\n" +
                "        \"name\": \"Seeing Red\",\n" +
                "        \"air_date\": \"2014-04-24 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 21,\n" +
                "        \"name\": \"City of Blood\",\n" +
                "        \"air_date\": \"2014-05-01 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 22,\n" +
                "        \"name\": \"Streets of Fire\",\n" +
                "        \"air_date\": \"2014-05-08 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 2,\n" +
                "        \"episode\": 23,\n" +
                "        \"name\": \"Unthinkable\",\n" +
                "        \"air_date\": \"2014-05-15 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 1,\n" +
                "        \"name\": \"The Calm\",\n" +
                "        \"air_date\": \"2014-10-09 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 2,\n" +
                "        \"name\": \"Sara\",\n" +
                "        \"air_date\": \"2014-10-16 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 3,\n" +
                "        \"name\": \"Corto Maltese\",\n" +
                "        \"air_date\": \"2014-10-23 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 4,\n" +
                "        \"name\": \"The Magician\",\n" +
                "        \"air_date\": \"2014-10-30 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 5,\n" +
                "        \"name\": \"The Secret Origin of Felicity Smoak\",\n" +
                "        \"air_date\": \"2014-11-06 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 6,\n" +
                "        \"name\": \"Guilty\",\n" +
                "        \"air_date\": \"2014-11-13 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 7,\n" +
                "        \"name\": \"Draw Back Your Bow\",\n" +
                "        \"air_date\": \"2014-11-20 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 8,\n" +
                "        \"name\": \"The Brave and the Bold\",\n" +
                "        \"air_date\": \"2014-12-04 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 9,\n" +
                "        \"name\": \"The Climb\",\n" +
                "        \"air_date\": \"2014-12-11 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 10,\n" +
                "        \"name\": \"Left Behind\",\n" +
                "        \"air_date\": \"2015-01-22 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 11,\n" +
                "        \"name\": \"Midnight City\",\n" +
                "        \"air_date\": \"2015-01-29 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 12,\n" +
                "        \"name\": \"Uprising\",\n" +
                "        \"air_date\": \"2015-02-05 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 13,\n" +
                "        \"name\": \"Canaries\",\n" +
                "        \"air_date\": \"2015-02-12 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 14,\n" +
                "        \"name\": \"The Return\",\n" +
                "        \"air_date\": \"2015-02-19 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 15,\n" +
                "        \"name\": \"Nanda Parbat\",\n" +
                "        \"air_date\": \"2015-02-26 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 16,\n" +
                "        \"name\": \"The Offer\",\n" +
                "        \"air_date\": \"2015-03-19 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 17,\n" +
                "        \"name\": \"Suicidal Tendencies\",\n" +
                "        \"air_date\": \"2015-03-26 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 18,\n" +
                "        \"name\": \"Public Enemy\",\n" +
                "        \"air_date\": \"2015-04-02 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 19,\n" +
                "        \"name\": \"Broken Arrow\",\n" +
                "        \"air_date\": \"2015-04-16 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 20,\n" +
                "        \"name\": \"The Fallen\",\n" +
                "        \"air_date\": \"2015-04-23 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 21,\n" +
                "        \"name\": \"Al Sah-Him\",\n" +
                "        \"air_date\": \"2015-04-30 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 22,\n" +
                "        \"name\": \"This is Your Sword\",\n" +
                "        \"air_date\": \"2015-05-07 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 3,\n" +
                "        \"episode\": 23,\n" +
                "        \"name\": \"My Name is Oliver Queen\",\n" +
                "        \"air_date\": \"2015-05-14 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 1,\n" +
                "        \"name\": \"Green Arrow\",\n" +
                "        \"air_date\": \"2015-10-08 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 2,\n" +
                "        \"name\": \"The Candidate\",\n" +
                "        \"air_date\": \"2015-10-15 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 3,\n" +
                "        \"name\": \"Restoration\",\n" +
                "        \"air_date\": \"2015-10-22 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 4,\n" +
                "        \"name\": \"Beyond Redemption\",\n" +
                "        \"air_date\": \"2015-10-29 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 5,\n" +
                "        \"name\": \"Haunted\",\n" +
                "        \"air_date\": \"2015-11-05 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 6,\n" +
                "        \"name\": \"Lost Souls\",\n" +
                "        \"air_date\": \"2015-11-12 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 7,\n" +
                "        \"name\": \"Brotherhood\",\n" +
                "        \"air_date\": \"2015-11-19 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 8,\n" +
                "        \"name\": \"Legends of Yesterday, Part 2\",\n" +
                "        \"air_date\": \"2015-12-03 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 9,\n" +
                "        \"name\": \"Dark Waters\",\n" +
                "        \"air_date\": \"2015-12-10 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 10,\n" +
                "        \"name\": \"Blood Debts\",\n" +
                "        \"air_date\": \"2016-01-21 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 11,\n" +
                "        \"name\": \"A.W.O.L.\",\n" +
                "        \"air_date\": \"2016-01-28 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 12,\n" +
                "        \"name\": \"Unchained\",\n" +
                "        \"air_date\": \"2016-02-04 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 13,\n" +
                "        \"name\": \"Sins of the Father\",\n" +
                "        \"air_date\": \"2016-02-11 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 14,\n" +
                "        \"name\": \"Code of Silence\",\n" +
                "        \"air_date\": \"2016-02-18 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 15,\n" +
                "        \"name\": \"Taken\",\n" +
                "        \"air_date\": \"2016-02-25 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 16,\n" +
                "        \"name\": \"Broken Hearts\",\n" +
                "        \"air_date\": \"2016-03-24 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 17,\n" +
                "        \"name\": \"Beacon of Hope\",\n" +
                "        \"air_date\": \"2016-03-31 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 18,\n" +
                "        \"name\": \"Eleven-Fifty-Nine\",\n" +
                "        \"air_date\": \"2016-04-07 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 19,\n" +
                "        \"name\": \"Canary Cry\",\n" +
                "        \"air_date\": \"2016-04-28 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 20,\n" +
                "        \"name\": \"Genesis\",\n" +
                "        \"air_date\": \"2016-05-05 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 21,\n" +
                "        \"name\": \"Monument Point\",\n" +
                "        \"air_date\": \"2016-05-12 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 22,\n" +
                "        \"name\": \"Lost in the Flood\",\n" +
                "        \"air_date\": \"2016-05-19 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 4,\n" +
                "        \"episode\": 23,\n" +
                "        \"name\": \"Schism\",\n" +
                "        \"air_date\": \"2016-05-26 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 1,\n" +
                "        \"name\": \"Legacy\",\n" +
                "        \"air_date\": \"2016-10-06 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 2,\n" +
                "        \"name\": \"The Recruits\",\n" +
                "        \"air_date\": \"2016-10-13 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 3,\n" +
                "        \"name\": \"A Matter of Trust\",\n" +
                "        \"air_date\": \"2016-10-20 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 4,\n" +
                "        \"name\": \"Penance\",\n" +
                "        \"air_date\": \"2016-10-27 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 5,\n" +
                "        \"name\": \"Human Target\",\n" +
                "        \"air_date\": \"2016-11-03 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 6,\n" +
                "        \"name\": \"So It Begins\",\n" +
                "        \"air_date\": \"2016-11-10 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 7,\n" +
                "        \"name\": \"Vigilante\",\n" +
                "        \"air_date\": \"2016-11-17 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 8,\n" +
                "        \"name\": \"Invasion!\",\n" +
                "        \"air_date\": \"2016-12-01 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 9,\n" +
                "        \"name\": \"What We Leave Behind\",\n" +
                "        \"air_date\": \"2016-12-08 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 10,\n" +
                "        \"name\": \"Who Are You?\",\n" +
                "        \"air_date\": \"2017-01-26 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 11,\n" +
                "        \"name\": \"Second Chances\",\n" +
                "        \"air_date\": \"2017-02-02 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 12,\n" +
                "        \"name\": \"Bratva\",\n" +
                "        \"air_date\": \"2017-02-09 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 13,\n" +
                "        \"name\": \"Spectre of the Gun\",\n" +
                "        \"air_date\": \"2017-02-16 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 14,\n" +
                "        \"name\": \"The Sin-Eater\",\n" +
                "        \"air_date\": \"2017-02-23 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 15,\n" +
                "        \"name\": \"Fighting Fire with Fire\",\n" +
                "        \"air_date\": \"2017-03-02 01:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 16,\n" +
                "        \"name\": \"Checkmate\",\n" +
                "        \"air_date\": \"2017-03-16 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 17,\n" +
                "        \"name\": \"Kapiushon\",\n" +
                "        \"air_date\": \"2017-03-23 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 18,\n" +
                "        \"name\": \"Disbanded\",\n" +
                "        \"air_date\": \"2017-03-30 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 19,\n" +
                "        \"name\": \"Dangerous Liaisons\",\n" +
                "        \"air_date\": \"2017-04-27 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 20,\n" +
                "        \"name\": \"Underneath\",\n" +
                "        \"air_date\": \"2017-05-04 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 21,\n" +
                "        \"name\": \"Honor Thy Fathers\",\n" +
                "        \"air_date\": \"2017-05-11 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 22,\n" +
                "        \"name\": \"Missing\",\n" +
                "        \"air_date\": \"2017-05-18 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 5,\n" +
                "        \"episode\": 23,\n" +
                "        \"name\": \"Lian Yu\",\n" +
                "        \"air_date\": \"2017-05-25 00:00:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"season\": 6,\n" +
                "        \"episode\": 1,\n" +
                "        \"name\": \"TBA\",\n" +
                "        \"air_date\": \"2017-10-13 01:00:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        try {
            //Object result = reader.jsonToShow(json);
            //Assert.assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception was thrown");
        }
    }

    @Test
    public void testJsonToShows() {
        String json = "{\n" +
                "  \"total\": \"1\",\n" +
                "  \"page\": 1,\n" +
                "  \"pages\": 1,\n" +
                "  \"tv_shows\": [\n" +
                "    {\n" +
                "      \"id\": 29560,\n" +
                "      \"name\": \"Arrow\",\n" +
                "      \"permalink\": \"arrow\",\n" +
                "      \"country\": \"US\",\n" +
                "      \"network\": \"The CW\",\n" +
                "      \"status\": \"Running\",\n" +
                "      \"image_thumbnail_path\": \"https://static.episodate.com/images/tv-show/thumbnail/29560.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 50488,\n" +
                "      \"name\": \"Arrow Affliction\",\n" +
                "      \"permalink\": \"arrow-affliction\",\n" +
                "      \"country\": \"US\",\n" +
                "      \"network\": \"Sportsman Channel\",\n" +
                "      \"status\": \"Running\",\n" +
                "      \"image_thumbnail_path\": \"https://static.episodate.com/images/tv-show/thumbnail/50488.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 35594,\n" +
                "      \"name\": \"Arrow Emblem – Hawk of the Grand Prix\",\n" +
                "      \"permalink\": \"arrow-emblem-hawk-of-the-grand-prix\",\n" +
                "      \"country\": \"JP\",\n" +
                "      \"network\": \"Fuji TV\",\n" +
                "      \"status\": \"Canceled/Ended\",\n" +
                "      \"image_thumbnail_path\": \"https://static.episodate.com/images/tv-show/thumbnail/35594.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 49417,\n" +
                "      \"name\": \"Red Arrow\",\n" +
                "      \"permalink\": \"red-arrow\",\n" +
                "      \"country\": \"US\",\n" +
                "      \"network\": \"Outdoor Channel\",\n" +
                "      \"status\": \"To Be Determined\",\n" +
                "      \"image_thumbnail_path\": \"https://static.episodate.com/images/tv-show/thumbnail/49417.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 29089,\n" +
                "      \"name\": \"The Black Arrow\",\n" +
                "      \"permalink\": \"the-black-arrow\",\n" +
                "      \"country\": \"UK\",\n" +
                "      \"network\": \"BBC one\",\n" +
                "      \"status\": \"Canceled/Ended\",\n" +
                "      \"image_thumbnail_path\": \"https://static.episodate.com/images/tv-show/thumbnail/29089.jpg\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
//            Object result = reader.jsonToShows(json);
//            Assert.assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception was thrown");
        }
    }
}