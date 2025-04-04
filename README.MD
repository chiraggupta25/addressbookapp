# PagerDuty Client: AddressBookApp

A simple and efficient Java application for interacting with PagerDuty's Users API, built using Apache Maven.

## Overview

The primary goal of this project was to leverage Core Java extensively. Being primarily a backend-focused engineer, I've designed this application with a Console User Interface (CUI). Although various frameworks exist to create visually appealing interfaces, I chose a straightforward, console-based UI using familiar technologies, with an interest in exploring other frameworks in the future.

I have structured the project around the Model-View design pattern as much as possible, aiming for modularity and clear separation of concerns. While there's room for further refinement and cleaner architecture, the current design represents a balance between clarity and practical development effort.

## Features

- **Core Java Implementation:** Minimal dependencies and maximal use of Core Java.
- **Console-Based UI:** Navigate effortlessly using keyboard shortcuts:
  - `n` or `N`: Next page
  - `p` or `P`: Previous page
  - Type a name to query a specific user
  - `e` or `exit`: Exit the application
- **Simple Configuration:** Uses a configuration file (`application.properties`) to reduce user input complexity and avoid potential typos.
- **Modern Dependencies:** Actively maintained with the latest libraries.

## How to Build

Ensure you have Maven installed and configured.

Run the following command from the project root:

```bash
mvn clean compile assembly:single
```

## How to Run

After building, execute the application with:

```bash
java -jar target/demo-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Technology Stack

- Java (minimum version required: **21**, current tested version: **23.0.2**)
- Apache Maven **3.9.9**

## Testing

This project currently has a lightweight testing suite. Expanding test coverage can enhance robustness and reliability.

## Future Scope

- Explore sophisticated UI frameworks.
- Enhance the testing suite for greater coverage.
- Further refine the Model-View architecture for improved modularity and maintainability.

Enjoy using AddressBookApp!
