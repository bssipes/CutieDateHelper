CutieDateHelper by Benjamin Sipes
===============
This project is a Java Android Application. The intended use is to help QuikTrip employees in confirming the correct julian dates to place on products, such as grill food, breakfast sandwiches, and frozen that need thaw/stale dates.

Changelog:
1.1) Begin planning / toying with layout for Settings menu

1.11) Moved 1.0 MainActivity into OldStyle, made OldStyle the default loaded
activity. No (intended) changes to how the app currently looks, though
Settings is now accessible.

1.12) Settings now loads properly and remembers checkbox / default store
settings. MainActivity is not loading afterwards, getting Null Pointer
Exception upon clicking Save and Submit button.

1.2) 1.1 (saving/retrieving data) seems to be functional now, moving on to
passing the data to MainActivity. As of current, still crashing.

1.21) Fixed MainActivity crash. Now properly loads and displays the searched
Store#. Currently working on settings up all the needed strings for the
Gen2 layout.
TODO: Research how to make swipe left/right transitions

1.22) Finished setting up the MainActivity xml layout

1.23) Forgot to update a copy/paste job in the Main xml.

1.24) Began work on MainActivity.java Several TODO items listed for future updates.
Updated README file with Changelog
