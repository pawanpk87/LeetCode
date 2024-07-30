<h2><a href="https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1">0 - 1 Knapsack Problem</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given weights and values of <strong>N</strong> items, put these items in a knapsack of capacity <strong>W</strong> to get the maximum total value in the knapsack. Note that we have only <strong>one quantity of each item</strong>.<br>In other words, given two integer arrays <strong>val[0..N-1]</strong> and <strong>wt[0..N-1]</strong> which represent values and weights associated with <strong>N</strong> items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of <strong>val[]</strong> such that sum of the weights of this subset is smaller than or equal to <strong>W.</strong> You cannot break an item, <strong>either pick the complete item or dont pick it (0-1 property)</strong>.</span></p>
<p><strong><span style="font-size: 18px;">Example 1:</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input:
</span></strong><span style="font-size: 18px;">N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
<strong>Output: </strong>3<br><strong>Explanation: </strong></span><span style="font-size: 18px;">Choose the last item that weighs 1 unit and holds a value of 3.</span><span style="font-size: 18px; font-family: sans-serif;"> </span></pre>
<p><strong><span style="font-size: 18px;">Example 2:</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input:
</span></strong><span style="font-size: 18px;">N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
<strong>Output: </strong>0<br><strong>Explanation: </strong>Every item has a weight exceeding the knapsack's capacity (3).<br></span></pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>Complete the function&nbsp;<strong>knapSack()</strong>&nbsp;which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the&nbsp;<strong>maximum possible</strong>&nbsp;value you can get.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong>&nbsp;O(N*W).<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(N*W)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong></span><br><span style="font-size: 18px;">1 ≤ N ≤ 1000</span><br><span style="font-size: 18px;">1 ≤ W ≤ 1000</span><br><span style="font-size: 18px;">1 ≤ wt[i] ≤ 1000</span><br><span style="font-size: 18px;">1 ≤ v[i] ≤ 1000</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Morgan Stanley</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>Snapdeal</code>&nbsp;<code>Oracle</code>&nbsp;<code>Payu</code>&nbsp;<code>Visa</code>&nbsp;<code>Directi</code>&nbsp;<code>GreyOrange</code>&nbsp;<code>Mobicip</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;