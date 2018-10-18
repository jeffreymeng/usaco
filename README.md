# USACO

My solutions to [USACO](http://usaco.org) contests and training problems.

### Contest Solutions

| Contest Date | Problem Division | Problem ID | Problem Name | Notes | Score |
|---|---|---|---|---|---|

-----

### Notes

Small notes about organization that are not at all necessary to be read.

**Template:** [Template.java](/Template.java) is a template file I use
for most problems (where the input is short enough to allow it). The input is
in the main method, then passed on to `solve`, which computes the solution
and then returns the output as an array of strings (each
string is a line of output) to `main`. This is done for readability and 
also so multiple test cases can be tested locally easily when necessary.

**File Structure:** I create a new Intellij project for each division and contest
so it's easy to debug. Files are organized like this:
`/contests/yearmonth/division/src/Problem.java`, with the   `division`
folder as the base for an Intellij project. You can usually find
 test input and output here. If you are in the division folder,
simply navigate to`src` within that folder
to view the solutions for that contest and division.

**Problem Difficulty:** The Platinum division was not created until the 2015-16 season,
thus solutions listed as bronze below from before 2015-16 are 
generally equivalent in terms of difficulty to problems 
from the Silver division 2015-16 season and after.

**Purpose of solutions:** Solutions to contests Dec 2018 and later
 have been submitted to a contest during it's session, 
 while solutions to contests before have been done as 
 practice and submitted in analysis mode.