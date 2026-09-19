@echo off
setlocal
call gradlew.bat :refinedstorage-neoforge:build :refinedstorage-jei-integration-neoforge:build
if errorlevel 1 exit /b %errorlevel%
echo.
echo NeoForge build complete.
echo Main JAR: refinedstorage-neoforge\build\libs
echo JEI JAR:  refinedstorage-jei-integration-neoforge\build\libs
