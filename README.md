# Stopwatch
Time your method calls!

Stopwatch can be used in performance testing method calls. Want to measure the actual time difference between an O(log n) algorithm and one that's O(n)? O(3n) vs O(4n)? Stopwatch can do that for you.

## Usage
Import Stopwatch

```import com.bridgerputnam.stopwatch.Stopwatch```

New up a static Stopwatch instance

```
public class Main {
    static Stopwatch stopwatch = new Stopwatch();
```

Define a method (or two) to test

```
    static String[] words = {"Spam","Ham","Eggs","foo","bar","baz","qux","quux","corge","grault","garply","waldo","fred","plugh","xyzzy","thud"};
    
    static String joinWords(String[] words) {
        String sentence = "";
        for(String s : words) {
            sentence = sentence + s;
        }
        return sentence;
    }

    static StringBuilder sb = new StringBuilder();
    static String joinWordsWithSB(String[] words) {
        for(String s : words) {
            sb.append(s);
        }
        return sb.toString();
    }
```

Pass the method as a lambda to Stopwatch.run, optionally with a number of samples to perform.

```

    public static void main(String[] args) {
        stopwatch.run(() -> joinWords(words), 2);
        stopwatch.run(() -> joinWordsWithSB(words), 2);
    }
}
```

Run the program and check StdOut to see the runtimes!

> Method took 12ms on average, over 2 calls.

> Method took 0ms on average, over 2 calls.