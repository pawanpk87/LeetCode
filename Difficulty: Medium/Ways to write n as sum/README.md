<h2><a href="https://www.geeksforgeeks.org/problems/ways-to-write-n-as-sum-1587115621/1">Ways to write n as sum</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a positive integer n, the task is to find the number of different ways in which <strong>n </strong>can be written as a sum of two or more positive integers. Return the answer with the modulo 10<sup>9</sup>+7.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>n = 5
<strong>Output: </strong>6<strong>
Explanation: </strong>1+1+1+1+1, 1+1+1+2, 1+1+3, 1+4, 2+1+2 and 2+3. So, a total of 6 ways.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>n = 3
</span><span style="font-size: 18px;"><strong>Output: </strong>2<br><strong style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">Explanation: </strong><span style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">1+1+1 and 1+2.  So, a total of 6 ways.</span>
</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity: </strong>O(n^2)<br><strong>Expected Auxiliary Space: </strong>O(n)<br></span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= n &lt;= 10<sup>3</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;<code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;