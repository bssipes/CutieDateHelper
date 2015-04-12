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

1.3-1.5) Who knows? I was lazy and didn't document this well.

1.51) Removed the Gen3 checkbox from Settings. Made the MainActivity scrollable.

1.52) Initial addition of Gen3 placeholders

1.53-1.53a) Switched to TableLayout

1.54) Add Gen3 dates based off the sheet. This information MIGHT NOT BE CORRECT and thus will not be published to the Play Store until confirmed

1.6) Added in Gen 2.5 and Gen 3 products. The first half of the j2g page works (converting julian to calendar dates) but not yet the addition bit on the bottom.

1.61) Added the j2g conversion / calculator page

1.62) Fixed a 'bug' causing everything after Bacon to be 14 days higher than
it should have been.
Fixed the formatting for the initial Julian display.
Corrected Joy Cones to +24M (previously +18M). Corrected Sausage/Pepp to
include 4 hours of thaw time.
Corrected SoftServe/SmoothieBase to show 2 stickers as x+3 and x+10 (was
previously incorrect, only 1 at x+10).
Removed Nonfat Yogurt (I'm told it is no longer used in the kitchens)
Corrected Kolaches to show that they need 3 dates (x, x+1, x+6).
Added Helpdesk phonenumber.
Removed time display from several items that didn't need it.

1.63) I introduced a NEW off-by-7 error when I added the SoftServeOPEN text. Oops.

1.64a) Pre-emptive update. These are the plans for 1.64 as filled in by
comments. Will do my best to actually get these done tomorrow.
-Added
Lettuce bags, tomato packs, milk for concordia machine, cinnamon rolls,
cream cheese icing.
-Updated
Honey Mustard now gets 30 days, up from 15.
Chipotle now specifies 21 days or MFG+180D.
Removed the 5 hours from Kolaches. CD guide doesn't specify that it
needs this, so I'm trying to mirror it.
Added some clarity to Gravy and Scrambled Eggs to show the difference
between shelf and opened.
-Removed
Espresso BiB entry.

Added a new entry up top to show the CD Guide Date that was used for the
app so users can know if the app doesn't get updated for a while.

1.64b) Actually made the changes from previous planned commit in 1.64a

1.7) Broke out several of the cheater textviews into their own separate views (eggs, gravy, frozen lemonades).
Added toggle buttons for Gen2 and Gen3 julian / gregorian in MainActivity.
Added the actual functions to handle swapping.
Updated the setDates functions to handle swapping.
Added 2 new checkboxes in setting to handle default values for gen2jul and gen3jul.