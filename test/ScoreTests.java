import org.junit.Test;

import Accounts.Account;
import Accounts.User;
import Media.Book;
import Media.Media;
import Media.Score;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class ScoreTests {
	
    @Test
	public void ScoreTest() {
		Account testAccount = new User("abd@gmail.com", "123Test123.");
		Media testMedia = new Book("Fahrenheit 451", LocalDate.of(1953, 10, 19), "Dystopian", "Ray Bradbury", "Ppbooks");

		assertThrows(IllegalArgumentException.class, () -> new Score(100, null, testMedia));
		assertThrows(IllegalArgumentException.class, () -> new Score(100, testAccount, null));
		assertThrows(IllegalArgumentException.class, () -> new Score(100, null, null));
	}

	@Test
	public void postReview() {
		Account testAccount = new User("abd@gmail.com", "123Test123.");
		Media testMedia = new Book("Fahrenheit 451", LocalDate.of(1953, 10, 19), "Dystopian", "Ray Bradbury", "Ppbooks");
		Score testScore = new Score(100, testAccount, testMedia);

		assertThrows(IllegalArgumentException.class, () -> testScore.postReview(""));
		assertThrows(IllegalArgumentException.class, () -> testScore.postReview("   "));
		assertThrows(IllegalArgumentException.class, () -> testScore.postReview(null));

		String newReview = "New Review";
		testScore.postReview(newReview);
        assertEquals(newReview, testScore.getReview());
	}
}
