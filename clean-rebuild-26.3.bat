@echo off
setlocal
cd /d "%~dp0"

echo [1/4] Stopping Gradle daemons...
call gradlew.bat --stop

echo [2/4] Removing project build caches...
if exist .gradle rmdir /s /q .gradle
for /d %%D in (*) do (
    if exist "%%D\build" rmdir /s /q "%%D\build"
)
if exist "build-logic\refinedarchitect\build" rmdir /s /q "build-logic\refinedarchitect\build"

echo [3/4] Refreshing dependencies...
call gradlew.bat --refresh-dependencies help
if errorlevel 1 goto :fail

echo [4/4] Building NeoForge 26.3...
call gradlew.bat build --stacktrace
if errorlevel 1 goto :fail

echo.
echo BUILD SUCCESSFUL
exit /b 0

:fail
echo.
echo BUILD FAILED - copy the first compiler error and send it back.
exit /b 1
