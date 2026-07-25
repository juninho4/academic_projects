"""(Incomplete) Tests for Song class."""
from song import Song


def run_tests():
    """Test Song class."""

    # Test empty song (defaults)
    print("Test empty song:")
    default_song = Song()
    print(default_song)
    assert default_song.artist == ""
    assert default_song.title == ""
    assert default_song.year == 0
    assert default_song.is_learned is False

    # Test initial-value song
    initial_song = Song("My Happiness", "Powderfinger", 1996, True)
    # TODO: Write tests to show this initialisation works
    print(initial_song)
    assert initial_song.artist == "Powderfinger"
    assert initial_song.title == "My Happiness"
    assert initial_song.year == 1996
    assert initial_song.is_learned is True

    # TODO: Add more tests, as appropriate, for each method
    second_song = Song("Calculus", "Newton", 1969, False)
    print(second_song)
    assert second_song.artist == "Newton"
    assert second_song.title == "Calculus"
    assert second_song.year == 1969
    assert second_song.is_learned is False
    second_song.mark_as_learned()
    assert second_song.is_learned is True
    second_song.mark_as_unlearned()
    assert second_song.is_learned is False

run_tests()
