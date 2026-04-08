# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

DX Tests App — a Vaadin Flow application for developer experience testing. Uses a Spring Boot backend (Java 21) with server-side Java views.

## Tech Stack

- **Backend:** Spring Boot 4.x, Java 21, Vaadin 25.x (Flow)
- **Build:** Maven with vaadin-maven-plugin (handles frontend build automatically)
- **Theme:** Lumo (loaded using `@StyleSheet` annotation)

## Build & Run Commands

```bash
./mvnw                  # Run dev server (default goal: spring-boot:run)
./mvnw clean package    # Production build
```

The app runs at http://localhost:8080.

## Architecture

**Flow views** are server-side Java classes annotated with `@Route`:
- `FlowView.java` → `/flow`

**Frontend assets:** The `vaadin-maven-plugin` generates frontend resources into `src/main/frontend/generated/` (gitignored). Do not edit these files.

## Key Paths

- `src/main/java/com/example/application/` — Java backend (Spring Boot app, Flow views)
- `src/main/resources/application.properties` — server configuration
- `pom.xml` — Maven config, Vaadin version defined in `<vaadin.version>` property
