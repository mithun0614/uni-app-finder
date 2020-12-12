package main;

public class BookmarkedUniversities {

	public void addBookmark(University uni, User account) {
		account.bookmarked.add(uni);
	}

	// Compares the person's average to the university's cutoff, returns
	// true if they pass the cutoff requirements, otherwise, it returns false
	public boolean compareCutoff(University uni, User account) {
		if (account.getAverage() < uni.getCutoff())
			return false;
		else
			return true;

	}

	// Compares the person's preferred tuition to the university's tuition.
	// Returns false if the university is above their budget, true if it is under.
	public boolean compareTuition(University uni, User account) {
		if (account.getTuition() < uni.getTuition())
			return false;
		else
			return true;
	}

	// Compares the person's preferred class size to the university's.
	// Returns true if the university class size is larger, otherwise, returns false.
	public boolean compareClassSize(University uni, User account) {
		if (uni.getClassSize() > account.getPreferredClassSize())
			return false;
		else
			return true;
	}

}
