# Solving Cryptarithmetic Puzzles
ewspapers and magazines often have crypt-arithmetic puzzles of the form:
```
  SEND
+ MORE
--------
 MONEY
--------
```
 The goal here is to assign each letter a digit from 0 to 9 so that the arithmetic works out correctly. The rules are that all occurrences of a letter must be assigned the same digit, and no digit can be assigned to more than one letter.

* First, create a list of all the characters that need assigning to pass to Solve
* If all characters are assigned, return true if puzzle is solved, false otherwise
* Otherwise, consider the first unassigned character
* for (every possible choice among the digits not in use)
* If all digits have been tried and nothing worked, return false to trigger backtracking
