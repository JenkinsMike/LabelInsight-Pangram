# Problem 1 - Missing Letters

## App Execution
There are two ways to run this app, each behaving slightly differently as explained in the
input text prompt.  You can run this app from the Kotlin class "PangramsApplication" or 
the Kotlin class "Pangram".  Each will prompt for input.  One version will ask for one 
input string and execute.  The other will prompt for input and execute, but then prompt for
another input string.  It will continue to execute until prompted to "quit".

### Assignment
The sentence "A quick brown fox jumps over the lazy dog" contains every single letter in
the alphabet. Such sentences are called pangrams. You are to write a method
getMissingLetters, which takes as input a string containing a sentence and returns all
the letters not present at all in the sentence (i.e., the letters that prevent it from being a
pangram). You should ignore the case of the letters in sentence, and your return should
be all lower case letters, in alphabetical order. You should also ignore all non-alphabet
characters as well as all non-US-ASCII characters.

Imagine that the method you write will be called many thousands of times in rapid
succession on strings with length ranging from 0 to 50. Accordingly, you should try to
write code that runs as quickly as possible. Also, imagine the case when the input string
is quite large (e.g., tens of megabytes). See if you can develop an algorithm that
handles this case efficiently while still running very quickly on smaller inputs.

Examples:
1. "A quick brown fox jumps over the lazy dog" returns: 

        "" 
   1. as this sentence contains every letter.
   
2. "A slow yellow fox crawls under the proactive dog" returns: 

        "bjkmqz"

3. "Lions, and tigers, and bears, oh my!" returns: 

        "cfjkpquvwxz"

4. "" returns: 
        
        "abcdefghijklmnopqrstuvwxyz"

>Note that in the examples, the double quotes should not be considered part of the input or output strings.