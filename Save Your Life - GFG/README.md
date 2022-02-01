# Save Your Life
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a string&nbsp;<strong>W</strong>, integer array <strong>B</strong> and character array <strong>X</strong>. Find a substring which has the sum of the ASCII values of its every character, as maximum. ASCII values of some characters&nbsp;are redefined.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
W = abcde
N = 1
X[] = { 'c' }
B[] = { -1000 }
<strong>Output:</strong>
de
<strong>Explanation:
</strong>Substring "de" has the
maximum sum of ascii value,
including c decreases the sum value</span>
</pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
W = dbfbsdbf 
N = 2
X[] = { 'b','s' }
B[] = { -100, 45  }
<strong>Output:</strong>
sd
<strong>Explanation:
</strong>Substring "sd" has the maximum
sum of ascii value, including 'b'
decreases the sum value</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>maxSum()</strong>&nbsp;which takes&nbsp;string <strong>W</strong>, character array <strong>X</strong>, integer array <strong>B</strong>, integer <strong>N</strong> as length of array <strong>X</strong> and <strong>B</strong>&nbsp;as input parameters and returns the substring with the maximum sum of ascii value.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity: </strong>O(|W|)<br>
<strong>Expected Auxiliary Space: </strong>O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong></span></p>

<p><span style="font-size:18px">1&lt;=|W|&lt;=100<br>
1&lt;=|X|&lt;=10<br>
-1000&lt;=B<sub>i</sub>&lt;=1000</span></p>

<p><span style="font-size:18px">Each character of W and A will be from ‘a’-‘z’ , ‘A’-‘Z’.</span></p>
 <p></p>
            </div>