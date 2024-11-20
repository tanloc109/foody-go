@echo off
setlocal enabledelayedexpansion

docker-compose down -v
docker-compose up mysql mongodb redis zookeeper -d

set BASE_DIR=%~dp0services
REM set SERVICES=config-server discovery gateway inventory-service location-service notification-service order-service payment-service restaurant-service shipping-service user-service
set SERVICES=config-server discovery gateway shipping-service

for %%S in (%SERVICES%) do (
    echo Building %%S...
    if exist "%BASE_DIR%\%%S\target" (
        rmdir /s /q "%BASE_DIR%\%%S\target"
        echo Removed target directory for %%S.
    )
    start cmd /C "cd %BASE_DIR%\%%S && mvn clean package -Dmaven.test.skip"
)

echo Are the other windows closed? (Wait until then)
PAUSE
set MISSING_JARS=
for %%S in (%SERVICES%) do (
    if not exist %BASE_DIR%\%%S\target\*.jar (
        set MISSING_JARS=!MISSING_JARS! %%S
    )
)

if defined MISSING_JARS (
    echo Missing JAR files for the following services: %MISSING_JARS%
    echo Docker Compose might fail.
)

echo Running Docker Compose...
docker-compose up -d --build

PAUSE
