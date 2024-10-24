<h2><a href="https://www.geeksforgeeks.org/problems/interesting-queries4742/1">Interesting Queries</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array nums<strong>&nbsp;</strong>of n&nbsp;elements and q queries . Each query consists of two integers l and r .&nbsp;You task is to find&nbsp;the number of elements of nums[]&nbsp;in range [l,r] which&nbsp;occur atleast k&nbsp;times.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>nums = {1,1,2,1,3}, Queries = {{1,5},
{2,4}}, k = 1
<strong>Output: </strong>{3,2}
<strong>Explanation: </strong>For the 1st query, from l=1 to r=5
1, 2 and 3 have the frequency atleast 1.
For the second query, from l=2 to r=4, 1 and 2 have 
the frequency atleast 1.</span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>nums = {1,2,3,1}, Queries = {{1,4},
{2,4},{4,4}, k = 2
<strong>Output: </strong>{1,0,0}
<strong>Explanation: </strong>For the 1st query, from l=1 to r=4
1 have the frequency atleast 2.
For the second query, from l=2 to r=4, no number has 
the frequency atleast 2.
For the third query, from l=4 to r=4, no number has 
the frequency atleast 2.</span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong></span></p>

<p><span style="font-size:18px">Your task is to complete the function&nbsp;<strong>solveQueries()&nbsp;</strong>which takes nums, Queries and k as input parameter and returns a list containg the answer for each query.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(n*sqrt(n)*log(n))<br>
<strong>Expected Space Compelxity:&nbsp;</strong>O(n)</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n, no of Queries, k &lt;= 10<sup>4</sup><br>
1 &lt;= nums[i] &lt;= 10<sup>3</sup></span></p>

<p><span style="font-size:18px">1 &lt;= Queries[i][0] &lt;= Queries[i][1] &lt;= n</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Map</code>&nbsp;<code>Sqrt Decomposition</code>&nbsp;<code>Data Structures</code>&nbsp;