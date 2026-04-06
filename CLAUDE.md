# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

DX Tests App — a full-stack Vaadin application for developer experience testing. Combines a Spring Boot backend (Java 21) with a React frontend (TypeScript), supporting both Hilla (React) and Flow (Java) views side by side.

## Tech Stack

- **Backend:** Spring Boot 4.x, Java 21, Vaadin 25.x (Flow + Hilla)
- **Frontend:** React 19, TypeScript, Vite, Vaadin React Components
- **Build:** Maven with vaadin-maven-plugin (handles frontend build automatically)
- **Routing:** Hilla file-based router (`src/main/frontend/views/`)
- **Signals:** `@vaadin/hilla-react-signals` (Preact Signals for React)
- **Theme:** Lumo (loaded using `@StyleSheet` annotation)

## Build & Run Commands

```bash
./mvnw                  # Run dev server (default goal: spring-boot:run)
./mvnw clean package    # Production build
```

The app runs at http://localhost:8080.

## Architecture

**Dual rendering modes:** The app uses both Hilla (React) and Flow (server-side Java) views within the same application.

- **React views** use Hilla's file-based routing. Files in `src/main/frontend/views/` map to routes:
  - `@index.tsx` → `/` (home)
  - `@layout.tsx` → root layout (AppLayout with SideNav)
  - `react.tsx` → `/react`
- **Flow views** are Java classes annotated with `@Route`:
  - `FlowView.java` → `/flow`
- **View config:** React views export a `config: ViewConfig` object for metadata like page title.

**Code generation:** The `vaadin-maven-plugin` and Hilla generator produce TypeScript types/endpoints from Java backend code into `src/main/frontend/generated/` (gitignored). `vite.generated.ts` is also auto-generated. Do not edit these files.

## Frontend Conventions

- Use `@vaadin/react-components` for UI (e.g., `VerticalLayout`, `AppLayout`, `SideNav`)
- Use `react-router` for navigation (`NavLink`, `useNavigate`, `useLocation`)
- Prettier config: single quotes, 120 char print width (`.prettierrc`)

## Key Paths

- `src/main/java/com/example/application/` — Java backend (Spring Boot app, Flow views)
- `src/main/frontend/views/` — React views (file-based routing)
- `src/main/resources/application.properties` — server configuration
- `pom.xml` — Maven config, Vaadin version defined in `<vaadin.version>` property
- `package.json` — npm dependencies managed by Vaadin (version overrides section is auto-managed)
