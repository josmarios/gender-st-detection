
## Gender bias checker

This project checks for potential gender bias in web pages.

## Quick start

First, make sure you have the requirements below installed. Then, follow parts 1 and 2.

### Requirements (for running)

* Java(TM) SE Runtime Environment (tested with version 15.0.1)
* Mozilla Firefox (tested with version 84.0.1)

### Part 1: pre-processing

1. Create a working directory (e.g., `/home/user/gender-bias/`, or `C:\gender-bias\`).
2. Inside the working directory, create a `*.txt` file containing a list of URLs regarding the pages you want to check for potential gender bias (see the example `urls-example.txt`).
3. [Click here](https://github.com/josmarios/gender-st-detection/releases/download/v1.0-BETA/StereotypeDetection-1.0-BETA.jar) to download the executable (*.jar file).
4. Execute the command `java -jar <JAR_FILE> <URL_FILE_PATH>` replacing <JAR_FILE> with the executable file (*.jar) and <URL_FILE_PATH> with the file containing the URLs (it MUST be the entire file path, i.e., the working directory plus the URLs filename). Example:

```
   java -jar StereotypeDetection-1.0-BETA.jar /home/user/gender-bias/urls.txt
```

This may take a while depending on the number of URLs.

### Part 2: computing bias

5. Make sure the execution above has terminated
6. Run `java -jar <JAR_FILE> <WORKING_DIRECTORY>` replacing <JAR_FILE> with the executable file (*.jar) and <WORKING_DIRECTORY> with the working directory created in the first step. Example:

```
   java -jar StereotypeDetection-1.0-BETA.jar /home/user/gender-bias/
```

### Results interpretation

After Step 6, a file named `biasdata.csv` will be generated in the working directory. This file will have the following fields:

```
id , red, green, blue, text-f, text-m, color-f, color-m
```

* The first value (id) represents an identifier of a webpage. To check which page it represents, refer to `dictionary.csv` in the working directory.

* The following three values (red, green, and blue) represent averages of each RGB component in a sample of colours extracted from the webpage.

* The last four fields (text-f, text-m, color-f, color-m) represent scores indicating how much each page is 'biased' towards each gender. text-f, and text-m are computed based on the page's text, and color-f, color-m are calculated based on the page's color.

## Help

For more information, please contact jas@ic.ufal.br.
