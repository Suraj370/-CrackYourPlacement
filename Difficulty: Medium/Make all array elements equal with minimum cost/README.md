<h2><a href="https://www.geeksforgeeks.org/make-array-elements-equal-minimum-cost/">Make all array elements equal with minimum cost</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;"><span style="font-size: 18px;">Given an array which contains integer values, we need to make all values of this array equal to some integer value with minimum cost where the cost of changing an array value x to y is abs(x-y). </span></span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong> arr[] = [1, 100, 101]
<strong>Output:
</strong>100<strong>
Explanation:
</strong>We can change all its values to 100 with minimum cost,
|1 - 100| + |100 - 100| + |101 - 100| = 100<br></span></pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>arr[] = [4, 6]
<strong>Output:
</strong>2<strong>
Explanation:
</strong>We can change all its values to 5 with minimum cost,
|4 - 5| + |5 - 6| = 2</span></pre>
