"""(Incomplete) Tests for SongCollection class."""
from song import Song
from songcollection import SongCollection


def run_tests():
    """Test SongCollection class."""

    # Test empty SongCollection (defaults)
    print("Test empty SongCollection:")
    song_collection = SongCollection()
    print(song_collection)
    assert not song_collection.songs  # an empty list is considered False

    # Test loading songs
    print("Test loading songs:")
    song_collection.load_songs('songs.json')
    print(song_collection)
    assert song_collection.songs  # assuming file is non-empty, non-empty list is considered True

    # Test adding a new Song with values
    print("Test adding new song:")
    song_collection.add_song(Song("My Happiness", "Powderfinger", 1996, True))
    print(song_collection)

    # Test sorting songs
    print("Test sorting - year:")
    song_collection.sort("year")
    print(song_collection)

    # TODO: Add more sorting tests
    print("Test sorting - artist:")
    song_collection.add_song(Song("Leverage Symmetry", "Powderfinger", 1936, False))
    song_collection.add_song(Song("Natural Numbers", "Powderfinger", 1956, True))
    song_collection.sort("artist")
    print(song_collection)

    # TODO: Test saving songs (check file manually to see results)
    song_collection.save_songs("songs.json")

    # TODO: Add more tests, as appropriate, for each method
    song_collection.load_songs("songs_backup.json")
    song_collection.add_song(Song("Abstract Geometry", "Ramanujan", 2000, False))
    print(len(song_collection.songs))
    print(song_collection.count_learned_songs())
    print(song_collection.count_unlearned_songs())
    print(song_collection)
    song_collection.sort("year")
    print(song_collection)
    song_collection.save_songs("songs.json")

run_tests()
