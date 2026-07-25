"""This is a class structure for the song collection which stores a list of songs object"""


# TODO: Create your SongCollection class in this file
from song import Song
from operator import attrgetter
import json

class SongCollection:
    """Song collection class containing list of songs and methods for modifying them"""
    songs = []

    def add_song(self, song):
        """Add the song to the collection"""
        self.songs.append(song)

    def count_unlearned_songs(self):
        """Count the total of unlearned songs in the collection"""
        total_unlearned_songs = 0
        for song in self.songs:
            if not song.is_learned:
                total_unlearned_songs += 1
        return total_unlearned_songs

    def count_learned_songs(self):
        """Count the total of learned songs in the collection"""
        total_learned_songs = 0
        for song in self.songs:
            if song.is_learned:
                total_learned_songs += 1
        return total_learned_songs

    def load_songs(self, file):
        """Load songs from a json file to store it into the list"""
        self.songs = []
        with open(file) as json_file:
            json_data = json.load(json_file)
        for data in json_data:
            song = Song(data["title"], data["artist"], data["year"], data["is_learned"])
            self.songs.append(song)

    def save_songs(self, file):
        """Save songs into a json file from the list"""
        songs = []
        for song in self.songs:
            song_dict = {"title": song.title, "artist": song.artist, "year": song.year, "is_learned": song.is_learned}
            songs.append(song_dict)
        with open(file, "w") as json_file:
            json.dump(songs, json_file)

    def sort(self, key):
        """Sort the list of songs based on the specified key, then by title"""
        self.songs = sorted(self.songs, key=attrgetter(key, 'title'))

    def __str__(self):
        """Return a string representation of song collection object"""
        string = ""
        for song in self.songs:
            string += song.__str__() + "\n"
        return string