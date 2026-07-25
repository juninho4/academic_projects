"""
Name: Juninho Chandra
Date Started: 11/04/2025
Brief Project Description: Making a GUI interface of a song list
GitHub URL: https://github.com/cp1404-students/a2-2025-1-juninhochandra
"""
# TODO: Create your main program in this file, using the SongListApp class

"""Python program for creating a GUI kivy interface for list of songs"""
from kivy.app import App
from kivy.lang import Builder
from kivy.properties import ListProperty
from kivy.properties import ObjectProperty
from kivy.uix.button import Button

from song import Song
from songcollection import SongCollection

YELLOW = (1, 1, 0, 1)
BLUE = (0, 1, 1, 1)
FILE = "songs.json"
TEXT_TO_KEY = {"Artist": "artist", "Title": "title", "Year": "year", "Learned": "is_learned"}

class SongListApp(App):
    """Main program - Kivy app for making a song list interface"""
    sort_keys = ListProperty()
    songs = ObjectProperty()

    def build(self):
        """Build the kivy GUI"""
        self.sort_keys = TEXT_TO_KEY.keys()
        self.songs = SongCollection()
        self.songs.load_songs(FILE)

        self.title = "Song List 2.0 by Juninho Chandra"
        self.root = Builder.load_file('app.kv')

        self.create_songs_list()
        self.change_learned_text()

        return self.root

    def create_songs_list(self):
        """Create song list for the kivy GUI interface"""
        self.root.ids.songs_list.clear_widgets()
        for song in self.songs.songs:
            # Create button for each song object, specifying the text
            color = YELLOW if song.is_learned else BLUE
            temp_button = Button(text=song.__str__(), background_color=color)
            temp_button.bind(on_release=self.change_song_state)
            temp_button.song = song
            self.root.ids.songs_list.add_widget(temp_button)

    def sort_by(self, key):
        """Sort the song list by the specified key"""
        self.songs.sort(TEXT_TO_KEY[key])
        # After sorting create the song list again.
        self.create_songs_list()

    def change_song_state(self, button):
        """Change the song state once the button is pressed"""
        song = button.song
        if song.is_learned:
            song.mark_as_unlearned()
            button.background_color = BLUE
            self.root.ids.warning_text.text = f"You need to learn {song.title}"
        else:
            song.mark_as_learned()
            button.background_color = YELLOW
            self.root.ids.warning_text.text = f"You have learned {song.title}"
        button.text = song.__str__()
        #Change the text label for total learned and unlearned songs
        self.change_learned_text()
        # After changing the song state, if the sort button is IsLearned.
        # Make sure to sort it again.
        current_sort_key = self.root.ids.sort_by.text
        if current_sort_key == "Learned":
            self.sort_by(current_sort_key)

    def change_learned_text(self):
        """Change the text of the total learned and unlearned songs."""
        total_unlearned = self.songs.count_unlearned_songs()
        total_learned = self.songs.count_learned_songs()
        self.root.ids.learned_text.text = f"To learn: {total_unlearned}     Learned: {total_learned}"

    def add_song(self):
        """Add new song to the list"""
        title = self.root.ids.input_title.text
        artist = self.root.ids.input_artist.text
        year = self.root.ids.input_year.text
        # Empty field detected.
        if title == "" or artist == "" or year == "":
            self.root.ids.warning_text.text = "Complete all the fields"
        else:
            try:
                year = int(year)
                # Year must be greater than 0.
                if year < 1:
                    self.root.ids.warning_text.text = "The year must be > 0"
                else:
                    # Add the song once the inputs are validated.
                    song = Song(title, artist, year, False)
                    self.songs.add_song(song)
                    # Clear the input and status fields
                    self.clear_fields()
                    # Sort the song list and create a new song list.
                    # as well as updating the total learned and unlearned text.
                    self.sort_by(self.root.ids.sort_by.text)
                    self.change_learned_text()
            except ValueError:
                # Invalid input for the year.
                self.root.ids.warning_text.text = "Enter a valid number"

    def clear_fields(self):
        """Clear the input fields on title, artist, and year"""
        self.root.ids.input_title.text = ""
        self.root.ids.input_artist.text = ""
        self.root.ids.input_year.text = ""
        self.root.ids.warning_text.text = ""

    def on_stop(self):
        """Save list of songs to the json file once the program stops"""
        self.songs.save_songs(FILE)

if __name__ == '__main__':
    SongListApp().run()
