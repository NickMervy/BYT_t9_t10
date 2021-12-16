import org.junit.Before;
import org.junit.Test;

import Accounts.Account;
import Accounts.User;
import Media.Book;
import Media.Media;
import Media.Score;
import Media.Status.ConfirmedMedia;
import Media.Status.SuggestedMedia;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class MediaTests {
	Media testMedia;

	@Before
	public void setUp() throws Exception {
		testMedia = new Book("Fahrenheit 451", LocalDate.of(1953, 10, 19), "Dystopian", "Ray Bradbury", "Ppbooks");
	}
	
	@Test
	public void setTitleTest() {
		assertThrows(IllegalArgumentException.class, () -> testMedia.setTitle(""));
		assertThrows(IllegalArgumentException.class, () -> testMedia.setTitle("   "));
		assertThrows(IllegalArgumentException.class, () -> testMedia.setTitle(null));

		String newTitle = "New Title";
		testMedia.setTitle(newTitle);
        assertEquals(newTitle, testMedia.getTitle());
	}

	@Test
	public void setReleaseDateTest() {
		assertThrows(IllegalArgumentException.class, () -> testMedia.setReleaseDate(null));

		LocalDate newReleaseDate = LocalDate.of(2021, 12, 20);
		testMedia.setReleaseDate(newReleaseDate);
        assertEquals(newReleaseDate, testMedia.getReleaseDate());
	}

	@Test
	public void setGenreTest() {
		assertThrows(IllegalArgumentException.class, () -> testMedia.setGenre(""));
		assertThrows(IllegalArgumentException.class, () -> testMedia.setGenre("   "));
		assertThrows(IllegalArgumentException.class, () -> testMedia.setGenre(null));

		String newGenre = "New genre";
		testMedia.setGenre(newGenre);
        assertEquals(newGenre, testMedia.getGenre());
	}

	@Test
	public void suggestMedia() {
		assertThrows(IllegalArgumentException.class, () -> testMedia.setReleaseDate(null));

		Account testAccount = new User("abd@gmail.com", "123Test123.");
		testMedia.suggestMedia(testAccount);
        assertTrue(testMedia.getStatus() instanceof SuggestedMedia);
	}

	@Test
	public void ScoreMedia() {
		testMedia.confirmMedia();
		ConfirmedMedia confirmedMedia = (ConfirmedMedia)testMedia.getStatus();
		assertThrows(IllegalArgumentException.class, () -> confirmedMedia.ScoreMedia(null));

		Account testAccount = new User("abd@gmail.com", "123Test123.");
		confirmedMedia.ScoreMedia(new Score(100, testAccount, testMedia));
		confirmedMedia.ScoreMedia(new Score(100, testAccount, testMedia));
		confirmedMedia.ScoreMedia(new Score(100, testAccount, testMedia));

        assertEquals(300, confirmedMedia.AggregateScores());
	}
}
