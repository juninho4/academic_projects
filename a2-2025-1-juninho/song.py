"""This is a class structure for song in order to be used in song collection class"""


# TODO: Create your Song class in this file


class Song:
    """This is a song object containing details about the song and whether if it has been learned"""

    def __init__(self, title = "", artist = "", year = 0, is_learned = False):
        """Constructor of the song class"""
        self.title = title
        self.artist = artist
        self.year = year
        self.is_learned = is_learned

    def __str__(self):
        """Return the string representation of the class"""
        learned_string = " (learned)" if self.is_learned else ""
        return f"{self.title} by {self.artist} ({self.year}){learned_string}"

    def mark_as_learned(self):
        """Mark the song as learned"""
        self.is_learned = True

    def mark_as_unlearned(self):
        """Mark the song as unlearned"""
        self.is_learned = False