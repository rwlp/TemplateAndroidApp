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

This code is an app with a basic structure, not made to be portable for many devices. 
The main goal of this code is to showcase my skills in MVVM architecture.
This app doesn't have practical use, but it can be used to start a real application. 

## Features

- Bottom Navigation
  - A bottom bar that controls the content in the center screen.
- TopBar
  - A top bar with Logo and a simple Menu.
- Navigation Drawer
  - A Drawer Navigation with options Menu.
- Recycler View:
  - A simple RecyclerView with 'endless' scroll area

## Architecture

The architecture of this project uses MVVM pattern and simple modularization.
There are 5 main packages:
- data: This package contains classes that handle data.
- di: There are the modules and interfaces used by Dagger lib for Dependency Injection in the entire project.
- viewmodel: For each view in the project, there exists a viewmodel class responsible for treating data and displaying this data to view classes.
- views: Activities and Fragment classes are in this package. Every UI component of the framework is in these classes and just in these classes.
- utilities: resources used in entire code. 

## Getting Started

To run this project, it is recommended to use Android Studio Hedgehog | 2023.1.1. And API 34. 

## Contributing

Feel free to contribute to this project through comments or pull-requests. 
All suggestions will be implemented after thorough analysis.

## For the Next Commit ...

To the next commit we implement Recycler View in the forms: 
- Stack Cards View,
- Expandable View, 
- Reordering View.

Some data will be fetched from APIs: [Nasa](https://api.nasa.gov/), [CountriesAPI](https://restcountries.com/), [WeatherOpenAPI](https://openweathermap.org/). 

## License

This code is free to use; however, I kindly request that you please give credit when using it.