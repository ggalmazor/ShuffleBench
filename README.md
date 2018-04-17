# ShuffleBench

Toolbench to compare shuffling and PRNG algorithm implementations in Java and JavaScript

# Input data

The input data is a text file at `src/main/resources/data/lemario.txt` with the full 2010 list of 85K words in the Spanish dictionary (one word per row).

# Shuffling in JavaScript

0. Run `npm install`
1. Take a look to the list of shuffling and PRNG libs included in the `package.json` file.
2. Add any library with `npm install <module> --save` or implement yours.
3. Modify the scripts at `src/main/js` to use these libraries or your code.
4. Run them and store the results

# Shuffling with Java

1. Modify the classes at `src/main/java`
2. Run them and store the results

# Simple test: First ten lines using a fixed seed

Play with the algorithms and get them to produce the same list of lines.

- `src/main/js/shuffle_one.js`
- `src/main/java/ShuffleOne.java`

Run them and compare the output text.

# Simple test: Whole file, 100 seeds

Play with the algorithms and get them to produce the same files.

- `src/main/js/shuffle_one.js`
- `src/main/java/ShuffleOne.java`

Run them (first the JS version) and compare the output folders `src/main/resources/shuffle/js` and `src/main/resources/shuffle/java` with a tool like [Meld](http://meldmerge.org/).

If there is no difference on any file, you have successfully implemented cross-platform shuffling and PRNG algorithms.

 