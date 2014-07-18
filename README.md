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

1.3) Began work on MainActivity.java Several TODO items listed for future updates.
Updated README file with Changelog

README Update and Wishlist) Couldn't even get my numbering in the README Changelog correct.. 
1.3x will consist of:
a) deciding how to store/retrieve the division by store#
b) deciding how to store/retrieve the division product dating data
c) actually use the stored data to display information on the screen
1.4 will consist of:
a) including gen3 in the division product dating data
b) designing gen3 xml
c) setting up gen3 activity (should mirror the gen2 data retrieval/setting)
d) setup/test scrolling up/down on gen3 activity
e) setup/test swiping left/right to move from gen2 to gen3 and back
1.5 will consist of: 
a) developing a search for gen3 (eg "pizza" to bring up all ingredients dating info)
b) ?? TBA