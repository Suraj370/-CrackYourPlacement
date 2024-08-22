<h2><a href="https://www.geeksforgeeks.org/boyer-moore-algorithm-for-pattern-searching/">Search Pattern (Boyer Moore Algorithm)</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a text <strong>text txt[0..n-1]  </strong> and pattern  <strong> pat[0..m-1] </strong>where n is the length of the text and m is the length of the pattern, write a function <strong> search(char pat[], char txt[])</strong> that prints all occurrences  of pat[] in txt[]. You may assume that n > m.</span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input</strong>: 
txt[] = “THIS IS A TEST TEXT”<br>pat[] = “TEST” <br><strong>Output:</strong> <br> Pattern found at index 10
</span></pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
 txt[] = “AABAACAADAABAABA”<br>pat[] = “AABA”
<strong>Output:</strong> <br> Pattern found at index 0 <br> Pattern found at index 9 <br> Pattern found at index 12
</span></pre>
