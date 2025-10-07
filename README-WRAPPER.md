How to generate Maven Wrapper and build (CorridaBaratas project)

This project includes `mvnw` and `mvnw.cmd` scripts but may be missing the `maven-wrapper.jar` binary. To ensure the Maven wrapper works on your machine, please follow one of the options below.

Option A — If you have system Maven installed (recommended):
1. Open PowerShell and run:

   Set-Location -Path 'd:\Downloads\Work\CorridaBaratas-main'
   mvn -N io.takari:maven:wrapper

   This will create `.mvn/wrapper/maven-wrapper.jar` and `.mvn/wrapper/maven-wrapper.properties` (or update them).

2. Now run the wrapper to build:

   .\mvnw.cmd -DskipTests package

Option B — If you don't have system Maven but have Java installed:
- Install Maven or ask someone who has maven to generate the wrapper. The project requires JDK 21 (set JAVA_HOME to your JDK 21 installation path) before running the wrapper.

Notes:
- Ensure JAVA_HOME is set to a valid JDK installation. On Windows PowerShell:

   $env:JAVA_HOME = 'C:\Program Files\Java\jdk-21'
   $env:Path = $env:JAVA_HOME + '\bin;' + $env:Path

- After the wrapper is present, you can build with:

   .\mvnw.cmd -DskipTests package

If you'd like, I can add the wrapper jar into the repo for you — but usually generating it locally is preferred.
