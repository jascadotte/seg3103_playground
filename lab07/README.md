# SpotBugs Analysis

The point of this lab was to do static analysis of java code using the tool SpotBugs.

## Compile & Run Code

`./bin/run`  

![Calculator](assets/run_calc.png)

## Run SpotBugs

`java -jar ./lib/spotbugs/lib/spotbugs.jar`

There were 18 bugs to begin with.  

![SpotBugs](assets/initial_errors.png)

## Solve Bugs

I went through the code and refactored to fix each error. Below I have included some screenshots and explanation.  

Useless Condition Error:  

![Useless Condition](assets/err1.png)

![Fix Useless Condition](assets/fix1.png)

![SpotBugs Analysis](assets/analysis1.png)

Duplicate Branches Error:  

![Duplicate Branches](assets/err2.png)

![Fix Duplicate Branches](assets/fix2.png)

![SpotBugs Analysis](assets/analysis2.png)

I refactored the code to deal with each error such as adding static, using parseDouble(), used equals() function instead of ==, etc. I recompiled after each refactoring until I was left with no bugs.  

![SpotBugs Analysis](assets/no_errors.png)
