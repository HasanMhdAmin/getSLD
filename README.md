# **Hostname**
  get the hostname of a URL

## Usage

download the JAR file from `lib/Hostname-1.0-SNAPSHOT.jar` and add it in your project.

`String host = Hostname.getHostname("https://www.example.com");`

## Sample 
suppose you have these URLs:
* https://www.example.com/watch?v=TEST 
* https://en.example.org/wiki/Software 
* one.two.three.four.example.com
* https://www.example.co.uk
* example.com

and you need the output to be only the host name, 
in the previous example the result for all domains should be **`example`**.


## Author 
Hasan Mhd Amin on GitHub [@HasanMhdAmin](https://github.com/HasanMhdAmin) 