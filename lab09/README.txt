## IntelliJ Successful Tests (JMH)

For this lab, I wanted to measure the difference in speed between the various string comparison methods in Java.  

I created a string the size of one million characters and compared them one million times for each method.  

The methods I was testing were:  
  
- ==  
- str.equals()  
- str.contentEquals()  
- str.compareTo()  
- str.compareToIgnoreCase()  

  
This screenshot shows my:  
  
- pom.xml file  
- output from the JMH testing  
- code  

![JMH Tests](assets/intellij.png)

## Screenshot of Full Code

![Code](assets/code.png)