# Competitive Programming


### USACO Contest Solutions

All problems are grouped by division, then sorted chronologically by date written (latest first).

#### Bronze
| Contest Date | Problem ID | Problem Name | Notes | Score |
|---|---|---|---|---|
| December 2018 | [backforth](/contests/2018dec/bronze/src/mixmilk.java)| Back and Forth | [Simulation](https://usaco.jeffkmeng.com/contests/2018dec/bronze/backforth.html) | 10/10 |
| December 2018 | [blist](/contests/2018dec/bronze/src/mixmilk.java)| The Bucket List | [Sweep](https://usaco.jeffkmeng.com/contests/2018dec/bronze/blist.html) | 10/10 |
| December 2018 | [mixmilk](/contests/2018dec/bronze/src/mixmilk.java)| Mixing Milk | [Simulation](https://usaco.jeffkmeng.com/contests/2018dec/bronze/mixmilk.html) | 10/10 |
| November 2012 | [cowfind](/contests/2012nov/bronze/src/Cowfind.java)| Find the cow! | [Sweep](https://usaco.jeffkmeng.com/contests/2012nov/bronze/cowfind.html) | 10/10* |
| November 2012 | [typo](/contests/2012nov/bronze/src/Typo.java)| Typo | [Sweep](https://usaco.jeffkmeng.com/contests/2012nov/bronze/typo.html) | 10/10* |

#### Silver
| Contest Date | Problem ID | Problem Name | Notes | Score |
|---|---|---|---|---|
| January 2019  | [mountains](/contests/2019jan/silver/src/mountains.java)| Mountain View | [Sweep](https://usaco.jeffkmeng.com/contests/2019jan/silver/mountains.html) - WIP| 10/10 |
| January 2019  | [perimeter](/contests/2019jan/silver/src/perimeter.java)| Icy Perimeter | [DFS Floodfill](https://usaco.jeffkmeng.com/contests/2019jan/silver/perimeter.html) - WIP | 10/10 |
| January 2019  | [planting](/contests/2019jan/silver/src/planting.java)| Planting Grass | Sweep | 9/10 |
| December 2018 | [mooyomooyo](/contests/2018dec/silver/src/mooyomooyo.java)| Mooyo Mooyo | [DFS Floodfill](https://usaco.jeffkmeng.com/contests/2018dec/silver/mooyomooyo.html) | 10/10 |
| December 2018 | [convention2](/contests/2018dec/silver/src/convention2.java)| Convention 2 | [Simulation](https://usaco.jeffkmeng.com/contests/2018dec/silver/convention2.html) | 10/10 |
| December 2012 | [wifi](/contests/2012dec/silver/src/wifi.java) | Wifi Setup | DP                                                           | 10/10* |


#### Gold

| Contest Date | Problem ID | Problem Name | Notes | Score |
|---|---|---|---|---|
| January 2019  | [mountains](/contests/2019jan/silver/src/mountains.java)| Mountain View | [Sweep](https://usaco.jeffkmeng.com/contests/2019jan/silver/mountains.html) - WIP| 10/10 |


### Common Problems


### Notes

Small notes about organization.

**Website:** I also host the usaco solutions, along with the problem
statements, as a website [here](https://usaco.jeffkmeng.com) hosted
by github pages from this repository.

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



**\*** denotes a score that was not acheived during a contest. Either the program was revised after the contest to get a better score, or the program was written after the contest.