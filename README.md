# ToDoApp

Daily Activities Tracker (To Do App)

 ## Pages  
   ### Page 1 :
   Login Page with <br>
    Username ====> bond007 <br>
    Password ====> james <br>
    

![Screenshot from 2021-07-07 12-02-54](https://user-images.githubusercontent.com/67573209/124711233-71b91c80-df1b-11eb-959e-19961ab93d3a.png)



## Key Features of the First Page :
### 1. Submit Button has a hover effect <br>
   #### (a). On Hovering : <br>
        Background Color : White 
        Cursor : Hand Cursor 
        Foreground Color : Black 
### 2. Text Field For Username and Password
### 3. Process Indicator 
  #### (a). On Clicking Submit Button :
         The Label "Processing Your Request" is visible and  
         after 1 sec the Label text changes to "Login Successul"


# File Handling ::
Custom File handler for to-do app. <br>

### Usage:
import the FileHandler class*<br>
`import FileHandler.*;`<br>
create FileHandler Object*<br>
`FileHandler handler = new FileHandler("file_name");`<br>

### Available methods:
*read()* method : Returns contents of the file as a String.<br>
`handler.read();`<br>
*readLines()* method : Returns an array of Strings in which each element represents a line.<br>
`handler.readLines();`<br>
*write(String line)* method : Write a String(new-line) at the end of the file.<br>
`handler.write("Hello World");`<br>
*writeLines(String[] lines)* method  : Writes an array of String to the file with each element representing a new-line.<br>
`handler.writeLines({"Hello", "World"});`<br>
*deleteLine(int index)* method : Deletes the line at the given index. <br>
`handler.deleteLine(1);<br>

