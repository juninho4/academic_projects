"""Menu prompt for the song list and make uses of classes"""
# TODO: Copy your first assignment to this file, commit, then update to use Song class
# Use SongCollection class if you want to

from song import Song
from songcollection import SongCollection

MENU = """Menu:
D - Display songs
A - Add new song
C - Complete a song
Q - Quit"""

FILE = "songs.json"
INVALID_NUMBER = "Invalid song number"
NON_NATURAL_NUMBER = "Number must be > 0."

def main():
    """This program allows the user to display, add, complete their list of songs"""
    print("Song List 1.0 - by Juninho Chandra")

    # Get the contents of file
    songs = load_songs()
    print(f"{len(songs.songs)} songs loaded.")

    # Menu of choices
    menu(songs)

    # Overwrite the csv file
    save_songs(songs)
    print("Make some music!")

def menu(songs):
    """Display the menu"""
    print(MENU)
    choice = input(">>> ").upper()
    while choice != "Q":
        if choice == "D":
            # Display songs.
            display_songs(songs)
        elif choice == "A":
            # Add new song
            add_song(songs)
        elif choice == "C":
            # Complete a song.
            complete_song(songs)
        else:
            print("Invalid menu choice")
        print(MENU)
        choice = input(">>> ").upper()

def load_songs():
    """Return a sorted list of list from file"""
    songs = SongCollection()
    songs.load_songs(FILE)
    return songs

def display_songs(songs):
    """Display a neatly formatted list of songs"""

    # Get the max alignment for printing.
    max_title_align = 0
    max_artist_align = 0
    for song in songs.songs:
        max_title_align = max(max_title_align, len(song.title))
        max_artist_align = max(max_artist_align, len(song.artist))

    # Start displaying the format.
    total_songs_learned = 0
    for i, song in enumerate(songs.songs, start=1):
        learned_string = " * "
        if song.is_learned:
            learned_string = "   "
            total_songs_learned += 1

        title = song.title
        artist = song.artist
        year = song.year
        print(f"{i}.{learned_string}{title:{max_title_align}}  - {artist:{max_artist_align}}  ({year})")
    print(f"{total_songs_learned} songs learned, {len(songs.songs) - total_songs_learned} songs still to learn.")

def complete_song(songs):
    """Complete the song by marking them"""
    songs_completed = True

    # Consider the case if there are no songs unlearned.
    for song in songs.songs:
        if not song.is_learned:
            songs_completed = False
    if songs_completed:
        print("No more songs to learn!")
    # At least 1 song is unlearned.
    else:
        has_complete = False
        print("Enter the number of a song to mark as learned.")
        while not has_complete:
            try:
                song_num = int(input(">>> "))
                if song_num < 1:
                    print(NON_NATURAL_NUMBER)
                else:
                    try:
                        song = songs.songs[song_num - 1]
                        title = song.title
                        artist = song.artist
                        if not song.is_learned:
                            song.mark_as_learned()
                            print(f"{title} by {artist} learned")
                        else:
                            print(f"You have already learned {title}")
                        has_complete = True
                    except IndexError:
                        print(INVALID_NUMBER)
            except ValueError:
                print(INVALID_NUMBER)

def add_song(songs):
    """Add a song to the list"""
    print("Enter details for a new song.")

    # Get title from user.
    title = get_attribute("Title")
    # Get artist from user.
    artist = get_attribute("Artist")

    # Get year from user.
    year = input("Year: ")
    is_year_valid = False
    while not is_year_valid:
        try:
            year = int(year)
            if year < 1:
                print(NON_NATURAL_NUMBER)
                year = input("Year: ")
            else:
                is_year_valid = True
        except ValueError:
            print("Invalid input; enter a valid number.")
            year = input("Year: ")

    # Add the song to the list.
    songs.add_song(Song(title, artist, year, False))
    songs.sort('year')
    print(f"{title} by {artist} ({year}) added to song list.")

def get_attribute(attribute):
    """Get input from the user for a certain attribute"""
    attribute_input = input(f"{attribute}: ")
    while attribute_input == "":
        print("Input can not be blank.")
        attribute_input = input(f"{attribute}: ")
    return attribute_input

def save_songs(songs):
    """Overwrite the file"""
    # Convert the list of lists to a string for writing
    songs.save_songs(FILE)
    print(f"{len(songs.songs)} songs saved to {FILE}")

if __name__ == '__main__':
    main()
