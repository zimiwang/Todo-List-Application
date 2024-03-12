# CS 3321 software engineering individual project from Ziming Wang ![Build Status](https://travis-ci.com/UserZiming/3321-project-Ziming-Wang.svg?token=z93z1poJqyyuph9MohmK&branch=master)

## Table of Contents

  - [Description](#description)
  - [Tests](#tests)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Contributing](#contributing)
  - [Building](#building)
  - [Authors](#authors)
  - [License](#license)
  - [Acknowledgments](#acknowledgments)

## Project name: Todo List Application

## Description 
This personal project is to design and build an independent window-based ToDo List manager. This application can store lists between program executions. The motivation of this application is to make it easier for people to manage and record all tasks, allowing users to respond to each task more quickly.

## Tests
The test part uses Junit unit test. During this period, I followed the TDD method, first constructed the test method, and then completed the corresponding source code.  
During this period, I used JAVA throughout. Since this project only requires MVP features, I have completed testing all the situations I can think of. (Remove getter, setter and all constructors)

## Installation
  1. Clone the repository
  
    git clone https://github.com/UserZiming/3321-project-Ziming-Wang.git
  2. Navigate into the repo
  
    cd 3321-project-Ziming-Wang
  3. Build with gradle
  
    gradle build
## Usage  

1. First, run the java file in the GUI file. The main interface of the Todo list application will appear.  
![gui_11.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_11.png)  
2. Then when you click the "+Add Task" button, a window will pop up. This window asks for the description of the task and how long the due date is.  
![gui_2.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_2.png)  
When inputting the corresponding information, a task will be generated. And there is a selectable point in front of each task. When the task is completed, you can manually click the mark, which means that the task has been completed.  
![gui_3.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_3.png)  
4. When you click the "+Add Project" button, a window will pop up. This window asks for the description of the project and how long the due date is.  
![gui_4.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_4.png)  
5. After clicking the confirm button, a button will appear on the far left of the GUI. This button is the newly generated project.  
![gui_5.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_5.png)  
6. When you click Project again, a window will pop up, which belongs to this project. The "Add Task" button can also be used in this window so that a task belonging to the project will be generated in this new window.  
![gui_6.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_6.png)  
7. When you click the "+Add Task" button, a window will pop up. This window asks for the description of the task and how long the due date is.  
![gui_7.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_7.png)  
8. In this way, all the information of the corresponding tasks can be displayed in the project at the same time.  
![gui_8.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_8.png)  
9. Currently we have an application with tasks and projects added.  
![gui_9.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_9.png)  
10. Click the "Save" button to save all current tasks and projects in the json file.  
![gui_10.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_10.png)  
11. Reopen the Todo list application, you can see that there are no tasks and projects here.  
![gui_11.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_11.png)  
12. Click the "Load" button to add the data saved in the json file to the UI.  
![gui_12.png](https://github.com/UserZiming/3321-project-Ziming-Wang/wiki/gui/gui_12.png)  

## Contributing
All the content in this Todo list application is done by myself. They include:
 * Architectural Vision
 * Project Plan
 * Requirements
 * System Design
 * Ui Design
 * GUI program(Java swing)
 * Source code
 * Junit tests

## Building
Regarding the process of this Todo list application. First of all, I followed the principles of TDD. When I first started working on the logic code part, I would first determine what test types this class would have, and then continue to complete the logic code through this principle. And every time a class is completed, the corresponding test will be completed. Here I choose Junit. Because it is easier for me to choose a test method that uses the Java language to realize my ideas.  
In addition, I used the Facade Pattern as the pattern I want to follow. Because here, I think having a class contains all the methods that can be more easily used. For example, the GUI part. It can also make it easier for me to understand my own code. This can prevent me from making my project difficult to understand because of the complicated relationship between classes.  
I choose Travis CI as my continuous testing tool. Because it can remind me and let me know what went wrong with my project, it is a very useful tool for me.  
Then, I completed the UI part of the code. I use Java Swing to provide a graphical interface for my Todo list application. Due to my personal unfamiliarity with java swing, all my codes are stored in one class. In the end, I found it difficult for me to modify the code of my GUI part because they were bloated. But since I only implemented the code of the MVP feature, this does not affect the user's use. It will affect me by adding new features later. After this situation, I fully understand and understand the need to use different classes and methods to separate each part. This is easy to modify my original code, and it is easy to avoid the occurrence of high aggregation of the program.  
Considering that my program does not need to recreate a new object every time it runs. So I chose to follow and use the singleton pattern. By using the singleton pattern to avoid repeated creation of an object. In this way, the data previously used by the user can be effectively retained.  
After finishing the general content, I started to use jackson and JSON as a way to save tasks and projects. I found it difficult to use Jackson's library for my current project. So I chose to use gradle to build my project. Because gradle can not only automatically give me a test folder, but also automatically add any additional libraries to my project. It makes the build easier.  
In the end, although the methods in all other classes can be obtained from the todo class, I choose to save all tasks and projects as a linked list in the OperationManager class. So when I use Jackson to convert tasks and projects into json files, I use the OperationManager object.  

## Authors

  - **Ziming Wang** - *Provided everything for this project* -


## License
MIT License

Copyright (c) [2020] [Ziming Wang]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Acknowledgments

  - Hat tip to anyone whose code was used
  - Inspiration
  - etc
