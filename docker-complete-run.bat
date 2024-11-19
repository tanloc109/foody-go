@echo off
setlocal enabledelayedexpansion

REM Define base directory and list of services
set BASE_DIR=%~dp0services
set SERVICES=config-server discovery gateway inventory-service location-service notification-service order-service payment-service restaurant-service shipping-service user-service
# set SERVICES=config-server

REM Loop through each service and build sequentially
for %%S in (%SERVICES%) do (
    echo Building %%S...
    start cmd /C "cd %BASE_DIR%\%%S && mvn clean package"
)

echo Are the other windows closed? (Wait until then)
PAUSE
REM Validate if JAR files are present for each service
set MISSING_JARS=
for %%S in (%SERVICES%) do (
    if not exist %BASE_DIR%\%%S\target\*.jar (
        set MISSING_JARS=!MISSING_JARS! %%S
    )
)

REM Print the result of missing JAR files
if defined MISSING_JARS (
    echo Missing JAR files for the following services: %MISSING_JARS%
    echo Docker Compose might fail.
)

echo Running Docker Compose...
docker-compose up -d --build

PAUSE
