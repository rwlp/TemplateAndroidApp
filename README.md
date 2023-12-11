# Template Android Java App

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [For the Next Commit](#for-the-next-commit-)
- [License](#license)

## Introduction

This code is an app with a basic structure. The main goal of this code is to showcase my skills in MVVM architecture.
This app doesn't have practical use, but it can be used to start a real application.

## Features

These are features in this commit:

- Bottom Navigation
  - A bottom bar that controls the content in the center screen.
- TopBar
  - A top bar with Logo and a simple Menu.
- Navigation Drawer
  - A Drawer Navigation with options Menu.

## Architecture

The architecture of this project uses MVVM pattern and simple modularization.
There are 5 main packages:
- datamodel: This package contains classes with data structures used in the views.
- di: There are the modules and interfaces used by Dagger lib for Dependency Injection in the entire project.
- databaserepository: Responsible for fetching data from the database.
- viewmodel: For each view in the project, there exists a viewmodel class responsible for treating data and displaying this data to view classes.
- views: Activities and Fragment classes are in this package. Every UI component of the framework is in these classes and just in these classes.


## Getting Started

To run this project, it is recommended to use Android Studio Hedgehog | 2023.1.1.
See the android manifest for more details of the device's operating system and other technical information's.

## Contributing

Feel free to contribute to this project through comments; all suggestions will be implemented after thorough analysis.

## For the Next Commit ...

In the next commit, we will implement the RecyclerView UI component, use Dagger for Dependency Injection (DI), and add code in all packages.

## License

This code is free to use; however, I kindly request that you please give credit when using it.